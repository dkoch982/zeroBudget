/**
 *	Author : Dan Koch
 *	Date   : 7-28-13
 *	Project: Zero Budget
 */

package model;

/**
 *	Abstract class includes common functions for the various types of transactions
 */
public abstract class Transaction{
	private String from;
	private double amount;
	private String date;

	public Transaction(String f, double a, String d){
		this.from = f;
		this.amount = a;
		this.date = d;
	}

	// getters
	public String getFrom(){
		return this.from;
	}

	public double getAmount(){
		return this.amount;
	}

	public String getDate(){
		return this.date;
	}

	// setters
	public boolean setFrom(String s){
		if(s == null || s == "")
			return false;
		
		this.from = s;

		return true;
	}

	public boolean setAmount(double a){
		if(a < 0)
			return false;

		this.amount = a;

		return true;
	}

	public boolean setDate(String d){
		if(d == null || d == "")
			return false;
		
		this.from = d;

		return true;
	}
}