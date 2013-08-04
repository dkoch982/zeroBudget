/**
 *	Author : Dan Koch
 *	Date   : 7-28-13
 *	Project: Zero Budget
 */

package model;

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;

/**
 * 	the Budget class is responsible for organizing the user's monthly budget.
 *	it contains a period number 1-12 to represent one of the 12 periods that make
 *	up a fiscal year and an array of BudgetCategories that make up the user's budget
 */
class Budget{
	private int periodNumber;
	private HashMap<String, BudgetCategory> categories;
	private List<Expense> expenses;
	private List<Transfer> transfers;
	
	/**
	 * 	constructor for new Budget
	 * 
	 * 	@param int period
	 * 	
	 * 	@return Budget object
	 */
	public Budget(int period){
		if(period < 1 || period > 12)
			this.periodNumber = 99;
		else
			this.periodNumber = period;
		
		this.categories = new HashMap<String, BudgetCategory>();
		this.expenses = new LinkedList<Expense>();
		this.transfers = new LinkedList<Transfer>();
	}
	
	/**
	 * 	constructor for an existing Budget
	 * 
	 * 	@param int period
	 * 	@param HashMap<String BudgetCategory> category_list
	 * 	@param List<Expense> expense_list
	 * 	@param List<Transfer> transfer_list
	 * 
	 * 	@return Budget object
	 */
	public Budget(int period, HashMap<String, BudgetCategory> category_list, List<Expense> expense_list, List<Transfer> transfer_list){
		if(period < 1 || period > 12)
			this.periodNumber = 99;
		else
			this.periodNumber = period;
		
		this.categories = category_list;
		this.expenses = expense_list;
		this.transfers = transfer_list;
	}
	
	// getters
	public int getPeriodNumber(){
		return this.periodNumber;
	}
	
	public HashMap<String, BudgetCategory> getCategories(){
		return this.categories;
	}
	
	public List<Expense> getExpenses(){
		return this.expenses;
	}
	
	public List<Transfer> getTransfers(){
		return this.transfers;
	}

	
	// setters
	public boolean setPeriodNumber(int period){
		if(period < 1 || period > 12)
			return false;
		
		this.periodNumber = period;
		return true;
	}
	
	public boolean setCategories(HashMap<String, BudgetCategory> category_list){
		if(category_list == null)
			return false;
		
		this.categories = category_list;
		return true;
	}
	
	public boolean setExpenses(List<Expense> expense_list){
		if(expense_list == null)
			return false;
		
		this.expenses = expense_list;
		return true;
	}
	
	public boolean setTransfers(List<Transfer> transfer_list){
		if(transfer_list == null)
			return false;
		
		this.transfers = transfer_list;
		return true;
	}

	/**
	 *  this function adds a new BudgetCategory to categories
	 *  
	 *  @param BudgetCategory category
	 *  
	 * 	@return true on success, false otherwise
	 */
	public boolean addCategory(BudgetCategory category){
		if(category == null)
			return false;
		
		this.categories.put(category.getName(), category);		
		return true;
	}
	
	/**
	 *  this function removes a specified BudgetCategory from categories
	 * 
	 * 	@param String name
	 * 	
	 * 	@return true if successful, false otherwise
	 */
	public boolean removeCategory(String name){
		if(name == null || name == "" || !this.categories.containsKey(name))
			return false;
		
		this.categories.remove(name);
		return true;
	}

	/**
	 *  this function returns the number of categories
	 * 
	 * 	@return int
	 */
	public int getNumberOfCategories(){
		return this.categories.size();
	}
	
	/**
	 *  this function returns the BudgetCategory with the specified name if it exists
	 *  it does not remove the object from the HashMap
	 * 
	 *  @param String name
	 *  
	 *  @return BudgetCategory or null
	 */
	public BudgetCategory getCategory(String name){
		if(name == null || name == "")
			return null;
		
		return this.categories.get(name);
	}

	/**
	 *  this function returns the total budgeted amount for the budget
	 *  by adding up the budgeted amounts for all the items in all the categories
	 *  
	 *  @return double
	 */
	public double getBudgetedAmount(){
		// return 0.00 if categories is empty
		if(this.categories.isEmpty())
			return 0.00;
	
		// otherwise add them up
		double total = 0.00;
		for(Map.Entry<String, BudgetCategory> item : this.categories.entrySet()){
			total += item.getValue().getCategoryBudgetedAmount();
		}
	
		return total;
	}
	
	/**
	 *  this function returns the total amount distributed to items in the budget
	 *  by adding up all the distributed values for all the items in the categories
	 *  
	 *  @return double
	 */
	public double getDistributedAmount(){
		// return 0.00 if categories is empty
		if(this.categories.isEmpty())
			return 0.00;
	
		// otherwise add them up
		double total = 0.00;
		for(Map.Entry<String, BudgetCategory> item : this.categories.entrySet()){
			total += item.getValue().getCategoryDistributedAmount();
		}
	
		return total;
	}
	
	/**
	 *  this function returns the total amount spent for the budget
	 *  by adding up all the spent amounts from the items in the categories
	 *  
	 *  @return double
	 */
	public double getSpentAmount(){
		// return 0.00 if categories is empty
		if(this.categories.isEmpty())
			return 0.00;
	
		// otherwise add them up
		double total = 0.00;
		for(Map.Entry<String, BudgetCategory> item : this.categories.entrySet()){
			total += item.getValue().getCategorySpentAmount();
		}
	
		return total;
	}
	
	/**
	 *  this function returns the total cash flow for the budget
	 *  by adding up all the cash flow amounts for all the categories
	 *  
	 *  @return double
	 */
	public double getCashFlow(){
		// return 0.00 if categories is empty
		if(this.categories.isEmpty())
			return 0.00;
	
		// otherwise add them up
		double total = 0.00;
		for(Map.Entry<String, BudgetCategory> item : this.categories.entrySet()){
			total += item.getValue().getCategoryCashFlow();
		}
		
		return total;
	}
	
	/**
	 *  this function adds an expense to the budget
	 *  
	 * @param Expense expense_transaction
	 * 
	 * @return true if successful, false otherwise
	 */
	public boolean addExpenseTransaction(Expense expense_transaction){
		if(expense_transaction == null)
			return false;
		
		// add the expense to the end of expenses
		this.expenses.add(expense_transaction);
		
		// add the expense cost to the budget item
		this.categories.get(expense_transaction.getBudgetCategory())
			.getBudgetItem(expense_transaction.getBudgetItem())
			.spendAmount(expense_transaction.getAmount());
		
		return true;
	}
	
	/**
	 *  add a transfer between two budget items
	 *  
	 * 	@param Transfer transfer_transaction
	 * 
	 * 	@return true on success, false otherwise
	 */
	public boolean addTransfer(Transfer transfer_transaction){
		if(transfer_transaction == null)
			return false;
		
		// add the transfer to the end of transfers
		this.transfers.add(transfer_transaction);
		
		// perform the transfer
		this.categories.get(transfer_transaction.getFromCategory())
			.getBudgetItem(transfer_transaction.getFrom())
			.transfer(transfer_transaction.getAmount());
		
		this.categories.get(transfer_transaction.getToCategory())
			.getBudgetItem(transfer_transaction.getTo())
			.distributeAmount(transfer_transaction.getAmount());
		
		return true;
	}
}