package Aplication;

import Entitis.Adm;
import Entitis.Aluno;
import Entitis.Manifestacoes;
import Entitis.Pessoa;
import Exepition.Tratamentos;

public class Program {

	public static void main(String[] args) {
		Menus menu = new Menus();
		Tratamentos tratamento = new Tratamentos();

		Adm Adiministrador = new Adm("JACKSON", "ADM", "ADM");
		Pessoa.add(Adiministrador);
		Pessoa usuarioLogado;

		int ops = 0;
		while (ops != 3) {
			/*
			 * System.out.println("****************************************************");
			 * System.out.println("*  BEM VINDO AO SISTEMA DE OUVIDORIA DA UNIFACISA  *");
			 * System.out.println("****************************************************");
			 * System.out.println("*                  [1] CADASTRA-SE                 *");
			 * System.out.println("*                  [2] LOGAR                       *");
			 * System.out.println("*                  [3] SAIR                        *");
			 * System.out.println("****************************************************");
			 */
			System.out.println(menu.menuLoginCadastro());
			System.out.print("DIGITE A OPCAO DESEJADA: ");
			ops = tratamento.tratamentoMenu();

			switch (ops) {
			/*
			 * CADASTRA USUARIO
			 */
			case 1: {

				System.out.print("\nPOR FAVOR, DIGITE O SEU NOME: ");
				String nome = tratamento.tratamentoString().toUpperCase();
				System.out.print("\nINFORME O SEU EMAIL: ");
				String email = tratamento.tratamentoString().toUpperCase();
				;
				System.out.print("\nAGORA BASTA DIGITAR UMA SENHA FORTE: ");
				String senha = tratamento.tratamentoString().toUpperCase();
				;

				Aluno aluno = new Aluno(nome, email, senha);
				Pessoa.add(aluno);

				break;
			}
			/*
			 * LOGAR
			 */
			case 2: {

				System.out.println("\nOLA, TUDO BEM?\nESPERO QUE SIM.\n");
				System.out.print("POR FAVOR INFORME SEU EMAIL: ");
				String email = tratamento.tratamentoString().toUpperCase();
				System.out.print("\nAGORA BASTA DIGITAR SUA SENHA: ");
				String senha = tratamento.tratamentoString().toUpperCase();

				usuarioLogado = Pessoa.login(email, senha);

				if (usuarioLogado != null) {
					int opsUsuario = 0;
					while (opsUsuario != 5) {
						/*
						 * System.out.println("****************************************************");
						 * System.out.println("*                SEJA BEM VINDO!                   *");
						 * System.out.println("****************************************************");
						 * System.out.println("*          [1] CADASTRA MANIFESTACAO               *");
						 * System.out.println("*          [2] VER MANIFESTACOES                   *");
						 * System.out.println("*          [3] APAGAR MANIFESTACAO                 *");
						 * System.out.println("*          [4] APAGAR TODAS AS MANIFESTACOES       *");
						 * System.out.println("*          [5] SAIR                                *");
						 * System.out.println("****************************************************");
						 */
						System.out.println(menu.menuOpc());

						System.out.print("DIGITE A OPCAO DESEJADA: ");
						opsUsuario = tratamento.tratamentoMenu();
						switch (opsUsuario) {
						/*
						 * CADASTRA OCORRENCIA
						 */
						case 1: {
							if (usuarioLogado.getAdm()) {
								System.err.println("USUARIO NAO TEM PERMICAO PARA CADASTRA OCORRENCIAS!\n");
							} else {

								System.out.print("\nQUAL O TIPO DA SUA MANIFESTACAO: ");
								String tipo = tratamento.tratamentoString().toUpperCase();

								System.out.println("AGORA BASTA DIGITAR SUA MANIFESTACAO: ");
								String ocorrencia = tratamento.tratamentoString().toUpperCase();

								Manifestacoes manifestacao = new Manifestacoes(usuarioLogado, tipo, ocorrencia);
								Manifestacoes.addManifestacao(manifestacao);
							}

							break;
						}
						/*
						 * LISTAR
						 */
						case 2: {

							Manifestacoes.listar(usuarioLogado);

							break;
						}
						/*
						 * APAGAR
						 */
						case 3: {
							Manifestacoes.listar(usuarioLogado);
							System.out.println("DIGITE O ID DA MANIFESTACAO PARA APAGA.");
							int id = tratamento.tratamentoApagar();
							Manifestacoes.apagar(usuarioLogado, id);

							break;
						}
						/*
						 * APAGAR TUDO
						 */
						case 4: {
							Manifestacoes.apagarTudo(usuarioLogado);
							break;
						}
						}
					}
				} else {
					System.err.println("E-MAIL OU SENHA INVALIDO(A)\nPOR FAVOR TENTE NOVAMENTE.");
				}

			}
			}

		}
	}
}
