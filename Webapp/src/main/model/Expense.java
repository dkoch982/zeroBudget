/**
 *	Author : Dan Koch
 *	Date   : 7-28-13
 *	Project: Zero Budget
 */

package model;

/**	
 * 	Expense extends Transaction and is used to track a user's spending transactions.
 *	it adds a budget_item attribute to link the expense to the budget item in
 *	the budget
 */
public class Expense extends Transaction{
	private String category;
	private String item;
	
	/**
	 * 	constructor
	 * 
	 * 	@param String from
	 * 	@param double amount
	 * 	@param String date
	 * 	@param String budget_category
	 * 	@param String budget_item
	 */
	public Expense(String from, double amount, String date, String budget_category, String budget_item){
		super(from, amount, date);
		this.category = budget_category;
		this.item = budget_item;
	}
	
	// getters
	public String getBudgetCategory(){
		return this.category;
	}
	
	public String getBudgetItem(){
		return this.item;
	}
	
	// setters
	public boolean setBudgetCategory(String bc){
		if(bc == null || bc == "")
			return false;
		
		this.category = bc;
		return true;
	}
	
	public boolean setBudgetItem(String bi){
		if(bi == null || bi == "")
			return false;
		
		this.item = bi;
		return true;
	}
}