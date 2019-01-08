package laicode_java;
import java.util.*;

public class Solution857 {
	    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
//	         50 70 30
//	         20 10  5
//	         2.5 7  6  
//	          2  2   4  8  7
//	         10 10   3  1  1
//	        0.2 0.2 1.3 8  7
//	          1.3 4 4*3.3  4
//	        10 10 3 * 1.333
//	        3 10 10
	        int N = quality.length;
	        Worker[] workers = new Worker[N];
	        for(int i=0; i<N; i++) {
	            workers[i] = new Worker(quality[i], wage[i]);
	        }
	        Arrays.sort(workers);
	        
	        double ans = 1e9;
	        int sumq = 0;
	        Queue<Integer> que = new PriorityQueue<>();
	        for(Worker worker:workers) {
	            que.offer(-worker.quality);
	            sumq += worker.quality;
	            if(que.size()>K) {
	                sumq += que.poll();
	            }
	            if(que.size()==K) {
	                ans = Math.min(ans, sumq*worker.ratio());
	            }
	        }
	        return ans;
	    }
	    
	    class Worker implements Comparable<Worker> {
	        public int quality, wage;
	        public Worker(int q, int w) {
	            quality = q;
	            wage = w;
	        }
	        public double ratio () {
	            return (double) wage/quality;
	        }
	        public int compareTo(Worker other) {
	            return Double.compare(ratio(), other.ratio());
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution857 s = new Solution857();
		int[] quality = new int[] {3,1,10,10,1};
		int[] wage = new int[] {4,8,2,2,7};
		s.mincostToHireWorkers(quality, wage, 3);
	}

}
