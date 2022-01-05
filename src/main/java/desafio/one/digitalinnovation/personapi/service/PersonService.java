package desafio.one.digitalinnovation.personapi.service;

import desafio.one.digitalinnovation.personapi.dto.PersonDTO;
import desafio.one.digitalinnovation.personapi.exception.PersonNotFoundExecpition;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {
    ResponseEntity<List<PersonDTO>> getAllPerson();

    ResponseEntity<PersonDTO> findById(long id) throws PersonNotFoundExecpition;

    ResponseEntity<PersonDTO> createPerson(PersonDTO personDTO);
}
