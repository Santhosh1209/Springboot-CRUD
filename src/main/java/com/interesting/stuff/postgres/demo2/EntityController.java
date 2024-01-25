package com.interesting.stuff.postgres.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// will contain all API resources

@RestController
@RequestMapping(path = "/view")

public class EntityController {
    private final EntityService entityService;

    @Autowired // -> this annotation tells us that exact instance of 'entityService' is passed as the parameter for the function below
    public EntityController(EntityService entityService){
        this.entityService = entityService;
    }
    @GetMapping
    public List<Entities> view(){
        return entityService.getUsers();
    }
    @PostMapping()
    public void newRegister(@RequestBody Entities entity) {
        // @RequestBody ensures that the json blob that is required is obtained via the entity object
        entityService.addNewEntity(entity);
    }
    @DeleteMapping(path = "/{id}")
    // stuff inside path -> used for identification in order to delete it
    public void entitydelete(@PathVariable("id") int id){
        entityService.deleteEntity(id);
    }
    @PutMapping(path = "/{id}")
    // so, while giving the link it should be given like : http://localhost:8080/view/1?email=fukumoto@gmail.com
    public Entities editEntity(@PathVariable("id") int id, @RequestParam(value="email") String email){
        return entityService.editEntity(id,email);
    }
}