package laicode_java;
import java.io.*;
import java.util.*;	

public class Solution904 {
    public static int totalFruit(int[] tree) {
        int result = 0;
        int start = 0;
        Map<Integer, Integer> set = new HashMap<>();
        for(int i=0; i<tree.length; i++) {
            if(set.containsKey(tree[i])) {
            	set.put(tree[i], i);
                result = Math.max(result, i-start+1);
            } else {
                if(set.size()<2) {
                    set.put(tree[i], i);
                    result = Math.max(result, i-start+1);
                } else {
                	int pos = set.get(tree[start]);
                    set.remove(tree[start]);
                    start = pos+1;
                    set.put(tree[i], i);
                    result = Math.max(result, i-start+1);
                }
            }
        }
        return result;
    }
    
    class Edge {
    	Node node;
    	int cost;
    	public Edge(Node node, int cost) {
    		this.node = node;
    		this.cost = cost;
    	}
    }
    
    class Node {
    	List<Edge> edges;
    	public Node() {
    		this.edges = new ArrayList<>();
    	}
    }
    
    public class Root_To_Leaf_Min_Cost {
    	int minCost = Integer.MAX_VALUE;
    	public List<Edge> getMinPath(Node root) {
    		List<Edge> res = new ArrayList<>();
    		List<Edge> tmp = new ArrayList<>();
    		dfs(res, tmp, root, 0);
    		return res;
    	}
    	
    	public void dfs(List<Edge> res, List<Edge> tmp, Node root, int cur) {
    		if(root==null) {
    			return;
    		}
    		if(root.edges.size()==0) {
    			if(cur < minCost) {
    				minCost = cur;
    				res.clear();
    				res.addAll(tmp);
    				return;
    			}
    		}
    		for(Edge e : root.edges) {
    			Node next = e.node;
    			tmp.add(e);
    			dfs(res, tmp, next, cur+e.cost);
    			tmp.remove(tmp.size()-1);
    		}
    	}
    	
    	public int getMinCost(Node root) {
    		if(root==null) {
    			return 0;
    		}
    		helper(root, 0);
    		return minCost;
    	}
    	
    	public void helper(Node root, int cur) {
    		if(root.edges.size()==0) {
    			minCost = Math.min(minCost, cur);
    		}
    		for(Edge e : root.edges) {
    			Node next = e.node;
    			helper(next, cur+e.cost);
    		}
    	}
    }
    
    public List<Edge> getMinPathInGraph(Node root) {
    	int minCost = Integer.MAX_VALUE;
    	Node resNode = null;
    	List<Edge> res = new ArrayList<>();
    	Map<Node, Integer> dist = new HashMap<>();
    	Map<Node, Node> findPar = new HashMap<>();
    	PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return dist.get(o1) - dist.get(o2);
			}
    	});
    	dist.put(root, 0);
    	findPar.put(root, null);
    	pq.offer(root);
    	while(!pq.isEmpty()) {
    		Node cur = pq.poll();
    		int d = dist.get(cur);
    		if(cur.edges.size()==0) {
    			int curCost = dist.get(cur);
    			if(curCost < minCost) {
    				minCost = curCost;
    				resNode = cur;
    			}
    		}
    		for(Edge e : cur.edges) {
    			Node next = e.node;
    			int tmp = e.cost+d;
    			if(!dist.containsKey(next)) {
    				dist.put(next, tmp);
    				findPar.put(next, cur);
    				pq.offer(next);
    			} else {
    				if(tmp<dist.get(next)) {
    					pq.remove(next);
    					dist.put(next, tmp);
    					findPar.put(next, cur);
    					pq.offer(next);
    				}
    			}
    		}
    	}
    	
    	List<Node> tmpList = new ArrayList<>();
    	while(resNode!=null) {
    		tmpList.add(0, resNode);
    		resNode = findPar.get(resNode);
    	}
    	for(int i=0; i<tmpList.size()-1; i++) {
    		Node cur = tmpList.get(i);
    		for(Edge e:cur.edges) {
    			if(e.node.equals(tmpList.get(i+1))) {
    				res.add(e);
    			}
    		}
    	}
    	return res;
    }
    
    public class ExpiringMap<K> {
    	Map<K, Data> map = new HashMap<>();
    	
    	public void put(K key, int value, long duration) {
    		long startTime = System.currentTimeMillis();
    		Data data = new Data(value, startTime, duration);
    		map.put(key, data);
    	}
    	
    	public Data get(K key) {
    		Data data = map.get(key);
    		if(data == null) {
    			return null;
    		}
    		if(data.isExpired()) {
    			map.remove(key);
    			return null;
    		}
    		return data;
    	}
    	
    	public void check() {
    		checkThread ct = new checkThread();
    		ct.run();
    	}
    	
    	class checkThread implements Runnable {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Map<K, Data> temp = new HashMap<>(map);
				for(K key : temp.keySet()) {
					if(temp.get(key).isExpired()) {
						map.remove(key);
					}
				}
			}
    	}
    }
    
    class Data {
    	int value;
    	long startTime;
    	long duration;
    	public Data(int value, long startTime, long duration) {
    		this.value = value;
    		this.startTime = startTime;
    		this.duration = duration;
    	}
    	
    	public boolean isExpired() {
    		if(startTime + duration > System.currentTimeMillis()) {
    			return false;
    		}
    		return true;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(totalFruit(new int[] {1,0,1,4,1,4,1,2,3}));
//		System.out.println(totalFruit(new int[] {3,3}));
//		System.out.println(totalFruit(new int[] {3,3,3}));
//		System.out.println(totalFruit(new int[] {3,3,3,1}));
//		System.out.println(totalFruit(new int[] {3,3,3,1,2}));
//		System.out.println(totalFruit(new int[] {3,3,3,1,2,1}));
//		System.out.println(totalFruit(new int[] {3,3,3,1,2,1,1}));
//		System.out.println(totalFruit(new int[] {3,3,3,1,2,1,1,2}));
//		System.out.println(totalFruit(new int[] {3,3,3,1,2,1,1,2,3}));
//		System.out.println(totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3}));
	}

}
