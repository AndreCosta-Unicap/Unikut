package View;

import java.util.Scanner;

import Logica.Unikut;

public class UnikutView {
	private Scanner s = new Scanner(System.in);
	private Unikut controller;
	
	public UnikutView(Unikut cont) {
		controller = cont;
	}
	
	public void menuStart() {
		System.out.println("Bem vindo ao UNIKUT!\n");
		System.out.println("Eh novo por aqui?");
		System.out.println("1 => Criar Nova Conta\n");

		System.out.println("Ja tem cadastro?");
		System.out.println("2 => Entrar na sua conta\n");

		System.out.println("Quer Nos Abandonar?");
		System.out.println("3 => para Sair");
		System.out.print("=>");

		int opcao = s.nextInt();
		s.nextLine();
		while (opcao != 3) {
			switch (opcao) {
			case 1 -> {
				controller.criarNovaConta();
				this.menuLogado();
			}
			case 2 -> {
				controller.login();
				this.menuLogado();
			}
			default -> System.out.println("\nComando inválido");
			}
		}
		System.out.println("Unikut encerrado!!!");
		Runtime.getRuntime().exit(0);
	}
	
	public void menuAddAmigos() {
		System.out.println("\nOla " + controller.currentAccount.getNome() + ".");
		System.out.println("\nMenu Adicionar Amigos");
		System.out.println("1 => Adicionar Amigo");
		System.out.println("2 => Voltar para o menu anterior");
		System.out.print("=>");
		int opcao = s.nextInt();
		s.nextLine();
		while (opcao != 2) {
			switch (opcao) {
				case 1 -> { // Adicionar amigo.
					System.out.println("\nDigite o login do amigo que quer adicionar:");
					String friendLogin = s.nextLine();
					while (!controller.verificaLogin(friendLogin)) {
						System.out.print("\nErro:\nNão encontramos esse usuario!!\nPor Favor digite novamente o login do seu amigo: ");
						friendLogin = s.nextLine();
					}
					controller.currentAccount.convidarAmigo(friendLogin);
					System.out.println("\nUm convite foi enviado para o amigo: " + friendLogin);
				}
			}
			this.menuAddAmigos();
		}
		this.menuLogado();
	}
	
	public void menuLogado() {
		System.out.println("\nOla " + controller.currentAccount.getNome() + ".");
		System.out.println("Seu Feed:\n");
		System.out.println("1 => Editar Perfil");
		System.out.println("2 => Ver Amigos");
		System.out.println("3 => Adicionar Amigos");
		System.out.println("4 => Recados");
		System.out.println("5 => para Sair");
		System.out.print("=>");
		int opcao = s.nextInt();
		s.nextLine();
		while (opcao != 5) {
			switch (opcao) {
			case 1 -> { // Editar perfil
				//menuEditar();
			}
			case 2 -> { // Exibir amigos
				//mostrarAmigos();
			}
			case 3 -> { // Adicionar amigos
				menuAddAmigos();
			}
			case 4 -> { // Enviar recados
				//menuRecados();
			}
			default -> System.out.println("\nComando inválido");
			}
			this.menuLogado();
			opcao = s.nextInt();
			s.nextLine();
		}

		System.out.println("Ate a proxima " + controller.currentAccount.getNome() + "!");
		//this.menuStart();
	}
}
