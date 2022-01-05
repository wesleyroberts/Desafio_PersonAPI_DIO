package desafio.one.digitalinnovation.personapi.service;

import desafio.one.digitalinnovation.personapi.Entity.Person;
import desafio.one.digitalinnovation.personapi.dto.PersonDTO;
import desafio.one.digitalinnovation.personapi.mapper.PersonMapper;
import desafio.one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public ResponseEntity<PersonDTO> createPerson(PersonDTO personDTO) {
        Person person = personMapper.toModel(personDTO);
        Person save = personRepository.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(personMapper.toDTO(save));
    }

    public ResponseEntity<List<PersonDTO>> getAllPerson() {
        List<Person> personList = personRepository.findAll();
        List<PersonDTO> personDTOList = new ArrayList<PersonDTO>();
        for (Person person : personList) {
            personDTOList.add(personMapper.toDTO(person));
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(personDTOList);
    }
}
