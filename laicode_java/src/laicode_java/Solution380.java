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
	
	
	public static void calcEquation1(String[][] relations, String[] values, String[] query) {
        // map string to integer
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> map1 = new HashMap<>();
        int len = 0;
        for (String[] names : relations)
            for (String name : names) {
                if (!map.containsKey(name)) map.put(name, len);
                if (!map1.containsKey(len)) map1.put(len, name);
                len++;
            }

        // init parent index and value,
        Node[] nodes = new Node[len];
        for (int i = 0; i < len; i++) nodes[i] = new Node(i);

        // union, you can take an example as follows
        for (int i = 0; i < relations.length; ++i) {
            String[] keys = relations[i];
            int k1 = map.get(keys[0]);
            int k2 = map.get(keys[1]);
            int groupHead1 = find(nodes, k1);
            int groupHead2 = find(nodes, k2);
            nodes[groupHead2].parent = groupHead1;
            if(nodes[groupHead2].value.size()==0) {
            	nodes[groupHead2].value.put(groupHead1, values[i]);
            } else {
            	nodes[groupHead2].value.put(groupHead1, nodes[groupHead2].value.get(groupHead1)+ values[i]);
            }
            
        }

        // query now
        Integer k1 = map.get(query[0]);
        Integer k2 = map.get(query[1]);
        if (k1 == null || k2 == null) {
        	System.out.println("N/A");
        }
        else {
            int groupHead1 = find(nodes, k1);
            int groupHead2 = find(nodes, k2);
            if (groupHead1 != groupHead2) {
            	System.out.println("N/A");
            } else {
            	System.out.println(nodes[k2].value);
            }
        }
    }

    public static int find(Node[] nodes, int k) {
        int p = k;
        while (nodes[p].parent != p) {
            p = nodes[p].parent;
        }
        // compress
        nodes[k].parent = p;
        return p;
    }
    

    private static class Node {
        int    parent;
        Map<Integer, String> value;

        public Node(int index) {
            this.parent = index;
            this.value = new HashMap<>();
        }
    }
 
	public static void main(String[] args) {
		String[][] names = {{"Bart", "Homer"},
					{ "Bart", "Lisa"},
					{"Marge",  "Homer"},
					{"Lisa",  "Homer" }};  
		String[]  relations = {"son",  "brother", "wife", "daughter"};
		
		calcEquation1(names, relations, new String[]{"Bart", "Homer"});
	}
}
