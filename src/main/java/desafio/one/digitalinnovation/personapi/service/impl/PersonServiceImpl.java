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

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<PersonDTO> updatePersonById(long id ,PersonDTO personDTO) throws PersonNotFoundExecpition {
        existPerson(id);
        Person updatePerson = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(updatePerson);
        return ResponseEntity.status(HttpStatus.OK).body(personMapper.toDTO(savedPerson));
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
       return ResponseEntity.status(HttpStatus.FOUND).body(personMapper.toDTO(existPerson(id)));
    }

    @Override
    public void delete(long id) throws PersonNotFoundExecpition {
        personRepository.deleteById(existPerson(id).getId());
    }

    @Override
    public Person existPerson(long id) throws PersonNotFoundExecpition {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundExecpition());
    }
}
