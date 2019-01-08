package laicode_java;
import java.util.*;
public class Solution847 {
    private int min = Integer.MAX_VALUE;
    public int shortestPathLength(int[][] graph) {
//	                 1
//	            0    2
//	                 3
          
//	             0   1
            
//	               2   4
//	               3
//	                 0 1 2 4 2 3
//	                 0 1 2 3 2 4
        // (cover | (1<<child), child)
        int n = graph.length;
        for(int i=0; i<n; i++) {
            Map<Integer, Integer> visited = new HashMap<>();
            List<Integer> path = new ArrayList<>();
            Stack<Integer> stk = new Stack<>();
            dfs(i, graph, visited, path, stk);
        }
        return min-1;
    }
    
    private void dfs(int i, int[][] graph, Map<Integer, Integer> visited, List<Integer> path, Stack<Integer> stk) {
    	path.add(i);
        visited.put(i, visited.getOrDefault(i, 0)+1);
        stk.push(i);
        if(visited.size()==graph.length) {
            min = Math.min(min, path.size());
	        visited.put(i, visited.get(i)-1);
	        if(visited.get(i)==0) {
	        	visited.remove(i);
	        }
            System.out.println(path);
            return;
        }
        boolean found = false;
        for(int j=0; j<graph[i].length; j++) {
            if(!visited.containsKey(graph[i][j]) && path.size()<min) {
                dfs(graph[i][j], graph, visited, path, stk);found = true;
            }
        }
        if(!found) {
        	stk.pop();
        	if(!stk.empty()) {
        		int next = stk.pop();
        		dfs(next, graph, visited, path, stk);
        	}
        }
        visited.put(i, visited.get(i)-1);
        if(visited.get(i)==0) {
        	visited.remove(i);
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution847 s = new Solution847();
		//int[][] graph = new int[][] {{1,2,3},{0},{0},{0}};
		int[][] graph = new int[][] {{2,3},{7},{0,6},{0,4,7},{3,8},{7},{2},{5,3,1},{4}};
		System.out.println(s.shortestPathLength(graph));
	}

}
