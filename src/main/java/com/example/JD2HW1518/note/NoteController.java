package com.example.JD2HW1518.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public String getAllNotes(Model model) {
        List<Note> notes = noteService.findAll();
        model.addAttribute("notes", notes);
        return "note/list";
    }

    @PostMapping("/delete")
    public String deleteNoteById(@RequestParam String id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/add")
    public String addNotePage(Model model) {
        model.addAttribute("newNote", new Note());
        return "note/add";
    }
    @PostMapping("/add")
    public String addNewNote(@ModelAttribute Note newNote) {
        noteService.save(newNote);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String getEditNotePage(@RequestParam Long id, Model model) {
        Note note = noteService.findById(id);
        model.addAttribute("note", note);
        return "note/edit";
    }

    @PostMapping("/edit")
    public String editNote(@ModelAttribute Note note) {
        noteService.save(note);
        return "redirect:/note/list";
    }
}