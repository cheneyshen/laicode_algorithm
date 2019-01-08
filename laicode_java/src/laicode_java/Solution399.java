package laicode_java;

import java.util.*;

//Rainbow Sort II
//Given an array of balls, where the color of the balls can only be Red, Green, Blue or Black, sort the balls such that all balls with same color are grouped together and from left to right the order is Red->Green->Blue->Black. (Red is denoted by 0, Green is denoted by 1,  Blue is denoted by 2 and Black is denoted by 3).
//
//Examples
//
//{0} is sorted to {0}
//{1, 0} is sorted to {0, 1}
//{1, 3, 1, 2, 0} is sorted to {0, 1, 1, 2, 3}
//Assumptions
//
//The input array is not null.
public class Solution399 {

	/*
	# Suppose we have a series of people relationships that looks something like this:
	#        [   
	#            ['Bart',  'son',      'Homer'    ],
	             ['Bart',  'brother',   'Lisa'    ],
	#            ['Marge', 'wife',     'Homer'    ],
	#            ['Lisa',  'daughter', 'Homer'   ]    ]
	#
	# Given a series of relationships as a list of lists, and given two names, return
	# all known "sequences" of relationships from name1 to name2
	# 
	# e.g. with the lists above as input, with input names 'Bart' and 'Homer', you should return:
	#    ['Bart son Homer', 'Bart brother Lisa daughter Homer']
	#*/

//	List<String> get1(List<List<String>> relations, String start, String end) {
//	    Set<String> visited = HashSet<>();
//	    Map<String, List<List<String>>> map = new HashMap<>();
//	    for(int i=0; i<relations.size(); i++) {
//	        if(map.containsKey(relations.get(0)) == false) {
//	            map.put(relations.get(0), new ArrayList<>());
//	        }
//	        map.get(relations.get(0)).add(new ArrayList<>({relations.get(1), relations.get(2)}));
//	        if(relations.get(i).get(0).equals(start) {
//	            que.add(new Pair(list.get(0),list.get(1),list.get(2), ""));
//	        }
//	    }
//	    List<String> output;
//	    while(!que.isEmpty()) {
//	        Pair cur = que.poll(); // bart son, homer
//	        visited.add(curr.a+curr.b+curr.c);
//	        if(curr.c.equals(end)) {
//	            output.add(curr.str + curr.b + curr.c);
//	        } else {
//	            List<List<String>> combo = map.get(curr.c);
//	            if(combo.size()>0) {
//	                for(int j=0; j<combo.size(); j++) {
//	                   String str1 = curr.c + combo.get(j).get(0) + combo.get(j).get(1);
//	                    
//	                    if(visited.contains(str1)==false) {
//	                            Pair tmp = new Pair(cur.c, combo.get(j).get(0), combo.get(j).get(1), cur.str+combo.get(j).get(0) + combo.get(j).get(1));
//	                            que.offer(tmp);
//	                    }
//	                }
//	            }
//	        }
//	    }
//	    return output;
//	}
//	List<String> getAnswer(List<List<String>> relations, String start, String end) {
//	    List<String> result = new ArrayList<>();
//	    for(int i=0; i<relations.size(); i++) {
//	        if(relations.get(i).get(0).equals(start)) {
//	            Set<Integer> visited = new HashSet<>();
//	            helper(start, relations, end, i, "", visited, result);
//	        }
//	    }
//	    return result;
//	}
//
//
//	// Time come n + (n-1) + (n-2)  ...1 = (1+n) *n/2 =  n^2   
//	// Space O(n)
//	void helper(String start, List<List<String>> relations, String end, int i, String curr, Set<Integer> visited, List<String> result) {
//	    if(relations.get(i).get(2).equals(end)) {  //i = 3, Homer 
//	        resuslt.add(curr+ relations.get(i).get(1) + relations.get(i).get(2));  // Bart son Homer 
//	        // Bart brother Lisa +  daughter + Homer
//	        return;
//	    }
//	    curr+=relations.get(i).get(0) + relations.get(i).get(1) + relations.get(i).get(2); //  Bart brother Lisa
//	    visited.add(i);  // 1
//	    for(int j=0; j<relations.size(); j++) {
//	        if(visited.contains(j)==false) {
//	            if(relations.get(j).get(0).equals(relations.get(i).get(2))) {  // j = 3, 
//	                helper(relations.get(i).get(2), relations, end, j, curr, visited, result); // 
//	                
//	            }
//	            
//	        }
//	        
//	    }
//	    
//	}


	public static double[] calcEquation(String[][] equations, double[] values, String[][] query) {

        // map string to integer
        Map<String, Integer> map = new HashMap<>();
        int len = 0;
        for (String[] words : equations)
            for (String word : words)
                if (!map.containsKey(word)) map.put(word, len++);

        // init parent index and value
        Node[] nodes = new Node[len];
        for (int i = 0; i < len; ++i) nodes[i] = new Node(i);

        // union, you can take an example as follows
        // (a/b=2)->(b/c=3)->(c/d=5)->(a/d=30)
        for (int i = 0; i < equations.length; ++i) {
            String[] keys = equations[i];
            int k1 = map.get(keys[0]);
            int k2 = map.get(keys[1]);
            int groupHead1 = find(nodes, k1);
            int groupHead2 = find(nodes, k2);
            nodes[groupHead2].parent = groupHead1;
            nodes[groupHead2].value = nodes[k1].value * values[i] / nodes[k2].value;
        }

        // query now
        double[] result = new double[query.length];
        for (int i = 0; i < query.length; ++i) {
            Integer k1 = map.get(query[i][0]);
            Integer k2 = map.get(query[i][1]);
            if (k1 == null || k2 == null) result[i] = -1d;
            else {
                int groupHead1 = find(nodes, k1);
                int groupHead2 = find(nodes, k2);
                if (groupHead1 != groupHead2) result[i] = -1d;
                else result[i] = nodes[k2].value / nodes[k1].value;
            }
        }
        return result;
    }

    public static int find(Node[] nodes, int k) {
        int p = k;
        while (nodes[p].parent != p) {
            p = nodes[p].parent;
            // compress
            nodes[k].value *= nodes[p].value;
        }
        // compress
        nodes[k].parent = p;
        return p;
    }
    
    

    private static class Node {
        int    parent;
        double value;

        public Node(int index) {
            this.parent = index;
            this.value = 1d;
        }
    }
    
   String find(Map<String, String> parent, String f) {
	   if(parent.get(f)!=f) {
		   parent.put(f, find(parent, parent.get(f)));
	   }
	   return f;
   }
   
	public static void main(String[] args) {
		String[][] equations = {{"a","b"}, {"b", "c"},  {"c", "d"}};
		double[] values = {2.0, 3.0, 5.0};
		String[][] query = {{"a","d"}, {"b","c"}};
		System.out.println(Arrays.toString(calcEquation(equations, values, query)));
		
		
	}
}
