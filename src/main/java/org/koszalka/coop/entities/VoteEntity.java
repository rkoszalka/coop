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
@Table(name = "votes", schema = "public")
@Getter
@Setter
public class VoteEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vote_sequence")
    @SequenceGenerator(name = "vote_sequence", sequenceName = "vote_sequence", allocationSize = 1, initialValue = 1, schema = "public")
    private Long id;

    @Column(name = "cpf", nullable = false)
    private Long cpf;

    @Column(name = "vote_status", nullable = false)
    private boolean voteStatus;

}