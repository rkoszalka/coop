package org.koszalka.coop.services;

import org.koszalka.coop.dto.ResultDTO;
import org.koszalka.coop.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {

    VoteRepository voteRepository;

    @Autowired
    public ResultService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public ResultDTO getAgendaResult(Long id) {
        ResultDTO resultDTO = new ResultDTO("Votação sem contagem");
        Long yesVotes = voteRepository.countVotes("S", id);
        Long noVotes = voteRepository.countVotes("N", id);

        if(yesVotes > noVotes) {
            resultDTO.setResult("Votação aprovada.");
            return  resultDTO;
        }

        resultDTO.setResult("Votação sem votos.");
        return  resultDTO;
    }
}
