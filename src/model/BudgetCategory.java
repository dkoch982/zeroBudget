/**
 *	Author : Dan Koch
 *	Date   : 7-28-13
 *	Project: Zero Budget
 */

package model;

import java.util.HashMap;
import java.util.Map;

/**
 * 	BudgetCategory helps organize the budget by breaking it up into
 * 	related budget expenses such as housing, transportation, or food.
 *	Each BudgetCategory has a name to describe the category and 
 *	a list of BudgetItem's that belong to that category.
 */
public class BudgetCategory{
	private String name;
	private Map items;
		
	/**
	 * 	constructor for new BudgetCategory
	 * 
	 * 	@param String category_name
	 */
	public BudgetCategory(String category_name){
		if(category_name == null || category_name == "")
			this.name = "unknown";
		else
			this.name = category_name;
	
		this.items = new HashMap();
	}
	
	/**
	 * 	constructor for existing BudgetCategory
	 * 
	 * 	@param String category_name
	 * 	@param HashMap map
	 */
	public BudgetCategory(String category_name, HashMap map){
		if(category_name == null || category_name == "")
			this.name = "unknown";
		else
			this.name = category_name;
		
		if(map == null)
			this.items = new HashMap();
		else
			this.items = map;
	}
	
	// getters
	public String getName(){
		return this.name;
	}
	
	public Map getItems(){
		return this.items;
	}
	
	// setters
	public boolean setName(String new_name){
		if(new_name == null || new_name == "")
			return false;
		
		this.name = new_name;
		return true;
	}
	
	public boolean setItems(HashMap map){
		if(map == null)
			return false;
		
		this.items = map;
		return true;
	}
	
	/**
	 *  this function takes a new BudgetItem object and adds it to items
	 *	
	 *	@param String key
	 *  @param BudgetItem item
	 *  
	 *  @return true if successful, false if not
	 */
	public boolean addBudgetItem(String key, BudgetItem item){
		if(key == null || key == "" || item == null)
			return false;
		
		this.items.put(key, item);	
		return true;
	}
	
	/**
	 * 	this function removes a specified BudgetItem from items
	 * 
	 * 	@param String key
	 * 
	 * 	@return true if successful, false if not
	 */
	public boolean removeBudgetItem(String key){
		if(key == null || key == "" || !this.items.containsKey(key))
			return false;

		this.items.remove(key);
		return true;
	}

	/**
	 *  this function returns the number of items in the category
	 * 
	 * 	@return int
	 */
	public int getNumberOfItems(){
		return this.items.size();
	}
	
	/**
	 *  this function returns the object requested from the list array
	 *  it does not remove the object from the Map
	 *  
	 *  @param String key
	 *  
	 *  @return requested BudgetItem or null
	 */
	public BudgetItem getBudgetItem(String key){
		if(key == null || key == "")
			return null;
		
		return this.items.get(key);
	}
	
	/**
	 *  this function returns the total budgeted amount for the category
	 *  by adding up the budgeted amounts for all the items in the category
	 *  
	 *  @return double
	 */
	public double getCategoryBudgetedAmount(){
		double total = 0.00;		
		for(BudgetItem item : this.items)
			total += item.getBudgeted();
		
		return total;
	}
	
	/**
	 *  this function returns the total amount distributed to items in the category
	 *	by adding up all the distributed values for all the items
	 *
	 *	@return double
	 */
	public double getCategoryDistributedAmount(){
		double total = 0.00;
		for(BudgetItem item : this.items)
			total += item.getDistributed();
		
		return total;
	}
	
	/**
	 * 	this function returns the total amount spent for the category
	 * 	by adding up all the spent amounts from the items in the category
	 * 
	 * 	@return double
	 */
	public double getCategorySpentAmount(){
		double total = 0.00;
		for(BudgetItem item : this.items)
			total += item.getSpent();
		
		return total;		
	}
	
	/**
	 *  this function returns the total cash flow for the budget 
	 *  by adding up each items cash flow
	 *  
	 *  @return double
	 */

	public double getCategoryCashFlow(){
		double total = 0.00;
		for(BudgetIem item : this.items)
			total += item.getCashFlow();
		
		return total;
	}
}