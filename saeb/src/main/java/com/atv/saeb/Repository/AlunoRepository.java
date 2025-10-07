package com.atv.saeb.Repository;

import com.atv.saeb.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; // É uma boa prática adicionar esta anotação

@Repository // Adicione esta anotação
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    // O corpo deve estar vazio
}