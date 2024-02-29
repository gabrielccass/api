package com.dash.api.controller;

import com.dash.api.medico.AlterarMedicos;
import com.dash.api.medico.CadastroMedicos;
import com.dash.api.medico.DadosMedico;
import com.dash.api.medico.Medico;
import com.dash.api.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class medicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody @Valid CadastroMedicos dados){

        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosMedico> listar(Pageable paginacao){

        return repository.findAllByAtivoTrue(paginacao).map(DadosMedico::new);
    }

    @PutMapping
    @Transactional
    public void alterarDados(@RequestBody @Valid AlterarMedicos dadosalterados){
        var medico = repository.getReferenceById(dadosalterados.id());
        medico.atualizar(dadosalterados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }

}
