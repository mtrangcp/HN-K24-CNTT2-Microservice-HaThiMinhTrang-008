package demo.organizerservice.controller;

import demo.organizerservice.model.Organizer;
import demo.organizerservice.service.OrganizerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizers")
@RequiredArgsConstructor
public class OrganizerController {
    private final OrganizerService organizerService;

    @GetMapping
    public ResponseEntity<List<Organizer>> getAllOrganizers() {
        return ResponseEntity.ok(organizerService.getAllOrganizers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organizer> getOrganizerById(@PathVariable("id") Long id) {
        return organizerService.getOrganizerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Organizer> createOrganizer(@RequestBody Organizer organizer) {
        Organizer savedOrganizer = organizerService.createOrganizer(organizer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrganizer);
    }

}
