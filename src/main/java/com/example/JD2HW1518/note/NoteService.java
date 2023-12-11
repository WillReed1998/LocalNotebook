package com.example.JD2HW1518.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository repository;

     public List<Note> findAll() {
        return repository.findAll();
    }

    public Note save(Note note) {
        if (note == null) {
            throw new IllegalArgumentException("Note cannot be null");
        }
        Note savedNote = repository.save(note);
        return savedNote;
    }

    public Note update(String id, Note updatedNote) {
        if (repository.existsById(id)) {
            updatedNote.setId(id);
            Note savedNote = repository.save(updatedNote);
            return savedNote;
        } else {
            throw new NullPointerException("Note with id " + id + " not found");
        }
    }


    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Note findById(long id) {
        return repository.findById(String.valueOf(id))
                .orElseThrow(() -> new NullPointerException("Id " + id + " not found"));
    }
}
