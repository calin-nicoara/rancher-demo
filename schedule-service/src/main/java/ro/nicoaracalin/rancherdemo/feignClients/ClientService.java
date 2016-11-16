package ro.nicoaracalin.rancherdemo.feignClients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name = "client-service")
public interface ClientService {

    @RequestMapping(value="/clients/{client_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Map<String, Object>> getClient(@PathVariable("client_id") Long clientId);
}
