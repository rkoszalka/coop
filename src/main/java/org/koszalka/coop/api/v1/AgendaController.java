package org.koszalka.coop.api.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/agenda")
public class AgendaController {

    @PostMapping("/create-agenda")
    public ResponseEntity<String> createAgenda() {
        return new ResponseEntity<>("Create Agenda", HttpStatus.OK);
    }

}
