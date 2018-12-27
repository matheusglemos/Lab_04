package sistema;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe que realiza os testes da classe Aluno.
 * 
 * @author Matheus Gusm�o Lemos - 117210399
 *
 */
public class AlunoTeste {

	/**
	 * Atributo que ira representa o aluno nos testes.
	 */
	private Aluno aluno;
	
	/**
	 * Metodo que instancia o objeto aluno(Chamado sempre quando um metodo @Test eh chamado).
	 */
	@Before
	public void testAluno() {
		this.aluno = new Aluno("Lucian", "123", "Computacao");
	}
	
	/**
	 * Metodo que espera uma excecao("Dado invalido").
	 */
	@Test(expected=NullPointerException.class)
	public void testAlunoNomeNulo() {
		Aluno a1 = new Aluno(null, "516", "computacao");
	}
	
	/**
	 * Metodo que espera uma excecao("Dado invalido").
	 */
	@Test(expected=NullPointerException.class)
	public void testAlunoMatriculaNulo() {
		Aluno a1 = new Aluno("Lucian", null, "Computacao");
	}
	
	/**
	 * Metodo que espera uma excecao("Dado invalido").
	 */
	@Test(expected=NullPointerException.class)
	public void testAlunoCursoNulo() {
		Aluno a1 = new Aluno("Lucian", "1234", null);
	}
	
	/**
	 * Metodo que espera uma excecao("Nome invalido").
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoNomeInvalido() {
		Aluno a1 = new Aluno("   ", "516", "computacao");
	}
	
	/**
	 * Metodo que espera uma excecao("Matricula invalido").
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoMatriculaInvalida() {
		Aluno a1 = new Aluno("Lucian", "   ", "Computacao");
	}
	
	/**
	 * Metodo que espera uma excecao("Curso invalido").
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoCursoInvalida() {
		Aluno a1 = new Aluno("Lucian", "1234", "   ");
	}
	
	/**
	 * Metodo que testa o 'toString' do meu Aluno.
	 */
	@Test
	public void testToString() {
		String res = "Aluno: 123 - Lucian - Computacao\n";
		assertEquals(this.aluno.toString(), res);
	}

	/**
	 * Metodo que testa o 'equals' do meu Aluno(Pela matricula).
	 * True
	 */
	@Test
	public void testEqualsTrue() {
		Aluno a1 = new Aluno("nnnkfb", "123", "Computacao");
		assertTrue(this.aluno.equals(a1));
	}
	
	/**
	 * Metodo que testa o 'equals' do meu Aluno(Pela matricula).
	 * False.
	 */
	@Test
	public void testEqualsFalse() {
		Aluno a1 = new Aluno("Elton", "12345", "Engenharia");
		assertFalse(this.aluno.equals(a1));
	}
	
	/**
	 * Metodo que testa o 'equals' do meu Aluno(Pela matricula).
	 * False.
	 */
	@Test
	public void testEqualsObjNull() {
		Aluno a1 = null;
		assertFalse(this.aluno.equals(a1));
	}
	
	/**
	 * Metodo que testa o 'equals' do meu Aluno(Pela matricula).
	 * False.
	 */
	@Test
	public void testEqualsObjClasseDiferentes() {
		GrupoEstudo a1 = new GrupoEstudo("Calculo");
		assertFalse(this.aluno.equals(a1));
	}
}