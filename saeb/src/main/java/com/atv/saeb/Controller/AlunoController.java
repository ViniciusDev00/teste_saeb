package com.atv.saeb.Controller;


import com.atv.saeb.Model.Aluno;
import com.atv.saeb.Repository.AlunoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//restcontroller avisa que essa classe va cuidar das web requisiçoes.
@RestController
@RequestMapping("/aluno")
public class AlunoController {

    AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @GetMapping
    public List<Aluno> getAllAlunos(){
        return alunoRepository.findAll();
    }

    @PostMapping
    ResponseEntity<Boolean> addAluno(@RequestBody Aluno newAluno){
        alunoRepository.save(newAluno);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Aluno updateAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {

        // Garante que o objeto a ser salvo tenha o ID correto
        alunoAtualizado.setId(id);

        // O método save() do JPA é inteligente:
        // Se o objeto tem um ID que já existe no banco, ele faz um UPDATE.
        // Se não tem ID, ele faz um INSERT.
        return alunoRepository.save(alunoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        alunoRepository.deleteById(id);

        // Retorna uma resposta HTTP 204 (No Content),
        // que é o padrão para uma operação de delete bem-sucedida.
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
