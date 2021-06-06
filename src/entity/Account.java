package entity;

import entity.enums.TypeAccount;

public class Account {
	
	private int id;
	private String name;
	private String password;
	private double balance;
	private TypeAccount typeAccount;
	
	
	public Account() {};
	
	public Account(int id, String name, String password, TypeAccount typeAccount) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.typeAccount = typeAccount;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public TypeAccount getTypeAccount() {
		return typeAccount;
	}

	public void setTypeAccount(TypeAccount typeAccount) {
		this.typeAccount = typeAccount;
	}

	public boolean autenticar(String senha) {
		return this.password.equals(senha);
	}
	
	public void deposit(double deposit) {
		this.balance += deposit;
	}
	
	public void withdraw(double withdraw) {
		if(typeAccount.equals(TypeAccount.CONTA_POUPANCA)) {
			this.balance -= withdraw - 5.0;
		}
		this.balance -= withdraw;	
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", password=" + password + ", balance=" + balance
				+ ", typeAccount=" + typeAccount + "]";
	}


	
	
	
	
}
