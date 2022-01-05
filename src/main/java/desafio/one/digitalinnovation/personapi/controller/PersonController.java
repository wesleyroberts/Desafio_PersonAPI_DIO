package desafio.one.digitalinnovation.personapi.controller;

import desafio.one.digitalinnovation.personapi.dto.PersonDTO;
import desafio.one.digitalinnovation.personapi.exception.PersonNotFoundExecpition;
import desafio.one.digitalinnovation.personapi.service.PersonService;
import desafio.one.digitalinnovation.personapi.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/person/getAll")
    public ResponseEntity<List<PersonDTO>> getAllPerson() {
        return personService.getAllPerson();
    }

    @PostMapping("/person/add")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @GetMapping("/person/findById/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable long id) throws PersonNotFoundExecpition {
        return personService.findById(id);
    }

    @DeleteMapping("/person/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long id) throws PersonNotFoundExecpition {
        personService.delete(id);
    }

    @PutMapping("/person/update/{id}")
    public ResponseEntity<PersonDTO> updatePersonById(@PathVariable long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundExecpition {
        return personService.updatePersonById(id, personDTO);
    }
}
