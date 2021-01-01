package jonas.springframework.springpetclinic.repositories;

import jonas.springframework.springpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {}
