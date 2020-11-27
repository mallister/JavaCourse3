package model.entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class User implements Comparable<User>{
	
	private String name;
	private Double accountBalance;
	private String email;
	private Long creditCard;
	private String country;
	
	
	
	public User(String name, Double accountBalance, String email, Long creditCard, String country) {

		this.name = name;
		this.accountBalance = accountBalance;
		this.email = email;
		this.creditCard = creditCard;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(Long creditCard) {
		this.creditCard = creditCard;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void sendToDb(Set<User> list) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\artur\\Desktop\\java workspace\\in.txt"));			
			for (Object user : list) {
				bw.newLine();
				bw.write(user.toString());
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
	
	@Override
	public int compareTo(User other) {
		
		return creditCard.compareTo(other.getCreditCard());
	}
	
	@Override
	public String toString() {
		return getName() + "," + String.format("%.2f", getAccountBalance())+ " " + getCreditCard() + " " + getEmail() + " " + getCountry();
	}
}
