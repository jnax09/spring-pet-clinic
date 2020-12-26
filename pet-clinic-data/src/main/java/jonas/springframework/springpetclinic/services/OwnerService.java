package jonas.springframework.springpetclinic.services;

import jonas.springframework.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
