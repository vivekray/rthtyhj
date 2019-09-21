package com.ray.datastructures;

public class Customer {
	private int amount;
	

	public void deposit(int amount) {
		this.amount += amount;
	}

	public void withdraw(int amount) {
		if (this.amount > 0) {
			if (this.amount > amount) {
               this.amount-=amount;
			}
			else {
				System.out.println("Your Balance is Low to withdraw");
			}
		}
	}

	public void display() {
		System.out.println("Available balance::"+this.amount);
	}
}
