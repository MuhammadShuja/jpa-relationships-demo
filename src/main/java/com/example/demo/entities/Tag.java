package com.example.demo.entities;

/*
 * Copyright (c) Nisum Pakistan, 2022.
 *
 * @author: Muhammad Shuja, Sr. Software Engineer
 */

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
@Data
@NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String description;

    @JsonBackReference
    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    List<Event> events;

    public Tag(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
