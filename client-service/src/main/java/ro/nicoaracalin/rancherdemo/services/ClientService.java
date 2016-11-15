package ro.nicoaracalin.rancherdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import ro.nicoaracalin.rancherdemo.entities.Client;
import ro.nicoaracalin.rancherdemo.repositories.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @PostConstruct
    public void init() {
        if(clientRepository.findAll().size() == 0) {
            clientRepository.save(Client.builder()
                    .fullName("Popescu Ionut")
                    .birthDate("1960-02-02")
                    .build());

            clientRepository.save(Client.builder()
                    .fullName("Popa Damian")
                    .birthDate("1990-03-02")
                    .build());

            clientRepository.save(Client.builder()
                    .fullName("Luchian Marius")
                    .birthDate("1988-02-02")
                    .build());

            clientRepository.save(Client.builder()
                    .fullName("Todorut Liviu")
                    .birthDate("1984-02-02")
                    .build());
        }
    }
}
