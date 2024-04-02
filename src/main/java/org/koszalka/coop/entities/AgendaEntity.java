package org.koszalka.coop.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "agenda", schema = "public")
@Getter
@Setter
public class AgendaEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "short_sequence")
    @SequenceGenerator(name = "short_sequence", sequenceName = "short_sequence", allocationSize = 1, initialValue = 1, schema = "public")
    private Long id;

    @Column(name = "agenda_name", nullable = false)
    private String agendaName;

    @Column(name = "expiration_date", nullable = false)
    private Long expirationDate;

}
