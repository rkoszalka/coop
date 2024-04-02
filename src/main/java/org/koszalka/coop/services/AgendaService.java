package org.koszalka.coop.services;

import lombok.extern.slf4j.Slf4j;
import org.koszalka.coop.dto.AgendaDTO;
import org.koszalka.coop.entities.AgendaEntity;
import org.koszalka.coop.exceptions.NotCreatedException;
import org.koszalka.coop.repositories.AgendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@Slf4j
public class AgendaService {

    private final AgendaRepository agendaRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public AgendaEntity createNewAgenda(AgendaDTO agendaDTO) {
        try {
            AgendaEntity agendaEntity = modelMapper.map(agendaDTO, AgendaEntity.class);
            if(Objects.isNull(agendaEntity.getExpirationDate())) {
                agendaEntity.setExpirationDate(LocalDateTime.now().plusMinutes(1));
            }
            agendaRepository.save(agendaEntity);
            return agendaEntity;
        } catch (NotCreatedException ex) {
            log.error("Method=createNewAgenda, Message={}", ex.getMessage());
        }
        return null;
    }
}
