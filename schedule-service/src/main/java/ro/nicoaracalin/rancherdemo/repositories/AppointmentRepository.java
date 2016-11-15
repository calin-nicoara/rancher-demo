package ro.nicoaracalin.rancherdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.nicoaracalin.rancherdemo.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
