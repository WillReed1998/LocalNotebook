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

    public void save(Note note) {
        if (note == null) {
            throw new IllegalArgumentException("Note cannot be null");
        }
        repository.save(note);
    }

    public void deleteById(long id) {
        repository.deleteById(String.valueOf(id));
    }

    public Note findById(long id) {
        return repository.findById(String.valueOf(id))
                .orElseThrow(() -> new NullPointerException("Id " + id + " not found"));
    }
}
