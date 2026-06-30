package construcao_menu;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import construcao.model.Ferramenta;
import construcao.model.Produto;
import construcao.model.Tinta;

import controller.ProdutoController;

 



public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	private static final ProdutoController produtoController = new ProdutoController();

	
	public static void main(String[] args) {
		
		int opcao;
		
		criarProdutosTeste();
 		/*
		 * Produto p1 = new Ferramenta(1,"Furadeira", 1, 390.00f, "Bosh");
		 * p1.visualizar();
		 * 
		 * Produto p2 = new Tinta(1, "Suvinil", 2, 250.90f, "Azul",18); p2.visualizar();
		 */
		

		// Laço de repetição que mantém o menu rodando até a opção sair ser acionada
		while (true) {

			System.out.println(
					 "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                CONSTRUÇÃO                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar Produto                          ");
			System.out.println("            2 - Listar todos os Produtos               ");
			System.out.println("            3 - Buscar Produto pelo ID             ");
			System.out.println("            4 - Atualizar Dados do Produto             ");
			System.out.println("            5 - Apagar Produto                        ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " );

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			}catch(InputMismatchException e) {
				opcao = -1;
				System.out.println("\nDigite um número inteiro entre 0 e 8");
				leia.nextLine();
			}

			if (opcao == 0) {
				System.out.println( "\n CASA & CONSTRUÇÃO ");
				sobre();
				leia.close();
				System.exit(0);
			}

			// Verifica qual opção do menu o usuário escolheu e executa a ação
		 
			switch (opcao) {
			case 1:
				System.out.println( "Criar Produto\n\n");
				cadastrarProduto();
			
				keyPress(); 
				break;
			case 2:
				System.out.println("Listar todos os Produtos\n\n");
				listarProdutos() ;
				keyPress();
				break;
			case 3:
				System.out.println("Consultar Produto pelo ID\n\n");
				procurarProdutoPorId();
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar Produto\n\n");
				atualizarProduto();
				keyPress();
				break;
			case 5:
				System.out.println("Apagar Produto\n\n");
				deletarPorId();
				
				keyPress();
				break;
		
				
			default:
				System.out.println( "\nOpção Inválida!\n");
				break;
			}
		}
	}
	

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Everly");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/Dev-Everly");
		System.out.println("*********************************************************");
	}
	
	// Método responsável por aguardar o usuário pressionar a tecla Enter para Continuar
		 
	public static void keyPress() {
		System.out.println("\n\nPressione Enter para continuar...");
		leia.nextLine();
	}
	
	private static void criarProdutosTeste() {
		produtoController
				.cadastrar(new Ferramenta(produtoController.gerarId(),"Furadeira", 1, 390.00f, "Bosh"));
		produtoController
				.cadastrar(new Tinta(produtoController.gerarId(), "Suvinil", 2, 350.00f, "Azul",18));
	}
	
	// Método responsável por listar todos os produtos
		private static void listarProdutos() {
			produtoController.listarTodos();
		}
		
		private static void cadastrarProduto() {

		    System.out.print("Digite o nome do Produto: ");
		    
		    String nome = leia.nextLine();

		    System.out.print("Digite a Categoria (1 - Ferramenta | 2 - Tinta): ");
		    int categoria = leia.nextInt();

		    System.out.print("Digite o Preço: ");
		    float preco = leia.nextFloat();
		    leia.nextLine(); // limpa o Enter

		    switch (categoria) {

		        case 1 -> {

		            System.out.print("Digite a marca: ");
		            String marca = leia.nextLine();

		            produtoController.cadastrar(
		                    new Ferramenta(produtoController.gerarId(), nome, categoria, preco, marca));
		        }

		        case 2 -> {

		            System.out.print("Digite a cor: ");
		            String cor = leia.nextLine();

		            System.out.print("Digite o rendimento: ");
		            double rendimento = leia.nextDouble();

		            produtoController.cadastrar(
		                    new Tinta(produtoController.gerarId(), nome, categoria, preco, cor, rendimento));
		        }

		        default -> System.out.println("Categoria inválida!");
		    }
		}
		
		// Método responsável por procurar uma produto já cadastrada pelo número
		private static void procurarProdutoPorId() {

			System.out.print("Digite o número da produto: ");
			int id = leia.nextInt();
			leia.nextLine();

			produtoController.procurarPorId(id);
		}
		
		public static void deletarPorId() {

		    System.out.print("Digite o ID do produto: ");
		    int id = leia.nextInt();
		    leia.nextLine(); // Limpa o buffer

		    Optional<Produto> produto = produtoController.buscarNaCollection(id);

		    if (produto.isPresent()) {

		        System.out.printf("\nTem certeza que deseja excluir o Produto de ID %d? (S/N): ", id);
		        String confirmacao = leia.nextLine();

		        if (confirmacao.equalsIgnoreCase("S")) {
		            produtoController.deletar(id);
		        } else {
		            System.out.println("\nOperação cancelada!");
		        }

		    } else {
		        System.out.printf("\nProduto de ID %d não foi encontrado!%n", id);
		    }
		}
		public static void atualizarProduto() {

		    System.out.println("Digite o ID do produto: ");
		    int id = leia.nextInt();
		    leia.nextLine();

		    Optional<Produto> produto = produtoController.buscarNaCollection(id);

		    if (produto.isPresent()) {

		        Produto produtoEncontrado = produto.get();

		        // Dados atuais
		        String nome = produtoEncontrado.getNome();
		        int tipo = produtoEncontrado.getCategoria();
		        float preco = produtoEncontrado.getPreco();

		        // Atualiza o nome
		        System.out.printf("Nome atual: %s%nDigite o novo nome (ENTER para manter): ", nome);
		        String entrada = leia.nextLine();
		        nome = entrada.isEmpty() ? nome : entrada;

		        // Atualiza o preço
		        System.out.printf("Preço atual: %.2f%nDigite o novo preço (ENTER para manter): ", preco);
		        entrada = leia.nextLine();
		        preco = entrada.isEmpty() ? preco : Float.parseFloat(entrada.replace(",", "."));

		        switch (tipo) {

		            case 1 -> {

		                Ferramenta ferramenta = (Ferramenta) produtoEncontrado;

		                String marca = ferramenta.getMarca();

		                System.out.printf("Marca atual: %s%nDigite a nova marca (ENTER para manter): ", marca);
		                entrada = leia.nextLine();
		                marca = entrada.isEmpty() ? marca : entrada;

		                produtoController.atualizar(
		                        new Ferramenta(id, nome, tipo, preco, marca));
		            }

		            case 2 -> {

		                Tinta tinta = (Tinta) produtoEncontrado;

		                String cor = tinta.getCor();
		                double rendimento = tinta.getRendimento();

		                System.out.printf("Cor atual: %s%nDigite a nova cor (ENTER para manter): ", cor);
		                entrada = leia.nextLine();
		                cor = entrada.isEmpty() ? cor : entrada;

		                System.out.printf("Rendimento atual: %.2f%nDigite o novo rendimento (ENTER para manter): ", rendimento);
		                entrada = leia.nextLine();

		                rendimento = entrada.isEmpty()
		                        ? rendimento
		                        : Double.parseDouble(entrada.replace(",", "."));

		                produtoController.atualizar(
		                        new Tinta(id, nome, tipo, preco, cor, rendimento));
		            }

		            default -> System.out.println("Categoria inválida!");
		        }

		    } else {
		        System.out.printf("%nProduto com ID %d não foi encontrado!%n", id);
		    }
		}
	}


