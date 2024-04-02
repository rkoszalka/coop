package org.koszalka.coop.services;

import org.koszalka.coop.dto.VoteDTO;
import org.koszalka.coop.entities.AgendaEntity;
import org.koszalka.coop.entities.VoteEntity;
import org.koszalka.coop.exceptions.AgendaIsClosedException;
import org.koszalka.coop.exceptions.AgendaNotFoundException;
import org.koszalka.coop.repositories.AgendaRepository;
import org.koszalka.coop.repositories.VoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VoteService {

    private final VoteRepository voteRepository;
    private final AgendaRepository agendaRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public VoteService(VoteRepository voteRepository, AgendaRepository agendaRepository) {
        this.voteRepository = voteRepository;
        this.agendaRepository = agendaRepository;
    }

    public VoteEntity saveNewVote(VoteDTO voteDTO) throws AgendaNotFoundException, AgendaIsClosedException {

        if(!checkIfAgendaExists(voteDTO.getAgendaID())) {
            throw new AgendaNotFoundException("Pauta não encontrada.");
        }
        if (checkIfAgendaIsClosed(voteDTO.getAgendaID())) {
            throw new AgendaIsClosedException("Pauta encerrada.");
        }

        VoteEntity voteEntity = modelMapper.map(voteDTO, VoteEntity.class);
        voteRepository.save(voteEntity);
        return voteEntity;
    }

    public boolean checkIfAgendaExists(Long id) {
        Optional<AgendaEntity> agenda = agendaRepository.findById(id);
        return agenda.isPresent();
    }

    public boolean checkIfAgendaIsClosed(Long id) {
        LocalDateTime now = LocalDateTime.now();
        Optional<AgendaEntity> agenda = agendaRepository.findById(id);
        return agenda.filter(agendaEntity -> now.isAfter(agendaEntity.getExpirationDate())).isPresent();
    }
}
