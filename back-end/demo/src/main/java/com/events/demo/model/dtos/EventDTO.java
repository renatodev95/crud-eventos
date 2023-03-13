package com.events.demo.model.dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EventDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDate eventDate;
}
