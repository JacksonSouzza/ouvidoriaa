package Entitis;

import java.util.ArrayList;

public class Manifestacoes {

	private static ArrayList<Manifestacoes> manifestacoes = new ArrayList<>();
	Pessoa pessoa;
	String tipo;
	String manifestacao;

	public Manifestacoes(Pessoa pessoa, String tipo, String manifestacao) {

		this.pessoa = pessoa;
		this.tipo = tipo;
		this.manifestacao = manifestacao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getManifestacao() {
		return manifestacao;
	}

	public void setManifestacao(String manifestacao) {
		this.manifestacao = manifestacao;
	}

	/*
	 * Metodo "addManifestacao" criado para adicionar instacias de Manifestacoes ao
	 * ArrayList de manifestacoes.
	 */
	public static void addManifestacao(Manifestacoes manifestacao) {
		manifestacoes.add(manifestacao);
	}

	public static void apagar(Pessoa pessoa, int id) {
		if (manifestacoes.size() > 0) {
			if (pessoa.getAdm()) {
				manifestacoes.remove(id - 1);
				System.out.println("MANIFESTACAO APAGADA COM SUCESSO!");
			} else {
				System.out.println("USUARIO NAO TEM PERMICAO PARA APAGAR MANIFESTACOES!");
			}
		} else {
			System.err.println("NAO A MANIFESTACOS A SEREM APAGADAS!");
		}
	}

	/*
	 * "lista" metodo criado para mostra as manifestacões ao usuario. Porem de duas
	 * formas diferentes, da primeira forma ele checa o atributo "ADM" pra ver se e
	 * true ou false, caso sejá true ele mostra todas as manifestações usando um
	 * foreach. É da segunda forma ele so mostra a manifestação do proprio usuario
	 * fazendo uma verificação do nome do usuario logado eo nome do usuario que esta
	 * salvo junto aquela manifestação.
	 */
	public static void listar(Pessoa pessoa) {
		if (manifestacoes.size() > 0) {
			int id = 0;
			if (pessoa.getAdm()) {
				for (Manifestacoes manifestacoes : manifestacoes) {
					id++;
					System.out.println("id: " + id + "\n" + manifestacoes);
					System.out.println("");
				}
			} else {
				for (Manifestacoes manifestacoes : manifestacoes) {
					if (manifestacoes.pessoa.getNome().equals(pessoa.getNome())) {
						id++;
						System.out.println("id: " + id + "\n" + manifestacoes);
					}
				}
			}
			id = 0;
		} else {
			System.err.println("LISTA DE MANIFESTACOES ESTA VASIA, TENTE CADASTRA ALGUMA PRIMEIRO.");
		}
	}

	/*
	 * A função "apagarTudo" limpa todos os dados salvos na lista caso o atributo
	 * "ADM" retorne true.
	 */
	public static void apagarTudo(Pessoa pessoa) {
		if (pessoa.getAdm()) {
			manifestacoes.clear();
			System.out.println("TODAS AS MANIFESTACOES FORAM APAGADAS");
		}
		System.err.println("USUARIO NAO TEM PERMICAO PARA APAGAR MANIFESTACOES");
	}

	@Override
	public String toString() {
		return "pessoa: " + pessoa.getNome() + "\nTipo: " + tipo + "\nManifestacao: " + manifestacao;
	}

}
