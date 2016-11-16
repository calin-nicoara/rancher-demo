package ro.nicoaracalin.rancherdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import ro.nicoaracalin.rancherdemo.entities.Doctor;
import ro.nicoaracalin.rancherdemo.repositories.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostConstruct
    public void init() {
        if(doctorRepository.findAll().size() == 0) {
            doctorRepository.save(Doctor.builder()
                    .fullName("Corvescu Darius")
                    .speciality("Ortopedie")
                    .build());

            doctorRepository.save(Doctor.builder()
                    .fullName("Ilie Bogdan")
                    .speciality("Neurologie")
                    .build());
        }
    }
}
