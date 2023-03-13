package com.events.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.events.demo.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
    
    Event findByTitle(String title);
}
