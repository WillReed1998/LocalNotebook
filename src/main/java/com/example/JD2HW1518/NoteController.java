package com.example.JD2HW1518;

import com.example.JD2HW1518.service.Note;
import com.example.JD2HW1518.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public String getAllNotes(Model model) {
        List<Note> notes = noteService.listAll();
        model.addAttribute("notes", notes);
        return "noteList";
    }

    @PostMapping("/add")
    public String addNewNote(@ModelAttribute("note") Note note) {
        noteService.add(note);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String getEditNotePage(@RequestParam("id") long id, Model model) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "editNote";
    }

    @PostMapping("/edit")
    public String editNote(@ModelAttribute("note") Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }

    @PostMapping("/delete")
    public String deleteNoteById(@RequestParam("id") long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
}