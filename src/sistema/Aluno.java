package sistema;

/**
 * Classe responsavel pela logica de um aluno. Na qual vai manipular os dados do
 * mesmo. Atributos: nome, matricula e curso.
 * 
 * @author Matheus Gusm�o Lemos - 117210399
 */
public class Aluno {

	/**
	 * Atributo para o nome do aluno.
	 */
	private String nome;
	/**
	 * Atributo para a matricula do aluno.
	 */
	private String matricula;
	/**
	 * Atributo para o nome do curso do aluno.
	 */
	private String curso;

	/**
	 * Construtor do aluno.
	 * 
	 * @param nome      Nome do aluno
	 * @param matricula Matricula do aluno
	 * @param curso     Nome do curso do aluno.
	 */
	public Aluno(String nome, String matricula, String curso) {
		if ((nome == null) || (matricula == null) || (curso == null))
			throw new NullPointerException("Dado inválido!\n");
		if (nome.trim().isEmpty())
			throw new IllegalArgumentException("Nome inválido!\n");
		if (matricula.trim().isEmpty())
			throw new IllegalArgumentException("Matrícula inválida!\n");
		if (curso.trim().isEmpty())
			throw new IllegalArgumentException("Curso inválido!\n");
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}

	/**
	 * Metodo que retorna a representacao textual do aluno.
	 *
	 * @return String
	 */
	@Override
	public String toString() {
		return "Aluno: " + this.matricula + " - " + this.nome + " - " + this.curso + "\n";
	}

	/**
	 * Metodo que retorna o identificador unico do aluno.
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Metodo que verifica se esse objeto e igual a outro.
	 * 
	 * @param obj Outro objeto.
	 * @return True se forem iguais, se nao retorna false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
}