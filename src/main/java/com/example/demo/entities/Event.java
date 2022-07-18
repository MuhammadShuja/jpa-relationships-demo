package com.example.demo.entities;

/*
 * Copyright (c) Nisum Pakistan, 2022.
 *
 * @author: Muhammad Shuja, Sr. Software Engineer
 */

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "events")
@Data
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "event_id")
    String eventId;

    String title;

    String description;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "events_tags",
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    List<Tag> tags;

    public Event(String eventId, String title, String description, List<Tag> tags) {
        this.eventId = eventId;
        this.title = title;
        this.description = description;
        this.tags = tags;
    }
}
