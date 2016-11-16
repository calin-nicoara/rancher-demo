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
public class Appointment {

    @Id
    @GeneratedValue(generator = "APPOINTMENT_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "APPOINTMENT_SEQ_GEN", sequenceName = "APPOINTMENT_SEQ", allocationSize = 1)
    private Long id;

    private String name;

    private String clientName;

    private String doctorName;
}
