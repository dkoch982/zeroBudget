/**
 *	Author : Dan Koch
 *	Date   : 7-28-13
 *	Project: Zero Budget
 */

package model;

/**
 *	Abstract class includes common functions for the various types of transactions
 */
public class Transaction{
	private String from;
	private double amount;
	private String date;

	/**
	 * 	constructor
	 * 
	 * 	@param String who_from
	 * 	@param double transaction_amount
	 * 	@param String date_of
	 */
	public Transaction(String who_from, double transaction_amount, String date_of){
		this.from = who_from;
		this.amount = transaction_amount;
		this.date = date_of;
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