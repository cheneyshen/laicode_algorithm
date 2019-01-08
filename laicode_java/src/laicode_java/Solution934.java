package laicode_java;
import java.util.*;

public class Solution934 {
    public int shortestBridge(int[][] A) {
        if(A==null || A.length<1 || A[0].length<1) {
            return 0;
        }
        int m = A.length, n = A[0].length;
        UnionFind uf = new UnionFind(m*n);
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(A[i][j] == 1) {
                    int cur = i*n + j;
                    List<Integer> neis = neighbors(A, i, j);
                    System.out.println(neis);
                    for(int nei:neis) {
                        int nr = nei / n, nc = nei % n;
                        if(A[nr][nc] == 1) {
                            uf.union(cur, nei);
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.asList(uf.map));
        System.out.println(uf.map.get(1));
        System.out.println(uf.map.get(2));
        return 1;
    }
    
    public List<Integer> neighbors(int[][] A, int r, int c) {
        int R = A.length, C = A[0].length;
        List<Integer> ans = new ArrayList();
        if (0 <= r-1) ans.add((r-1) * R + c);
        if (0 <= c-1) ans.add(r * R + (c-1));
        if (r+1 < R) ans.add((r+1) * R + c);
        if (c+1 < C) ans.add(r * R + (c+1));
        return ans;
    }
    
    class UnionFind {
        int[] parent;
        int[] rank;
        Map<Integer, List<Integer>> map;
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i=0; i<n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
            map = new HashMap<>();
        }
        
        public int find(int x) {
            if(parent[x]!=x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
             
            if(!map.containsKey(parent[rootx])) {
                map.put(parent[rootx], new ArrayList<>());
            }
            if(!map.containsKey(parent[rooty])) {
                map.put(parent[rooty], new ArrayList<>());
            }
            if(rootx != rooty) {
                if(rank[rootx]>rank[rooty]) {
                    parent[rooty] = rootx;
                    map.get(rootx).add(y);
                } else if(rank[rootx]<rank[rooty]) {
                    parent[rootx] = rooty;
                    map.get(rooty).add(x);
                } else {
                    parent[rootx] = rooty;
                    map.get(rooty).add(x);
                    rank[rooty]++;
                }
            }
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = new int[][] {{0,1},{1,0}};
		Solution934 s = new Solution934();
		s.shortestBridge(grid);
	}

}
