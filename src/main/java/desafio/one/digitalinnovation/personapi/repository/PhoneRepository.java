package desafio.one.digitalinnovation.personapi.repository;

import desafio.one.digitalinnovation.personapi.Entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone,Long> {
}
