package desafio.one.digitalinnovation.personapi.service.impl;

import desafio.one.digitalinnovation.personapi.Entity.Person;
import desafio.one.digitalinnovation.personapi.dto.PersonDTO;
import desafio.one.digitalinnovation.personapi.exception.PersonNotFoundExecpition;
import desafio.one.digitalinnovation.personapi.mapper.PersonMapper;
import desafio.one.digitalinnovation.personapi.repository.PersonRepository;
import desafio.one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public ResponseEntity<PersonDTO> createPerson(PersonDTO personDTO) {
        Person person = personMapper.toModel(personDTO);
        Person save = personRepository.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(personMapper.toDTO(save));
    }

    @Override
    public ResponseEntity<List<PersonDTO>> getAllPerson() {
        List<Person> personList = personRepository.findAll();
        List<PersonDTO> personDTOList = new ArrayList<PersonDTO>();
        for (Person person : personList) {
            personDTOList.add(personMapper.toDTO(person));
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(personDTOList);
    }

    @Override
    public ResponseEntity<PersonDTO> findById(long id) throws PersonNotFoundExecpition {
        Optional<Person> personOptional = personRepository.findById(id);
        if(personOptional.isEmpty()){
            throw  new PersonNotFoundExecpition();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(personMapper.toDTO(personOptional.get()));
    }
}
