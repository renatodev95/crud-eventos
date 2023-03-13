package com.events.demo.model.dtos.mapper;

import org.springframework.stereotype.Component;

import com.events.demo.model.Event;
import com.events.demo.model.dtos.EventDTO;

@Component
public class EventMapper {

    public EventDTO toDTO(Event event) {
        if (event == null) {
            return null;
        }
        EventDTO dto = new EventDTO();
        dto.setId(event.getId());
        dto.setTitle(event.getTitle());
        dto.setDescription(event.getDescription());
        dto.setEventDate(event.getEventDate());
        return dto;
    }

    public Event toEntity(EventDTO eventDTO) {
        if (eventDTO == null) {
            return null;
        }

        Event event = new Event();
        if (eventDTO.getId() != null) {
            event.setId(eventDTO.getId());
        }
        event.setTitle(eventDTO.getTitle());
        event.setDescription(eventDTO.getDescription());
        event.setEventDate(eventDTO.getEventDate());
        return event;
    }
}