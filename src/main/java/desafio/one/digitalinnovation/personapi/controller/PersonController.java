package desafio.one.digitalinnovation.personapi.controller;

import desafio.one.digitalinnovation.personapi.dto.PersonDTO;
import desafio.one.digitalinnovation.personapi.exception.PersonNotFoundExecpition;
import desafio.one.digitalinnovation.personapi.service.PersonService;
import desafio.one.digitalinnovation.personapi.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/people")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllPerson() {
        return personService.getAllPerson();
    }

    @PostMapping
    public ResponseEntity<PersonDTO> createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable long id) throws PersonNotFoundExecpition {
        return personService.findById(id);
    }
}
