package jonas.springframework.springpetclinic.services.map;

import jonas.springframework.springpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    final Long ownerId = 1L;

    final String lastName = "Spock";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService()); // dependency injection
        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build()); // create an owner object
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(id, savedOwner.getId());
   }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner spock = ownerMapService.findByLastName(lastName);
        assertNotNull(spock);
        assertEquals(ownerId, spock.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner foo = ownerMapService.findByLastName("foo");
        assertNull(foo);
    }
}