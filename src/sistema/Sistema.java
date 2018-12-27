package sistema;

import java.util.*;

/**
 * Classe responsavel pela logica do sistema. Na qual vai manipular e usar as
 * classes Aluno e GrupoEstudo. Atributos: Mapas de: Aluno(chave: matricula),
 * GrupoEstudo(chave: nome) e ArrayList dos registros de respostas.
 * 
 * @author Matheus Gusmão Lemos - 117210399
 */
public class Sistema {

	/**
	 * Atributo(mapa) que ira guardar e manipular todos os alunos cadastrados no
	 * sistema.
	 */
	private Map<String, Aluno> alunos;
	/**
	 * Atributo(mapa) que ira guardar e manipular todos os grupos cadastrados no
	 * sistema.
	 */
	private Map<String, GrupoEstudo> grupos;
	/**
	 * Atributo que ira guardar e manipular todos os registros no sistema.
	 */
	private ArrayList<Aluno> registros;

	/**
	 * Construtor do sistema.
	 */
	public Sistema() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.registros = new ArrayList<>();
	}

	/**
	 * Metodo que cadastra um aluno.
	 * 
	 * @param matricula
	 *            Matricula do aluno
	 * @param nome
	 *            Nome do aluno.
	 * @param curso
	 *            Nome do curso do aluno.
	 * 
	 * @return true se conseguir cadastrar um aluno, ou false caso contrario.
	 */
	public boolean cadastrarAluno(String matricula, String nome, String curso) {
		if (!existeAluno(matricula)) {
			Aluno a = new Aluno(nome, matricula, curso);
			this.alunos.put(matricula, a);
			return true;
		}
		return false;
	}

	/**
	 * Metodo que cadastra um grupo.
	 * 
	 * @param nomeGrupo
	 *            Nome do grupo.
	 * 
	 * @return true se conseguir cadastrar um grupo, ou false caso contrario.
	 */
	public boolean cadastrarGrupo(String nomeGrupo) {
		if (!existeGrupo(nomeGrupo)) {
			GrupoEstudo g = new GrupoEstudo(nomeGrupo);
			this.grupos.put(nomeGrupo.toLowerCase(), g);
			return true;
		}
		return false;
	}

	/**
	 * Metodo que exibe um aluno.
	 * 
	 * @param matricula
	 *            Matricula do aluno.
	 * 
	 * @return String(toString de aluno ou 'Aluno nao cadastrado");
	 */
	public String exibirAluno(String matricula) {
		if (existeAluno(matricula)) {
			return this.alunos.get(matricula).toString();
		} else {
			return "Aluno nao cadastrado.\n";
		}
	}

	/**
	 * Metodo que aloca um aluno em um grupo.
	 * 
	 * @param matricula
	 *            Matricula do aluno.
	 * @param nomeGrupo
	 *            Nome do grupo.
	 * 
	 * @return String(Situacoes em que o grupo ou aluno nao existe, ou se for
	 *         bem sucedida).
	 */
	public String alocarAluno(String matricula, String nomeGrupo) {
		if (!existeAluno(matricula)) {
			return "Aluno nao cadastrado.\n";
		}
		if (!existeGrupo(nomeGrupo)) {
			return "Grupo nao cadastrado.\n";
		}
		if(this.grupos.get(nomeGrupo.toLowerCase()).adicionarAluno(this.alunos.get(matricula))) {
			return "ALUNO ALOCADO!\n";
		} else {
			return "ALUNO JA CADASTRADO NO GRUPO!\n";
		}
	}

	/**
	 * Metodo que imprime o grupo desejado.
	 * 
	 * @param nomeGrupo
	 *            Nome do grupo.
	 * 
	 * @return String(toString do grupo desejado).
	 */
	public String imprimirGrupos(String nomeGrupo) {
		if (existeGrupo(nomeGrupo)) {
			return this.grupos.get(nomeGrupo.toLowerCase()).toString();
		}
		return "Grupo nao cadastrado.\n";
	}

	/**
	 * Metodo que imprime as participacoes dos alunos.
	 * 
	 * @return String(toString de todos os alunos que responderam).
	 */
	public String imprimirParticapacoes() {
		String res = "";
		if (!(registros.size() == 0)) {
			for (int i = 0; i < registros.size(); i++) {
				res += (i + 1) + ". " + registros.get(i).toString();
			}
		} else {
			res += "Registro vazio.\n";
		}
		return res;
	}

	/**
	 * Metodo que registra participacoes do aluno no sistema.
	 * 
	 * @param matricula
	 *            Matricula do alunos.
	 * 
	 * @return String("ALUNO REGISTRADO!" ou "Aluno nao cadastrado").
	 */
	public String registraParticipacao(String matricula) {
		if (existeAluno(matricula)) {
			this.registros.add(this.alunos.get(matricula));
			return "ALUNO REGISTRADO!\n";
		} else {
			return "Aluno nÃ£o cadastrado.\n";
		}
	}

	/**
	 * Metodo privado que verifica se um grupo existe no sistema.
	 * 
	 * @param nomeGrupo
	 *            Nome do grupo
	 * 
	 * @return true se o grupo existir no sistema, ou false caso contrario.
	 */
	private boolean existeGrupo(String nomeGrupo) {
		return this.grupos.containsKey(nomeGrupo.toLowerCase());
	}

	/**
	 * Metodo privado que verifica se um aluno existe no sistema.
	 * 
	 * @param nomeGrupo
	 *            Nome do aluno
	 * 
	 * @return true se o aluno existir no sistema, ou false caso contrario.
	 */
	private boolean existeAluno(String matricula) {
		return this.alunos.containsKey(matricula);
	}
}