package laicode_java;

import java.util.*;

//Bipartite
//Determine if an undirected graph is bipartite. A bipartite graph is one in which the nodes can be divided into two groups such that no nodes have direct edges to other nodes in the same group.
//  
//  Examples
//  
//  1  --   2
//  
//  /
//  
//  3  --   4
//  
//  is bipartite (1, 3 in group 1 and 2, 4 in group 2).
//  
//  1  --   2
//  
//  /   |
//  
//  3  --   4
//  
//  is not bipartite.

public class Solution056 {
	class GraphNode {
		public int key;
		public List<GraphNode> neighbors;
		public GraphNode(int key) {
			this.key = key;
			this.neighbors = new ArrayList<GraphNode>();
		}
	}
	boolean isBipartite(List<GraphNode> graph) {
		if(graph.isEmpty()) {
			return false;
		}
		HashMap<GraphNode, Integer> visited=new HashMap<GraphNode, Integer>();
		for(GraphNode node:graph) {
			if(!BFS(node, visited)) {
				return false;
			}
		}
		return true;
	}
	
	boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited) {
		if(visited.containsKey(node)) {
			return true;
		}
		Queue<GraphNode> queue=new LinkedList<GraphNode>();
		queue.offer(node);
		visited.put(node, 1);
		while(!queue.isEmpty()) {
			int size=queue.size();
			for(int i=0; i<size; i++) {
				GraphNode curr=queue.poll();
				for(GraphNode nei:curr.neighbors) {
					if(!visited.containsKey(nei)) {
						visited.put(nei, 1-visited.get(curr));
						queue.add(nei);
					}
					else if(visited.get(nei)==visited.get(curr)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {


	}
}
