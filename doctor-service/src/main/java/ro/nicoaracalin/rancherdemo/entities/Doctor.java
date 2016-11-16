package ro.nicoaracalin.rancherdemo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Doctor {

    @Id
    @GeneratedValue(generator = "DOCTOR_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "DOCTOR_SEQ_GEN", sequenceName = "DOCTOR_SEQ", allocationSize = 1)
    private Long id;

    private String fullName;

    private String speciality;
}
