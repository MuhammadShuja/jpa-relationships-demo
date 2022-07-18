package com.example.demo.services;

/*
 * Copyright (c) Nisum Pakistan, 2022.
 *
 * @author: Muhammad Shuja, Sr. Software Engineer
 */

import com.example.demo.entities.Event;
import com.example.demo.repos.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> all(){
        return eventRepository.findAll();
    }

    public Event get(Long id) throws Throwable {
        return eventRepository.findById(id)
                .orElseThrow((Supplier<Throwable>) () -> new RuntimeException("Resource not found"));
    }

    public Event getByEventId(String eventId) throws Throwable {
        return eventRepository.findByEventId(eventId)
                .orElseThrow((Supplier<Throwable>) () -> new RuntimeException("Resource not found"));
    }
}
