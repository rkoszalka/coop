package org.koszalka.coop.services;

import org.koszalka.coop.dto.ResultDTO;
import org.koszalka.coop.kafka.producer.KafkaProducerCoop;
import org.koszalka.coop.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {

    VoteRepository voteRepository;
    KafkaProducerCoop kafkaProducerCoop;

    @Autowired
    public ResultService(VoteRepository voteRepository, KafkaProducerCoop kafkaProducerCoop) {
        this.voteRepository = voteRepository;
        this.kafkaProducerCoop = kafkaProducerCoop;
    }

    public ResultDTO getAgendaResult(Long id) {
        ResultDTO resultDTO = new ResultDTO("Votação sem contagem");
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
        }

        resultDTO.setResult("Votação sem votos.");
        kafkaProducerCoop.sendMessage("votação sem votos");
        return  resultDTO;
    }
}
