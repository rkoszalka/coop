package org.koszalka.coop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VoteDTO {

    private final Long agendaID;
    private final Long cpf;
    private final String voteStatus;

}
