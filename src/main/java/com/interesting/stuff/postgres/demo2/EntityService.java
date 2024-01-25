package com.interesting.stuff.postgres.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service // -> this annotation is used to denote that a service is being used
public class EntityService {

    private final EntitiesRepository entitiesRepository;

    @Autowired
    // @Autowired annotation is used for automatic dependency injection.
    public EntityService(EntitiesRepository entitiesRepository){
        this.entitiesRepository = entitiesRepository;
    }
    public List<Entities> getUsers(){
        return entitiesRepository.findAll();
    }
    public void addNewEntity(Entities entity){
        // generating entity based on the email available
        Optional<Entities> EntityByEmailOptional = entitiesRepository.findEntityByEmail(entity.getEmail());
        // checking if the email has already been registered or not
        if (EntityByEmailOptional.isPresent()){
            throw new IllegalStateException("Email Taken");
        }
        // save if the email is present in the database
        entitiesRepository.save(entity);
        System.out.println(entity);
    }
}
