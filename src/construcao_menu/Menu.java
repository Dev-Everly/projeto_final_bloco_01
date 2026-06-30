package construcao_menu;

import java.util.InputMismatchException;
import java.util.Scanner;

 



public class Menu {

	private static final Scanner leia = new Scanner(System.in);

	
	public static void main(String[] args) {
		
		int opcao;
		

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
			
				keyPress(); 
				break;
			case 2:
				System.out.println("Listar todos os Produtos\n\n");
			
				keyPress();
				break;
			case 3:
				System.out.println("Consultar Produto pelo ID\n\n");
			
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar Produto\n\n");
				
				keyPress();
				break;
			case 5:
				System.out.println("Apagar Produto\n\n");
				
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
	}


