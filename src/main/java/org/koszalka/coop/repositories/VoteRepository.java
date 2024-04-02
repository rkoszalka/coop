package org.koszalka.coop.repositories;

import org.koszalka.coop.entities.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<VoteEntity, Long> {

}