package jonas.springframework.springpetclinic.map;

import jonas.springframework.springpetclinic.model.Speciality;
import jonas.springframework.springpetclinic.services.SpecialtiesService;

import java.util.Set;

public class SpecialtiesServiceMap extends AbstractMapService<Speciality, Long> implements SpecialtiesService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
