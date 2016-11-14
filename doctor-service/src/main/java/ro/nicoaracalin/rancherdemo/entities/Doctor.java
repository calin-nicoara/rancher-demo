package ro.nicoaracalin.rancherdemo.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Doctor {

    @Id
    private Long id;

    private String fullName;

    private String birthDate;
}
