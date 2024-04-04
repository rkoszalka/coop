package org.koszalka.coop.services;

import lombok.extern.slf4j.Slf4j;
import org.koszalka.coop.dto.ResultDTO;
import org.koszalka.coop.entities.AgendaEntity;
import org.koszalka.coop.kafka.producer.KafkaProducerCoop;
import org.koszalka.coop.repositories.AgendaRepository;
import org.koszalka.coop.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class ResultService {

    VoteRepository voteRepository;
    AgendaRepository agendaRepository;
    KafkaProducerCoop kafkaProducerCoop;

    @Autowired
    public ResultService(VoteRepository voteRepository, KafkaProducerCoop kafkaProducerCoop,
                         AgendaRepository agendaRepository) {
        this.voteRepository = voteRepository;
        this.kafkaProducerCoop = kafkaProducerCoop;
        this.agendaRepository = agendaRepository;
    }

    public ResultDTO getAgendaResult(Long id) {
        try {
            ResultDTO resultDTO = new ResultDTO("Votação em aberto");

            if (checkIfAgendaIsClosed(id)) {
                resultDTO.setResult("Votação fechada");
                kafkaProducerCoop.sendMessage("votação fechada");
                return  resultDTO;
            }

            resultDTO = new ResultDTO("Votação sem contagem");
            Long yesVotes = voteRepository.countVotes("S", id);
            Long noVotes = voteRepository.countVotes("N", id);

            if(yesVotes > noVotes) {
                resultDTO.setResult("Votação aprovada.");
                kafkaProducerCoop.sendMessage("votação aprovada");
                return  resultDTO;
            } else if (yesVotes < noVotes) {
                resultDTO.setResult("Votação reprovada.");
                kafkaProducerCoop.sendMessage("votação reprovada");
                return  resultDTO;
            } else if (yesVotes == 0 && noVotes == 0) {
                resultDTO.setResult("Votação sem votos.");
                kafkaProducerCoop.sendMessage("votação sem votos");
                return  resultDTO;
            }

            resultDTO.setResult("Votação empatada.");
            kafkaProducerCoop.sendMessage("votação empatada");
            return  resultDTO;
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return null;
    }

    public boolean checkIfAgendaIsClosed(Long id) {
        try {
            LocalDateTime now = LocalDateTime.now();
            Optional<AgendaEntity> agenda = agendaRepository.findById(id);
            return agenda.filter(agendaEntity -> now.isAfter(agendaEntity.getExpirationDate())).isPresent();
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return false;
    }

}
