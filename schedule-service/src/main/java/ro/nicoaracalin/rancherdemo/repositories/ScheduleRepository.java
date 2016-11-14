package ro.nicoaracalin.rancherdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import ro.nicoaracalin.rancherdemo.entities.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
