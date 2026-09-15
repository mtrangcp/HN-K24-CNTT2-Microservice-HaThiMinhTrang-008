package demo.organizerservice.service;

import demo.organizerservice.model.Organizer;import java.util.List;
import java.util.Optional;

public interface OrganizerService {
    List<Organizer> getAllOrganizers();
    Optional<Organizer> getOrganizerById(Long id);
    Organizer createOrganizer(Organizer organizer);
}
