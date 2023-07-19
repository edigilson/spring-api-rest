package med.voll.api.domain.consulta;


import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.medico.EspecialidadeEnum;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.Paciente;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(Long id, long idMedico, long idPaciente, LocalDateTime data) {
    public DadosDetalhamentoConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());

    }
}