package med.voll.api.domain.consulta;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.EspecialidadeEnum;

import java.time.LocalDateTime;

public record DadosCancelamentoConsulta(
        @NotNull
    Long idConsulta,

    @NotNull
    MotivoCancelamentoEnum motivo){

}
