import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

    @Autowired
    private PetRepository petRepository;

    // API endpoint to update a pet
    @PutMapping("/pets/{id}")
    public Pet updatePet(@PathVariable Long id, @RequestBody Pet updatedPet) {
        // Fetch the existing pet
        Pet existingPet = petRepository.findById(id).orElse(null);

        if (existingPet != null) {
            // Update the existing pet with the user's input
            existingPet.setName(updatedPet.getName());
            existingPet.setOwner(updatedPet.getOwner());
            // Update other fields as needed

            return petRepository.save(existingPet);
        } else {
            return null; // Handle pet not found
        }
    }
}