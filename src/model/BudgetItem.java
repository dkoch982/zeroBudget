/**
 *	Author : Dan Koch
 *	Date   : 7-28-13
 *	Project: Zero Budget
 */

package model;

/**
 * 	BudgetItem tracks the individual items on a user's budget.
 * 	The user's budget is organized into BudgetCategories which
 *	contain a list of BudgetItems.  Each BudgetItem tracks:
 *
 *	1. the name of the item
 *	2. the budgeted amount for that item for the period
 *	3. the amount distributed to the item for the period
 *	4. the amount spent from the item for the period
 */

public class BudgetItem{
	private String name;
	private double budgeted;
	private double distributed;
	private double spent;
	
	/** 
     *	constructor for new BudgetItem
     *
	 *  @param String item_name
	 *  @param double budgeted_amount
	 */
	public BudgetItem(String item_name, double budgeted_amount){
		this.name = item_name;
		this.budgeted = budgeted_amount;
		this.distributed = 0.00;
		this.spent = 0.00;
	}
	
	/** 
     *	constructor for existing BudgetItem
     *
	 *  @param String item_name
	 *  @param double budgeted_amount
	 *  @param double distributed_amount
	 *  @param double spent_amount
	 */
	public BudgetItem(String item_name, double budgeted_amount, double distributed_amount, double spent_amount){
		this.name = item_name;
		this.budgeted = budgeted_amount;
		this.distributed = distributed_amount;
		this.spent = spent_amount;
	}
	
	// getters
	public String getName(){
		return this.name;
	}
	
	public double getBudgeted(){
		return this.budgeted;
	}
	
	public double getDistributed(){
		return this.distributed;
	}
	
	public double getSpent(){
		return this.spent;
	}
	
	// setters
	public boolean setName(String new_name){
		if(new_name == null || new_name == "")
			return false;
		 
		this.name = new_name;		
		return true;
	}
	
	public boolean setBudgeted(double new_budgeted){
		if(new_budgeted < 0.00)
			return false;
		 
		this.budgeted = new_budgeted;		
		return true;
	}
	
	public boolean setDistributed(double new_distributed){
		if(new_distributed < 0.00)
			return false;
		 
		this.distributed = new_distributed;		
		return true;
	}
	
	public boolean setSpent(double new_spent){
		if(new_spent < 0.00)
			return false;
		 
		this.spent = new_spent;		
		return true;
	}
	
	// this function is used to distribute money to the item
	public boolean distributeAmount(double amount){
		if(amount < 0.00)
			return false;
					
		this.distributed += amount;		
		return true;
	}
	
	// this function is used to add spending to the item
	public boolean spendAmount(double amount){
		if(amount < 0.00)
			return false;
		
		this.spent += amount;		
		return true;
	}
	
	// used to transfer from distributed
	public boolean transfer(double amount){
		if(amount < 0.00)
			return false;
		
		this.distributed -= amount;		
		return true;
	}
	
	/**	
	 * 	this function returns the cash flow
	 * 	cash flow = distributed - spent
	 * 
	 * 	@return double
	 */
	public double getCashFlow(){
		return (this.distributed - this.spent);
	}
}