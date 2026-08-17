package com.securenotesjourney.securenotes.repository;

import com.securenotesjourney.securenotes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
