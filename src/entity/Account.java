package entity;

public class Account {
	
	private int id;
	private String name;
	private String password;
	private double balance;
	
	
	public Account() {};
	
	public Account(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	
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
	
	public boolean autenticar(String senha) {
		return this.password.equals(senha);
	}
	
	public void deposit(double deposit) {
		this.balance += deposit;
	}
	
	public void withdraw(double withdraw) {
		this.balance -= withdraw;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", password=" + password + ", balance=" + balance + "]";
	}
	
	
	
	
	
}
