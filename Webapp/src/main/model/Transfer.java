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
 * 	from to track the budget items that the transfer takes place between.
 * 	it also adds the fromCategory and toCategory.
 */
public class Transfer extends Transaction{
	private String to;
	private String fromCategory;
	private String toCategory;
	
	/**
	 *	constructor
	 *
	 *	@param String from
	 *	@param String fromCategory
	 *	@param String to
	 *	@param String toCategory
	 *	@param double amount
	 *	@param String date
	 */
	public Transfer(String f, String fc, String t, String tc, double a, String d){
		super(f, a, d);
		this.to = t;
		this.fromCategory = fc;
		this.toCategory = tc;
	}
	
	// getter
	public String getFromCategory(){
		return this.fromCategory;
	}
	
	public String getTo(){
		return this.to;
	}
	
	public String getToCategory(){
		return this.toCategory;
	}
	
	// setter
	public boolean setFromCategory(String fc){
		if(fc == null || fc == "")
			return false;
		
		this.fromCategory = fc;		
		return true;
	}
	
	public boolean setTo(String t){
		if(t == null || t == "")
			return false;
		
		this.to = t;		
		return true;
	}
	
	public boolean setToCategory(String tc){
		if(tc == null || tc == "")
			return false;
		
		this.toCategory = tc;		
		return true;
	}
}