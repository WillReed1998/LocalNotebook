package com.example.JD2HW1518.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    private final List<Note> notes = new ArrayList<>();
    private int idCounter = 0;
    private long generatedId () {
        return idCounter++;
    };

     public List<Note> listAll() {
        return new ArrayList<>(notes);
    }

    public Note add(Note note) {
        long id = generatedId();
        note.setId(id);
        notes.add(note);
        return note;
    }

    public void deleteById(long id) {
        boolean removed = notes.removeIf(note -> note.getId() == id);
        if (!removed) {
            throw new NullPointerException("Id" + id +"already deleted");
        }


    }

    public void update(Note note) {
        long id = note.getId();
        boolean found = false;

        for (Note existingNote : notes) {
            if (existingNote.getId() == id) {
                existingNote.setTitle(note.getTitle());
                existingNote.setContent(note.getContent());
                found = true;
                break;
            }
        }
        if (!found) {
            throw new NullPointerException("Id" + id + "not found and can't  be updated");
        }
    }

    public Note getById(long id) {
        for (Note note : notes) {
            if (note.getId() == id) {
                return note;
            }
        }
        throw new NullPointerException("Id" + id + "not found");
    }
}
