package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedicoDTO dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedicosDTO> listarMedicos(@PageableDefault(sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemMedicosDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizarDadosMedico(@RequestBody @Valid dadosAtualizacaoMedicoDTO dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarMedicos(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluirMedico();
    }
}
