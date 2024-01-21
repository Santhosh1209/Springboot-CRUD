package com.interesting.stuff.postgres.demo2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntitiesRepository extends JpaRepository<Entities,Integer> {
    // Integer -> data type of primary key
}
