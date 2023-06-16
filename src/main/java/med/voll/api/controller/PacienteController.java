package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosUpdateMedico;
import med.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
        pacienteRepository.save(new Paciente(dados));
    }
    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(size=10, sort = {"nome"}) Pageable pageable) {
        //return pacienteRepository.findAll(pageable).map(DadosListagemPaciente::new);
        return pacienteRepository.findAllByAtivoTrue(pageable).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DadosUpdatePaciente dados){
        var paciente = pacienteRepository.getReferenceById(dados.id());
        //  Medico medico = medicoRepository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        pacienteRepository.deleteById(id);
    }

    @DeleteMapping("logico/{id}")
    @Transactional
    public void deletarLogico(@PathVariable Long id){
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
    }
}
