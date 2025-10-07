package com.atv.saeb.Model;

//import lombok
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//para virar uma tabela la no banco
@Entity
//para nao ter que fazer os get set
@Getter
@NoArgsConstructor
@Setter
public class Aluno {

    //declarando as variaveis
    private String nome;


    //dizendo quem é a chave primaria, no caso o id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int ra;

}
