package jonas.springframework.springpetclinic.repositories;

import jonas.springframework.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {}
