package desafio.one.digitalinnovation.personapi.mapper;

import desafio.one.digitalinnovation.personapi.Entity.Person;
import desafio.one.digitalinnovation.personapi.Entity.Phone;
import desafio.one.digitalinnovation.personapi.dto.PhoneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PhoneMapper {
    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    Phone toModel(PhoneDTO phoneDTO);

    PhoneDTO toDTO(Person person);

    List<Phone> deRequest(List<PhoneDTO> phoneDTOList);

    List<PhoneDTO> deResponse(List<Phone> phones);
}
