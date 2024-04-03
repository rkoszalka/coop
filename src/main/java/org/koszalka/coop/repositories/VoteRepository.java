package org.koszalka.coop.repositories;

import org.koszalka.coop.entities.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoteRepository extends JpaRepository<VoteEntity, Long> {

    @Query("SELECT v FROM VoteEntity v WHERE v.cpf = :cpf AND v.agendaID = :agendaID")
    List<VoteEntity> checkIfUserAlreadyVoted(@Param("cpf") Long cpf, @Param("agendaID") Long agendaID );

    @Query("SELECT COUNT(v) FROM VoteEntity v WHERE v.voteStatus = :voteStatus AND v.agendaID = :id")
    Long countVotes(@Param("voteStatus") String voteStatus, @Param("id") Long id);

}