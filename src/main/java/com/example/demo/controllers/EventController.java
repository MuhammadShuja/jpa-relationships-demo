package com.example.demo.controllers;

/*
 * Copyright (c) Nisum Pakistan, 2022.
 *
 * @author: Muhammad Shuja, Sr. Software Engineer
 */

import com.example.demo.entities.Event;
import com.example.demo.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> all(){
        return eventService.all();
    }

    @GetMapping("/{id}")
    public Event get(@PathVariable Long id) throws Throwable {
        return eventService.get(id);
    }

    @GetMapping("/id/{eventId}")
    public Event getByEventId(@PathVariable String eventId) throws Throwable {
        return eventService.getByEventId(eventId);
    }
}
