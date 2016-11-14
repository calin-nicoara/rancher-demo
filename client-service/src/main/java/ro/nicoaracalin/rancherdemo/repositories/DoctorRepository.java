package ro.nicoaracalin.rancherdemo.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.nicoaracalin.rancherdemo.entities.Doctor;

@RepositoryRestResource(collectionResourceRel = "doctors", path = "doctors")
public interface DoctorRepository extends PagingAndSortingRepository<Doctor, Long> {
}
