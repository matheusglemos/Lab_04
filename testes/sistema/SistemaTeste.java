package sistema;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe que realiza os testes da classe Sistema.
 * 
 * @author Matheus Gusmão Lemos - 117210399
 *
 */
public class SistemaTeste {

	/**
	 * Atributo que representa o sistema.
	 */
	private Sistema sistema;

	/**
	 * Metodo que instancia o objeto sistema(Chamado sempre quando um
	 * metodo @Test eh chamado).
	 */
	@Before
	public void testSistema() {
		this.sistema = new Sistema();
	}

	/**
	 * Metodo que testa se eh possivel cadastrar um aluno.
	 */
	@Test
	public void testCadastrarAluno() {
		assertTrue(this.sistema.cadastrarAluno("123", "Lucian", "Computacao"));
	}

	/**
	 * Metodo que testa se eh possivel cadastrar um grupo.
	 */
	@Test
	public void testCadastrarGrupo() {
		assertTrue(this.sistema.cadastrarGrupo("Calculo"));
	}

	/**
	 * Metodo que testa se eh possivel exibir informacoes de um aluno(Pela
	 * matricula).
	 */
	@Test
	public void testExibirAluno() {
		this.sistema.cadastrarAluno("123", "Lucian", "Computacao");
		String res = "Aluno: 123 - Lucian - Computacao\n";
		assertEquals(this.sistema.exibirAluno("123"), res);
	}

	/**
	 * Metodo que testa se eh possivel adicionar um aluno em um grupo.
	 */
	@Test
	public void testAlocarAluno() {
		this.sistema.cadastrarAluno("123", "Lucian", "Computacao");
		this.sistema.cadastrarGrupo("Calculo");
		assertEquals(this.sistema.alocarAluno("123", "calculo"), "ALUNO ALOCADO!\n");
	}

	/**
	 * Metodo que testa se eh possivel adicionar um aluno em um grupo.
	 */
	@Test
	public void testAlocarAlunoErro1() {
		this.sistema.cadastrarAluno("123", "Lucian", "Computacao");
		this.sistema.cadastrarGrupo("Calculo");
		assertEquals(this.sistema.alocarAluno("123", "Cculo"), "Grupo nao cadastrado.\n");
	}

	/**
	 * Metodo que testa se eh possivel adicionar um aluno em um grupo.
	 */
	@Test
	public void testAlocarAlunoErro2() {
		this.sistema.cadastrarAluno("123", "Lucian", "Computacao");
		this.sistema.cadastrarGrupo("Calculo");
		assertEquals(this.sistema.alocarAluno("1", "Cculo"), "Aluno nao cadastrado.\n");
	}

	/**
	 * Metodo que testa se eh possivel imprimir um grupo cadastrado no sistema.
	 */
	@Test
	public void testImprimirGrupos() {
		this.sistema.cadastrarAluno("123", "Lucian", "Computacao");
		this.sistema.cadastrarGrupo("Calculo");
		this.sistema.alocarAluno("123", "Calculo");
		String res = "Alunos do grupo Calculo\n* Aluno: 123 - Lucian - Computacao\n";
		assertEquals(this.sistema.imprimirGrupos("Calculo"), res);
	}

	/**
	 * Metodo que testa se eh possivel imprimir um grupo cadastrado no sistema.
	 */
	@Test
	public void testImprimirGruposErro() {
		this.sistema.cadastrarGrupo("Calculo");
		assertEquals(this.sistema.imprimirGrupos("Calculo 1"), "Grupo nao cadastrado.\n");
	}

	/**
	 * Metodo que verifica se eh possivel imprimir as participacoes corretamente.
	 */
	@Test
	public void testImprimirParticapacoes() {
		this.sistema.cadastrarAluno("123", "Lucian", "Computacao");
		this.sistema.cadastrarAluno("1234", "Elton", "Computacao");
		this.sistema.registraParticipacao("123");
		this.sistema.registraParticipacao("1234");
		this.sistema.registraParticipacao("123");
		String res = "1. Aluno: 123 - Lucian - Computacao\n" + "2. Aluno: 1234 - Elton - Computacao\n"
				+ "3. Aluno: 123 - Lucian - Computacao\n";
		assertEquals(this.sistema.imprimirParticapacoes(), res);
	}

	/**
	 * Metodo que teste se eh possivel um aluno registrar participacao.
	 */
	@Test
	public void testRegistraParticipacao() {
		this.sistema.cadastrarAluno("123", "Lucian", "Computacao");
		this.sistema.cadastrarAluno("1234", "Elton", "Computacao");
		assertEquals(this.sistema.registraParticipacao("123"), "ALUNO REGISTRADO!\n");
	}

	/**
	 * Metodo que teste se eh possivel um aluno registrar participacao.
	 */
	@Test
	public void testRegistraParticipacaoErro() {
		assertEquals(this.sistema.registraParticipacao("1234"), "Aluno nao cadastrado.\n");
	}
}