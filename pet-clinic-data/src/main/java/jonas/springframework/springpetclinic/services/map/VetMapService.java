package jonas.springframework.springpetclinic.services.map;

import jonas.springframework.springpetclinic.model.Speciality;
import jonas.springframework.springpetclinic.model.Vet;
import jonas.springframework.springpetclinic.services.SpecialtyService;
import jonas.springframework.springpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        // defensive coding
        // in case the vet object has a speciality that has not been persisted and therefore does not have an id
        if(object.getSpecialties().size() > 0) {
            object.getSpecialties().forEach(speciality -> {
                if(speciality.getId() == null) {
                    Speciality savedSpeciality = specialtyService.save(speciality); // That would create an id on the specialty
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
