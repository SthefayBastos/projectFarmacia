package farmacia;

import java.io.IOException;
import java.util.Scanner;

import farmacia.controller.ProdutoController;
import farmacia.model.Cosmético;
import farmacia.model.Medicamento;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		ProdutoController produto = new ProdutoController();

		int opcao, id, tipo;
		String nome, generico, fragancia;
		double preco;

		do {
			// menu com opções
			System.out.println("|---------------------------------------------|");
			System.out.println("|                                             |");
			System.out.println("|                  FarmaVida                  |");
			System.out.println("|                                             |");
			System.out.println("|---------------------------------------------|");
			System.out.println("|                                             |");
			System.out.println("|       1 - Criar Produto                     |");
			System.out.println("|       2 - Listar produtos                   |");
			System.out.println("|       3 - Consultar produto                 |");
			System.out.println("|       4 - Atualizar Produto                 |");
			System.out.println("|       5 - Excluir produto                   |");
			System.out.println("|       6 - Sair                              |");
			System.out.println("|                                             |");
			System.out.println("|---------------------------------------------|");
			System.out.println("| Entre com a opção desejada:                 |");
			System.out.println("|---------------------------------------------|");

			// gravar a opçao desejada

			opcao = leia.nextInt();

			// se comunicar com o controller que executará a ação da opção
			switch (opcao) {

			case 1 -> {

				System.out.println("Criar produto: ");

				// entrada de dados id, nome, tipo e preço

				System.out.println("Digite o nome do produto: ");
				leia.skip("\\R");
				nome = leia.nextLine();

				// definir tipo medicamento ou cosmético
				System.out.println("Digite o tipo do produto: ");
				System.out.println("1- Medicamento");
				System.out.println("2- Cosmético");

				tipo = leia.nextInt();

				System.out.println("Digite o preço do produto: ");
				preco = leia.nextDouble();

				switch (tipo) {
				// entrada de dados escolha tipo
				case 1 -> {
					leia.skip("\\R");
					System.out.println("Digite o nome do medicamento genérico: ");
					generico = leia.nextLine();
					produto.criarProduto(new Medicamento(produto.gerarId(), tipo, nome, preco, generico));

				}
				case 2 -> {
					leia.skip("\\R");
					System.out.println("Digite o nome da fragância: ");
					fragancia = leia.nextLine();
					produto.criarProduto(new Cosmético(produto.gerarId(), tipo, nome, preco, fragancia));
					// int id, int tipo, String nome, double preco, String fragancia
				}

				// adicionar prod criado a arrayList(utilizar Classe Controller)

				}
			}
			case 2 -> {

				System.out.println(" Lista dos produtos cadastrados: ");
				produto.listarTodosProdutos();
				keyPress();
			}

			case 3 -> {

				System.out.println("Consultar produto. ");
				System.out.println("Digite o ID do produto: ");

				id = leia.nextInt();

				produto.consultarProdutoId(id);

				keyPress();
			}
			case 4 -> {

				System.out.println("Atualizar produto no estoque: ");
				
				System.out.println("Digite o ID do produto: ");
				id = leia.nextInt();
					if (produto.buscarNaList(id).isPresent()) {
						
					
				System.out.println("Digite o nome do produto: ");
				leia.skip("\\R");
				nome = leia.nextLine();

				// definir tipo medicamento ou cosmético
				System.out.println("Digite o tipo do produto: ");
				System.out.println("1- Medicamento");
				System.out.println("2- Cosmético");

				tipo = leia.nextInt();

				System.out.println("Digite o preço do produto: ");
				preco = leia.nextDouble();

				switch (tipo) {
				// entrada de dados escolha tipo
				case 1 -> {
					leia.skip("\\R");
					System.out.println("Digite o nome do medicamento genérico: ");
					generico = leia.nextLine();
					produto.atualizarProduto(new Medicamento (id, tipo, nome, preco, generico));

				}
				case 2 -> {
					leia.skip("\\R");
					System.out.println("Digite o nome da fragância: ");
					fragancia = leia.nextLine();
					produto.atualizarProduto( new Cosmético( id, tipo, nome, preco, fragancia));
					keyPress();
				}
				}
				}
			}

			case 5 -> {

				System.out.println("Excluir produto: ");
				System.out.println("Digite o número ID do produto: ");
				id = leia.nextInt();
				produto.deletarProduto(id);
				keyPress();
			}
			case 6 -> {

				System.out.println("Sair do menu de opções!");
				sobre();
			}
			default -> {
				System.out.println("Opção inválida");
				keyPress();
			}
			}
		} while (opcao != 6);

	}

	// Escrever bloco de "sobre"
	public static void sobre() {

		System.out.println("|---------------------------------------------------------|");
		System.out.println("|Projeto Desenvolvido por: Sthefany Sousa                 |");
		System.out.println("|Sthefany Sousa -  sthefanysousageneration@gmail.com      |");
		System.out.println("|https://github.com/SthefayBastos                         |");
		System.out.println("|---------------------------------------------------------|");
	}

	// Implementar Keypress
	public static void keyPress() {
		try {

			System.out.println("Precione a tecla ENTER para continuar");
			System.in.read();

		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla inválida!");
		}
	}
}
