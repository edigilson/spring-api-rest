package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(
       @NotBlank
        String nome,
       @NotBlank
       @Email
        String email,

       @NotBlank(message = "{telefone.obrigatorio}")
       String telefone,
       @NotBlank
       @Pattern(regexp = "\\d{4,6}", message = "Formato do CRM é inválido: Deve Possuir entre 4 a 6 numeros")
        String crm,
        @NotNull
        EspecialidadeEnum especialidade,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}
