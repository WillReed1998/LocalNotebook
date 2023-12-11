package com.example.JD2HW1518.note;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "title", length = 200)
    private String title;

    @Column(name = "content", length = 1000)
    private String content;
}
