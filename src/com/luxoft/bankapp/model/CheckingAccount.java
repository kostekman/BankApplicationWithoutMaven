package com.luxoft.bankapp.model;

import com.luxoft.bankapp.exceptions.BankException;
import com.luxoft.bankapp.exceptions.OverDraftLimitExceededException;

public class CheckingAccount extends AbstractAccount implements Account {
	private float overdraft;
	
	public CheckingAccount(float balance, float overdraft) {
		super(balance);
		this.overdraft = overdraft;
	}
	
	@Override
	public void withdraw(float amount) throws BankException{
		if(amount > super.getBalance() + overdraft){
			System.out.println("You cannot withdraw more then your overdraft limit");
			throw new OverDraftLimitExceededException(amount - overdraft - getBalance(), this);
		}
		else
			super.withdraw(amount);
	}

	public void setOverdraft(float overdraft) {
		this.overdraft = overdraft;
	}
	
	public float getOverdraft() {
		return overdraft;
	}

	public void printReport(){
		System.out.printf(this.toString());

	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("\nCheckingAccount, balance: " + Float.valueOf(super.getBalance()).toString());
		sb.append(" overdraft: " + Float.valueOf(this.overdraft).toString());
		return sb.toString();
	}

}
