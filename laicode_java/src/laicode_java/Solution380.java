package laicode_java;

import java.util.*;
//Suffix To Infix
//Given a suffix expression, convert it to infix one with the minimum number parentheses.
//
//The expression is represented by a string and each token is separated by ' '.
//
//Examples:
//
//"1 2 3 - +" is converted to "1 + 2 - 3", ("1 + ( 2 - 3 )" is not the correct answer since it has an extra parenthese).
//
//"1 2 3 * +" is converted to "1 + 2 * 3"
//
//"1 2 3 + *" is converted to "1 * ( 2 + 3 )"
public class Solution380 {

	  public String convert(String suffix) {
	    // Write your solution here.
	    return suffix;
	  }
	  
	  class RandomizedSet {

		    List<Integer> array;
		    Map<Integer, Integer> table;
		    /** Initialize your data structure here. */
		    public RandomizedSet() {
		        this.array = new ArrayList<>();
		        this.table = new HashMap<>();
		    }
		    
		    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
		    public boolean insert(int val) {
		        if(table.containsKey(val)) {
		            return false;
		        }
		        array.add(val);
		        table.put(val, array.size()-1);
		        return true;
		    }
		    
		    /** Removes a value from the set. Returns true if the set contained the specified element. */
		    public boolean remove(int val) {
		        if(table.containsKey(val)==false) {
		            return false;
		        } else if(table.get(val) == array.size()-1) {
		            array.remove(array.size()-1);
		            table.remove(val);
		        } else {
		            //replace target node to last node
		            int last = array.get(array.size()-1);
		            array.remove(array.size()-1);
		            array.set(table.get(val), last);
		            table.put(last, table.get(val));
		            table.remove(val);
		        }
		        return true;
		    }
		    
		    /** Get a random element from the set. */
		    public int getRandom() {
		        
		        int randomIndex = (int) (Math.random() * array.size());
		        return array.get(randomIndex);
		    }
		}
	public static void main(String[] args) {


	}
}
