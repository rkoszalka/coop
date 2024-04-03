package org.koszalka.coop.api.v1;

import org.koszalka.coop.dto.AgendaDTO;
import org.koszalka.coop.entities.AgendaEntity;
import org.koszalka.coop.repositories.AgendaRepository;
import org.koszalka.coop.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/agenda")
public class AgendaController {

    private final AgendaService agendaService;

    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @PostMapping("/create-agenda")
    public ResponseEntity<AgendaEntity> createAgenda(@RequestBody AgendaDTO agendaDTO) {
        AgendaEntity agendaEntity = agendaService.createNewAgenda(agendaDTO);
        return new ResponseEntity<>(agendaEntity, HttpStatus.CREATED);
    }


}
