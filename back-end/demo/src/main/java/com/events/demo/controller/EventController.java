package com.events.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.events.demo.model.dtos.EventDTO;
import com.events.demo.service.EventService;

@RestController
@RequestMapping("api/events")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping("/all")
    public List<EventDTO> findall() {
        return service.findAll();
    }

    @GetMapping("/title")
    public EventDTO findByTitle(@RequestParam("title") String title) {
        return service.findEventByTitle(title);
    }

    @GetMapping("/{id}")
    public EventDTO findById(@PathVariable Long id) {
        return service.findEventById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EventDTO create(@RequestBody EventDTO eventDTO) {
        return service.createEvent(eventDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public EventDTO update(@RequestBody EventDTO eventDTO, @PathVariable Long id) {
        return service.updateEvent(eventDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.removeEvent(id);
    }
}
