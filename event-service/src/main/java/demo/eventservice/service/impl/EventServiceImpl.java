package demo.eventservice.service.impl;

import demo.eventservice.client.OrganizerClient;
import demo.eventservice.dto.EventRequest;
import demo.eventservice.dto.OrganizerDTO;
import demo.eventservice.exception.OrganizerNotFoundException;
import demo.eventservice.model.Event;
import demo.eventservice.repository.EventRepository;
import demo.eventservice.service.EventService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final OrganizerClient organizerClient;


    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event createEvent(EventRequest request) {
        if (request.getOrganizerId() == null) {
            throw new OrganizerNotFoundException("Tổ chức không tồn tại hoặc không hợp lệ.");
        }

        try {
            ResponseEntity<OrganizerDTO> organizerResponse = organizerClient.getOrganizerById(request.getOrganizerId());
            if (organizerResponse == null || !organizerResponse.getStatusCode().is2xxSuccessful() || organizerResponse.getBody() == null) {
                throw new OrganizerNotFoundException("Tổ chức không tồn tại hoặc không hợp lệ.");
            }
        } catch (FeignException.NotFound e) {
            throw new OrganizerNotFoundException("Tổ chức không tồn tại hoặc không hợp lệ.");
        }

        Event product = Event.builder()
                .name(request.getName())
                .description(request.getDescription())
                .organizerId(request.getOrganizerId())
                .build();

        return eventRepository.save(product);
    }
}
