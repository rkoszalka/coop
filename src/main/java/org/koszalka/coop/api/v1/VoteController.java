package org.koszalka.coop.api.v1;

import org.koszalka.coop.dto.AgendaDTO;
import org.koszalka.coop.dto.VoteDTO;
import org.koszalka.coop.entities.AgendaEntity;
import org.koszalka.coop.entities.VoteEntity;
import org.koszalka.coop.services.AgendaService;
import org.koszalka.coop.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/vote")
public class VoteController {

    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping("/create-vote")
    public ResponseEntity<VoteEntity> createAgenda(@RequestBody VoteDTO voteDTO) {
        VoteEntity voteEntity = voteService.saveNewVote(voteDTO);
        return new ResponseEntity<>(voteEntity, HttpStatus.CREATED);
    }

}
