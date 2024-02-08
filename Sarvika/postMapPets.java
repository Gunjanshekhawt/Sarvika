import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

    @Autowired
    private PetRepository petRepository;

    // API endpoint to add a pet
    @PostMapping("/pets")
    public Pet addPet(@RequestBody Pet pet) {
        return petRepository.save(pet);
    }
}