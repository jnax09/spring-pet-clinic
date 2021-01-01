package jonas.springframework.springpetclinic.repositories;

import jonas.springframework.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {}
