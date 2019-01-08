package laicode_java;

public class Solution803 {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(m*n+1);
        for(int[] hit:hits) {
            if(grid[hit[0]][hit[1]]==1) {
                grid[hit[0]][hit[1]]=2;
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==1) {
                    unionAround(i, j, grid, uf);
                }
            }
        }
        int count = uf.size[uf.find(0)];
        int[] res = new int[hits.length];
        for(int i=hits.length-1; i>=0; i--) {
            int[] hit = hits[i];
            if(grid[hit[0]][hit[1]]==2) {
                grid[hit[0]][hit[1]] = 1;
                unionAround(hit[0], hit[1], grid, uf);
                
            }
            int newsize = uf.size[uf.find(0)];
            res[i] = (newsize-count>0) ? newsize-count-1:0;
            count = newsize;
        }
        return res;
    }
    
    private void unionAround(int x, int y, int[][] grid, UnionFind uf) {
        int m = grid.length; int n = grid[0].length;
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};
        for(int i=0; i<4; i++) {
            int newx = x+dx[i];
            int newy = y+dy[i];
            if(newx < 0 || newx>=m || newy<0 || newy >=n) {
                continue;
            }
            if(grid[newx][newy]==1) {
                uf.union(x*n+y+1, newx*n+newy+1);
            }
        }
        if(x==0) {
            uf.union(x*n+y+1, 0);
        }
    }
    
    class UnionFind {
        int[] parent;
        int[] size;
        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for(int i=0; i<n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }
        
        public int find(int i) {
            while(parent[i]!=i) {
            	parent[i] = parent[parent[i]];
            	i = parent[i];
            }
            return parent[i];
        }
        
        public void union(int a, int b) {
            int roota = find(a);
            int rootb = find(b);
            if(roota != rootb) {
                parent[roota] = rootb;
                size[rootb] += size[roota]; 
            }
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = new int[][] {{1,0,0,0},{1,1,1,0}};
		int[][] hits = new int[][] {{1,0}};
		Solution803 ss = new Solution803();
		System.out.println(ss.hitBricks(grid, hits));
	}

}
