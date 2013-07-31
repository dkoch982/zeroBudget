/**
 *	Author : Dan Koch
 *	Date   : 7-28-13
 *	Project: Zero Budget
 */

package model;

/** 
 * 	Transfer extends Transaction and is used to keep track of
 * 	any transfers between budget items that the user performs.
 * 	it adds the to attribute which will be used along with the
 * 	from to track the budget items that the transfer takes place between
 */
public class Transfer extends Transaction{
	private String to;
	
	/*
	 *	constructor
	 *
	 *	@param string from
	 *	@param string to
	 *	@param double amount
	 *	@param string date
	 */
	public Transfer(String f, String t, double a, String d){
		super(f, a, d);
		this.to = t;
	}
	
	// getter
	public String getTo(){
		return this.to;
	}
	
	// setter
	public boolean setTo(String t){
		if(t == null || t == "")
			return false;
		
		this.to = t;
		
		return true;
	}
}