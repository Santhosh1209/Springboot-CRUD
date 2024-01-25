package com.interesting.stuff.postgres.demo2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntitiesRepository extends JpaRepository<Entities,Integer> {
    // Integer -> data type of primary key
    @Query("SELECT e FROM Entities e WHERE e.email = ?1")
    Optional<Entities> findEntityByEmail(String email);
}
