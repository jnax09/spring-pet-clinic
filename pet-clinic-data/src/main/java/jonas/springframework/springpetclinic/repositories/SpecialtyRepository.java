package jonas.springframework.springpetclinic.repositories;

import jonas.springframework.springpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
