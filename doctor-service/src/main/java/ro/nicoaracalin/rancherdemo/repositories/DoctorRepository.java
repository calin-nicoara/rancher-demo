package ro.nicoaracalin.rancherdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ro.nicoaracalin.rancherdemo.entities.Doctor;

@RepositoryRestResource(collectionResourceRel = "doctors", path = "/doctors")
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
