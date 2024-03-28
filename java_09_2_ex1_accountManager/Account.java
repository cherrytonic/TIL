package java_09_2_ex1_accountManager;

public class Account {
	private final String key;
	private String name;
	private int number;
	Account(String key, String name, int number) {
		this.key = key;
		this.name = name;
		this.number = number;
	}
	public String getKey() {return key;}
	public String getName() {return name;}
	public int getNumber() {return number;}

	public void setName(String name) {
		this.name = name;
	}
	public void deposit(int number) {
		this.number += number;
	}

	public void withdrawl(int number) {
		if (this.number < number) {
			System.out.println("잔액이 부족합니다.");					
		} else {				
			this.number -= number;
			System.out.println("정상적으로 출금되었습니다.");
		}
	}
}
