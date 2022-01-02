package desafio.one.digitalinnovation.personapi.repository;

import desafio.one.digitalinnovation.personapi.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
