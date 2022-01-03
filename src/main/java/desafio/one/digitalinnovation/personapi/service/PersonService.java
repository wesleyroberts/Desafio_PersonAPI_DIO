package desafio.one.digitalinnovation.personapi.service;

import desafio.one.digitalinnovation.personapi.Entity.Person;
import desafio.one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }


    public ResponseEntity<Person> createPerson(Person person){
        Person save = personRepository.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }
}
