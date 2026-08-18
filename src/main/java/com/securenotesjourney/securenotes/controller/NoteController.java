package com.securenotesjourney.securenotes.controller;

import com.securenotesjourney.securenotes.model.Note;
import com.securenotesjourney.securenotes.model.User;
import com.securenotesjourney.securenotes.repository.NoteRepository;
import com.securenotesjourney.securenotes.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteController(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable Long id) {
        return noteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<Note> createNote(@PathVariable Long userId, @RequestBody Note note) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        note.setUser(user.get());
        return ResponseEntity.ok(noteRepository.save(note));
    }

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/search")
    @SuppressWarnings("unchecked")
    public List<Note> searchNotes(@RequestParam String title) {
        String query = "SELECT * FROM notes_table WHERE title = '" + title + "'";
        // [INTENTIONAL VULN #7] SQL injection - user input concatenated into query
        return entityManager.createNativeQuery(query, Note.class).getResultList();
    }
}
