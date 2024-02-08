import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    private PetRepository petRepository;

    // API endpoint to list all pets
    @GetMapping("/pets")
    @ResponseBody
    public List<Pet> listPets(@RequestParam(required = false) String species) {
        if (species != null) {
            return petRepository.findBySpecies(species);
        } else {
            return petRepository.findAll();
        }
    }
}