package com.example.demo.config;

/*
 * Copyright (c) Nisum Pakistan, 2022.
 *
 * @author: Muhammad Shuja, Sr. Software Engineer
 */

import com.example.demo.entities.Event;
import com.example.demo.entities.Tag;
import com.example.demo.repos.EventRepository;
import com.example.demo.repos.TagRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataConfig {

    @Bean
    CommandLineRunner commandLineRunner(EventRepository eventRepository,
                                        TagRepository tagRepository) {
        return args -> {
            Tag tag1 = tagRepository.save(new Tag("Sci-Fi", "Lorem ipsum dolor sit amet."));
            Tag tag2 = tagRepository.save(new Tag("Thriller", "Lorem ipsum dolor sit amet."));
            Tag tag3 = tagRepository.save(new Tag("Action", "Lorem ipsum dolor sit amet."));
            Tag tag4 = tagRepository.save(new Tag("Drama", "Lorem ipsum dolor sit amet."));
            Tag tag5 = tagRepository.save(new Tag("Comedy", "Lorem ipsum dolor sit amet."));

            Event event1 = new Event("EVENT_A",
                    "Netflix",
                    "Lorem ipsum dolor sit amet.",
                    List.of(tag1, tag2, tag3));

            Event event2 = new Event("EVENT_B",
                    "HBO",
                    "Lorem ipsum dolor sit amet.",
                    List.of(tag4));

            Event event3 = new Event("EVENT_C",
                    "CW",
                    "Lorem ipsum dolor sit amet.",
                    List.of(tag1, tag3, tag5));

            Event event4 = new Event("EVENT_D",
                    "Arrowverse",
                    "Lorem ipsum dolor sit amet.",
                    List.of());

            eventRepository.saveAll(List.of(event1, event2, event3, event4));
        };
    }
}
