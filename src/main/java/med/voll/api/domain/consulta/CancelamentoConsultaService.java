package med.voll.api.domain.consulta;


import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.validation.cancelamento.ValidadorCancelamentoDeConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancelamentoConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorCancelamentoDeConsulta> validadores;

    public void cancelar(DadosCancelamentoConsulta dados) {


        if (!consultaRepository.existsById(dados.idConsulta())) {
            throw new ValidacaoException("Id da consulta informado não existe!");
        }

        validadores.forEach( v -> v.validar(dados));

      //  var consulta  = verificarPodeCancelar(dados);
        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());

    }

    /*private Consulta verificarPodeCancelar(DadosCancelamentoConsulta dados) {
        var consulta = consultaRepository.getReferenceById(dados.idConsulta());

        long hours = ChronoUnit.HOURS.between(consulta.getData(), LocalDateTime.now());

        if (hours > 24){
            throw new ValidacaoException("O prazo para cancelamento da consulta expirou!");
        }
        return consulta;
    }*/


}
