package com.interesting.stuff.postgres.demo2;

import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void deleteEntity(int id) {
        boolean exists = entitiesRepository.existsById(id);
        if (exists != true){
            throw new IllegalStateException("student with id " + id + "does not exist");
        }
        entitiesRepository.deleteById(id);
    }
    @Transactional
    // used to get setters and getters directly
    public Entities editEntity(int id, String newEmail) {
        Optional<Entities> optionalEntity = entitiesRepository.findById(id);
        if (optionalEntity.isPresent()) {
            Entities entity = optionalEntity.get();
            entity.setEmail(newEmail);
            return entitiesRepository.save(entity);
        }
        else{
            throw new IllegalStateException("Entry with " + id + " isn't available!");
        }
    }
}
