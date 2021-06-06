package application;

import java.util.Scanner;

import entity.Account;
import entity.AccountsDB;
import entity.IdCount;

public class main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Seja bem vindo ao banco Bank!");
		
		boolean exit = false;
		IdCount idCount = new IdCount();
		AccountsDB accountsDB = new AccountsDB();
		Account account = null;
		
		System.out.println();
		
		do{
			System.out.println("-------------------------------------");
			System.out.println("     Escolha uma das opções abaixo:");
			System.out.println("-------------------------------------");
			System.out.println("1 - Acessar Conta");
			System.out.println("2 - Criar Conta");
			System.out.println("3 - Sair");
			System.out.print("Digite e pressione Enter: ");
			int button = sc.nextInt();
			System.out.println();
			
			switch(button) {
				case 1:{
					System.out.println("-------------------------------------");
					System.out.println("          Acessar Conta ");
					System.out.println("-------------------------------------");
					System.out.print("Digite o id: ");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.print("Digite a senha: ");
					String senha = sc.nextLine();
					Account entity = accountsDB.autenticar(id, senha);
					if(entity == null) {
						break;
					}else {
						account = entity;
					}
					
					break;
				}
				case 2:
					System.out.println("-------------------------------------");
					System.out.println("          Criar Conta ");
					System.out.println("-------------------------------------");
					sc.nextLine();
					System.out.print("Digite o nome: ");
					String nome = sc.nextLine();
										
					System.out.print("Digite a senha: ");
					String senha = sc.nextLine();
					
					int id = idCount.createId();
					
					account = new Account(id,nome,senha);
					accountsDB.addAccount(account);
					
					System.out.println("Conta Criada!");
					System.out.println(account);
					break;
				case 3:
					exit = true;
					System.out.println("Saindo...");
					break;
				default :
					System.out.println("Opção Invalida! Tente Novamente");
			}
			
			System.out.println();
		}	
		while(!exit);
		sc.close();
	}

}
