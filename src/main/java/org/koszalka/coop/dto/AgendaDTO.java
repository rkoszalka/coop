package org.koszalka.coop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AgendaDTO {

    private String agendaName;
    private Long expirationDate;

}
