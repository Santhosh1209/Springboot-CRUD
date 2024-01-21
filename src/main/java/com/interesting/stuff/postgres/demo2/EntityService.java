package com.interesting.stuff.postgres.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service // -> this annotation is used to denote that a service is being used
public class EntityService {

    private final EntitiesRepository entitiesRepository;

    @Autowired
    public EntityService(EntitiesRepository entitiesRepository){
        this.entitiesRepository = entitiesRepository;
    }
    public List<Entities> getUsers(){
        return entitiesRepository.findAll();
    }

    public void addNewEntity(Entities entity){

    }
}
