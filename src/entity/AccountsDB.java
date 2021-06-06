package entity;

import java.util.ArrayList;
import java.util.List;

public class AccountsDB {
	List<Account> accounts = new ArrayList<>();

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public void addAccount(Account account) {
		this.accounts.add(account);
	}
	
	public Account autenticar(int id, String senha) {
		Account account = accounts.stream().filter(x -> Integer.valueOf(x.getId()).equals(id)).findFirst().orElse(null);
		if(account != null) {
			if(account.autenticar(senha)) {
				System.out.println("Conta Autenticada");
				return account;
			}else {
				System.out.println("Senha Invalida");
				account = null;
			}
		}else {
			System.out.println("Id não encontrado");
		}
		return account;
	}
	
	
}
