package application;

import java.util.Locale;
import java.util.Scanner;

import entity.Account;
import entity.AccountsDB;
import entity.IdCount;
import entity.enums.TypeAccount;

public class main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);	
		System.out.println("Seja bem vindo ao banco Bank!");
		
		boolean exit = false;
		IdCount idCount = new IdCount();
		AccountsDB accountsDB = new AccountsDB();
				
		System.out.println();
		
		do{
			Account account = null;
			
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
					}
					account = entity;
					System.out.println();
					System.out.println("Seja bem vindo " + account.getName());
					boolean logoff = false;
					do {
						System.out.println("-------------------------------------");
						System.out.println("     Escolha uma das opções abaixo:");
						System.out.println("-------------------------------------");
						System.out.println("1 - Ver Saldo");
						System.out.println("2 - Depositar");
						System.out.println("3 - Saque");
						System.out.println("4 - Ver Informações da Conta");
						System.out.println("0 - Sair");
						System.out.print("Digite e pressione Enter: ");
						int buttonAccount = sc.nextInt();
						System.out.println();
						
					
						switch(buttonAccount) {
							case 1:{
								System.out.printf("Saldo: R$ %.2f\n",account.getBalance());
								break;
							}
							case 2:{
								System.out.print("Digite o valor para deposito R$:");
								double value = sc.nextDouble();
								if(value <= 0.0) {
									System.out.println("Valor Invalido!");
									break;
								}
								account.deposit(value);
								break;
							}
							case 3:{
								System.out.print("Digite o valor para saque R$:");
								double value = sc.nextDouble();
								if(value <= 0.0) {
									System.out.println("Valor Invalido!");
									break;
								}
								if(value > account.getBalance()) {
									System.out.println("Você não possui esse valor!");
									break;
								}
								account.withdraw(value);
								break;
							}
							case 4:{
								System.out.println(account);
								break;
							}
							case 0:{
								System.out.println("Saindo...");
								logoff = true;
								break;
							}
						}
					}while(!logoff);
					
					break;
				}
				case 2:
					System.out.println("-------------------------------------");
					System.out.println("          Criar Conta ");
					System.out.println("-------------------------------------");
					sc.nextLine();
					
					TypeAccount typeAccount = null;
					
					System.out.println("Qual tipo de conta quer abrir? ");
					System.out.println("1 - Conta Poupança");
					System.out.println("2 - Conta Corrente");
					System.out.print("Digite e pressione Enter: ");
					int accountType = sc.nextInt();
					sc.nextLine();
					switch(accountType) {
						case 1:{
							typeAccount =  TypeAccount.CONTA_POUPANCA;
							break;
						}
						case 2:{
							typeAccount = TypeAccount.CONTA_CORRENTE;
							break;
						}
						default:{
							System.out.println("Valor Invalido!");
							break;
						}
					}
					if(typeAccount == null) {
						break;
					}
					
					
					System.out.print("Digite o nome: ");
					String nome = sc.nextLine();
										
					System.out.print("Digite a senha: ");
					String senha = sc.nextLine();
					
					int id = idCount.createId();


					account = new Account(id,nome,senha,typeAccount);
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
