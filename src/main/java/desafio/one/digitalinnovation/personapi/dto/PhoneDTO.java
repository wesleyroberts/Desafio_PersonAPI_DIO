package desafio.one.digitalinnovation.personapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private String phoneType;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;

    @Override
    public String toString() {
        return "PhoneDTO{" +
                "id=" + id +
                ", phoneType='" + phoneType + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
