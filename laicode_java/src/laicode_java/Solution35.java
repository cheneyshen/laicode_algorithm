package laicode_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Bipartite
public class Solution35 {
	//����java�ļ�
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//����ĳһ��Ȼ���滻
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//���ĺ��Ƶ����ļ�
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//�������ͱ���Ҫ�á���˫����
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public boolean isBipartite(List<GraphNode> graph) {
		HashMap<GraphNode, Integer> visited=new HashMap<GraphNode, Integer>();
		for(GraphNode node : graph) {
			if(!BFS(node, visited)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited) {
		if(visited.containsKey(node)) {
			return true;
		}
		Queue<GraphNode> queue=new LinkedList<GraphNode>();
		queue.offer(node);
		visited.put(node, 0);
		while(!queue.isEmpty()) {
			GraphNode cur=queue.poll();
			int curGroup=visited.get(cur);
			int neiGroup=curGroup==0?1:0;
			for(GraphNode nei:cur.neighbors) {
				if(!visited.containsKey(nei)) {
					visited.put(nei, neiGroup);
					queue.offer(nei);
				}
				else if(visited.get(nei)!=neiGroup) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution35 s35 = new Solution35();
		GraphNode g1=new GraphNode(1);
		GraphNode g2=new GraphNode(2);
		GraphNode g3=new GraphNode(3);
		GraphNode g4=new GraphNode(4);
		g1.neighbors.add(g2);
		g2.neighbors.add(g3);
		g2.neighbors.add(g1);
		g3.neighbors.add(g4);
		g3.neighbors.add(g2);
		List<GraphNode> list=new ArrayList<GraphNode>();
		list.add(g1);
		list.add(g2);
		list.add(g3);
		list.add(g4);
		boolean result=s35.isBipartite(list);
		System.out.println(result);
		return;
	}
}