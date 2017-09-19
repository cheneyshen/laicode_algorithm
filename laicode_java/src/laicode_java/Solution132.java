package laicode_java;

import java.util.*;

//    Deep Copy Undirected Graph
//    Make a deep copy of an undirected graph, there could be cycles in the original graph.
//
//    Assumptions
//
//    The given graph is not null
public class Solution132 {
	class GraphNode {
		public int key;
		public List<GraphNode> neighbors;
		public GraphNode(int key) {
			this.key = key;
		}
	}
	
	public List<GraphNode> copy(List<GraphNode> graph) {
		if(graph==null) {
			return null;
		}
		HashMap<GraphNode, GraphNode> dict = new HashMap<>();
		for(GraphNode node : graph) {
			if(!dict.containsKey(node)) {
				dict.put(node, new GraphNode(node.key));
				DFS(node, dict);
			}
		}
		return new ArrayList<GraphNode>(dict.values());
	}
	
	private void DFS(GraphNode seed, HashMap<GraphNode, GraphNode> map) {
		GraphNode copy = map.get(seed);
		for(GraphNode nei : seed.neighbors) {
			if(!map.containsKey(nei)) {
				map.put(nei, new GraphNode(nei.key));
				DFS(nei, map);
			}
			copy.neighbors.add(map.get(nei));
		}
	}
	
	public static void main(String[] args) {


	}
}
