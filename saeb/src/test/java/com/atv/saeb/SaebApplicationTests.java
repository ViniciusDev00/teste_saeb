package com.atv.saeb;

import com.atv.saeb.Model.Aluno;
import com.atv.saeb.Repository.AlunoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// ...
@SpringBootTest
class SaebApplicationTests {

	@Autowired
	private AlunoRepository alunoRepository;

	@Test
	void deveSalvarUmNovoAlunoComSucesso() {
		// 1. Arrange (Preparação)
		// Criamos um objeto Aluno com os dados que queremos salvar.
		Aluno novoAluno = new Aluno();
		novoAluno.setNome("Carlos Drummond");
		novoAluno.setRa(98765);

		// 2. Act (Ação)
		// Executamos a ação que queremos testar: salvar o aluno no repositório.
		Aluno alunoSalvo = alunoRepository.save(novoAluno);

		// 3. Assert (Verificação)
		// Verificamos se o resultado foi o esperado.

		// O aluno salvo não pode ser nulo
		Assertions.assertNotNull(alunoSalvo);

		// O aluno salvo deve ter um ID gerado pelo banco
		Assertions.assertNotNull(alunoSalvo.getId());

		// O nome do aluno salvo deve ser o mesmo que definimos na preparação
		Assertions.assertEquals("Carlos Drummond", alunoSalvo.getNome());

		// O RA do aluno salvo também deve ser o mesmo
		Assertions.assertEquals(98765, alunoSalvo.getRa());
	}
}