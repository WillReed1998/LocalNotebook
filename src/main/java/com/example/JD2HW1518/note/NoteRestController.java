package com.example.JD2HW1518.note;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/notes")
public class NoteRestController {

    private final NoteService noteService;

    @GetMapping("/list")
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteService.findAll();
        if (notes.isEmpty()) {
            return new ResponseEntity<>(notes, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<Note> createNote(@RequestBody Note note) {
        return ResponseEntity.ok(noteService.save(note));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getById(@PathVariable("id") Long id) {
        Note note = noteService.findById(id);
        if (note == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    ResponseEntity<Note> editNote(@PathVariable String id, @RequestBody Note note) {
        return ResponseEntity.ok(noteService.update(id, note));
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable String id) {
        noteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
