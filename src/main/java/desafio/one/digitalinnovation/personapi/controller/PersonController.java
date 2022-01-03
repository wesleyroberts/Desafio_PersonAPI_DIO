package desafio.one.digitalinnovation.personapi.controller;

import desafio.one.digitalinnovation.personapi.Entity.Person;
import desafio.one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person save = personRepository.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }
}
