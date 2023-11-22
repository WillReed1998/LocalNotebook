package com.example.JD2HW1518.service;

//import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@Entity
//@Table(name = "notes")
@Data
public class Note {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Long id;

//    @Column(name = "title", length = 200)
    private String title;

//    @Column(name = "content", length = 1000)
    private String content;
}
