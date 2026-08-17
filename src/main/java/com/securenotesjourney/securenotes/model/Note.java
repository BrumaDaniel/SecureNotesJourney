package com.securenotesjourney.securenotes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notes_table")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String noteContent;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Note(Long id, String title, String noteContent, User user) {
        this.id = id;
        this.title = title;
        this.noteContent = noteContent;
        this.user = user;
    }

    public Note() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
