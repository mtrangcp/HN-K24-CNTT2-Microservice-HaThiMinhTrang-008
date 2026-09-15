package demo.eventservice.service;

import demo.eventservice.dto.EventRequest;
import demo.eventservice.model.Event;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents();
    Event createEvent(EventRequest request);
}
