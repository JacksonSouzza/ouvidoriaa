package Entitis;

import java.util.ArrayList;

public abstract class Pessoa {

	private static ArrayList<Pessoa> lista = new ArrayList<Pessoa>();

	private String nome;
	private String email;
	private String senha;
	private boolean adm;

	/*
	 * Construtor padrão me dar a liberdade para criar instacias com quantos
	 * atributos eu desejar ou precisar.
	 */
	public Pessoa() {

	}

	/*
	 * construtor com paranmetros nome, e-mail e senha. o paranmetro "ADM" não foi
	 * posto como parametro do metodo, mas foi setado diretamente no mesmo, fazendo
	 * assim que toda instacia criada aparti desta classe tenha este atributo como
	 * falso.
	 */
	public Pessoa(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.adm = false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;

	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean getAdm() {
		return adm;
	}

	public void setAdm() {
		this.adm = true;
	}

	public static void add(Pessoa pessoa) {
		lista.add(pessoa);
	}

	/*
	 * Função responsavel por checar se os atributos e-mail e senha fornecido pelo
	 * usuario são compatives com os os mesmos atributos das instancias salvas no
	 * ArrayList.
	 */
	static public Pessoa login(String email, String senha) {
		for (Pessoa pessoaLogada : lista) {
			if ((pessoaLogada.getEmail().equalsIgnoreCase(email))
					&& (pessoaLogada.getSenha().equalsIgnoreCase(senha))) {
				return pessoaLogada;
			}
		}
		return null;
	}

	/*
	 * Metodo responsavel por mostra aributos da instacia em formato de String.
	 */
	@Override
	public String toString() {
		return "Nome: " + nome + "\nEmail: " + email;
	}

}
