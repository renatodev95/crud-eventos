package com.events.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.events.demo.exception.RecordNotFoundException;
import com.events.demo.model.dtos.EventDTO;
import com.events.demo.model.dtos.mapper.EventMapper;
import com.events.demo.repository.EventRepository;

@Service
public class EventService {

    private final EventRepository repository;
    private final EventMapper mapper;

    public EventService(EventRepository repository, EventMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public EventDTO createEvent(EventDTO dto) { 
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public List<EventDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    public EventDTO findEventByTitle(String title) {
        return mapper.toDTO(repository.findByTitle(title));
    }

    public EventDTO findEventById(Long id) {
        return repository.findById(id).map(mapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public EventDTO updateEvent(EventDTO updatedEvent, Long id) {
        EventDTO existingEvent = findEventById(id);
        existingEvent.setTitle(updatedEvent.getTitle());
        existingEvent.setDescription(updatedEvent.getDescription());
        existingEvent.setEventDate(updatedEvent.getEventDate());
        return mapper.toDTO(repository.save(mapper.toEntity(existingEvent)));
    }

    public void removeEvent(@PathVariable Long id) {
        repository.delete(repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
