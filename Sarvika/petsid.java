import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private EventRepository eventRepository;

    // API endpoint to get a single pet and its events
    @GetMapping("/pets/{id}")
    public PetWithEvents getPetWithEvents(@PathVariable Long id, @RequestParam(required = false) String sortingKey, @RequestParam(required = false) String sortOrder) {
        Pet pet = petRepository.findById(id).orElse(null);

        if (pet != null) {
            List<Event> events = eventRepository.findByPetIdOrderByDateDesc(id);
            // Optionally handle sorting based on sortingKey and sortOrder
            // ...

            return new PetWithEvents(pet, events);
        } else {
            return null; // Handle pet not found
        }
    }
}