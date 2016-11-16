package ro.nicoaracalin.rancherdemo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import ro.nicoaracalin.rancherdemo.entities.Appointment;
import ro.nicoaracalin.rancherdemo.feignClients.ClientService;
import ro.nicoaracalin.rancherdemo.feignClients.DoctorService;
import ro.nicoaracalin.rancherdemo.models.AppointmentModel;
import ro.nicoaracalin.rancherdemo.repositories.AppointmentRepository;

@RestController
@RequestMapping("/appointments")
public class AppointmentResource {

    private AppointmentRepository appointmentRepository;
    private ClientService clientService;
    private DoctorService doctorService;

    @Autowired
    public AppointmentResource(AppointmentRepository appointmentRepository, ClientService clientService,
                               DoctorService doctorService) {
        this.appointmentRepository = appointmentRepository;
        this.clientService = clientService;
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<Appointment> postAppointment(@RequestBody AppointmentModel appointmentModel) {
        Long clientId = Long.parseLong(appointmentModel.getClientLink().substring(appointmentModel.getClientLink().lastIndexOf('/')+1));
        Map<String, Object> clientBody = clientService.getClient(clientId).getBody();

        Long doctorId = Long.parseLong(appointmentModel.getDoctorLink().substring(appointmentModel.getClientLink().lastIndexOf('/')+1));
        Map<String, Object> doctorBody = doctorService.getDoctor(doctorId).getBody();

        Appointment appointment = appointmentRepository.save(Appointment.builder()
                .name(appointmentModel.getName())
                .clientName(clientBody.get("fullName").toString())
                .doctorName(doctorBody.get("fullName").toString())
                .build());

        return ResponseEntity.ok(appointment);
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAppointments() {
        return ResponseEntity.ok(appointmentRepository.findAll());
    }
}
