package demo.organizerservice.service.impl;

import demo.organizerservice.model.Organizer;import demo.organizerservice.repository.OrganizerRepository;import demo.organizerservice.service.OrganizerService;import lombok.RequiredArgsConstructor;import org.springframework.stereotype.Service;import java.util.List;import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService {
    private final OrganizerRepository organizerRepository;

    @Override
    public List<Organizer> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    @Override
    public Optional<Organizer> getOrganizerById(Long id) {
        return organizerRepository.findById(id);
    }

    @Override
    public Organizer createOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }
}
