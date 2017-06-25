package laicode_java;
import java.util.*;

//Most points on a line
public class Solution126 {
	public int most(Point[] points) {
		int result=0;
		for(int i=0;i<points.length;i++) {
			Point seed=points[i];
			int same=1;
			int sameX=0;
			int most=0;
			HashMap<Double, Integer> dict=new HashMap<Double, Integer>();
			for(int j=0;j<points.length;j++) {
				if(i==j) {
					continue;
				}
				Point temp=points[j];
				if(temp.x==seed.x && temp.y==seed.y) {
					same++;
				}
				else if(temp.x==seed.x) {
					sameX++;
				}
				else {
					double slope=(temp.y-seed.y+0.0)/(temp.x-seed.x+0.0);
					if(!dict.containsKey(slope)) {
						dict.put(slope, 1);
					}
					else {
						dict.put(slope, dict.get(slope)+1);
					}
					most=Math.max(most,  dict.get(slope));
				}
			}
			most=Math.max(most,  sameX)+same;
			result=Math.max(most, result);
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		Solution126 s126=new Solution126();
		Point p1=new Point(0,0);
		Point p2=new Point(1,1);
		Point p3=new Point(2,3);
		Point p4=new Point(3,3);
		Point[] array=new Point[]{p1,p2,p3,p4};
		int result=s126.most(array);
		System.out.println(result);
	}
}

class Point {
	public int x;
	public int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}