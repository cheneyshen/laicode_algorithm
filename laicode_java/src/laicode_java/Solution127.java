package laicode_java;
import java.util.*;

//largest set of points with positive slopes
public class Solution127 {
	public int largest(Point[] points) {
		Arrays.sort(points, new MyComparator());
		int result=0;
		int[] longest=new int[points.length];
		for(int i=0;i<longest.length;i++) {
			for(int j=0;j<i;j++) {
				if(points[j].x<points[i].x && points[j].y<points[i].y) {
					longest[i]=Math.max(longest[i], longest[j]);
				}
			}
			longest[i]++;
			result=Math.max(result, longest[i]);
		}
		return result==1?0:result;
	}
	
	static class MyComparator implements Comparator<Point> {
		@Override
		public int compare(Point p1, Point p2) {
			if(p1.y<p2.y) {
				return -1;
			}
			else if(p1.y>p2.y) {
				return 1;
			}
			else if(p1.x<p2.x) {
				return -1;
			}
			else if(p1.x>p2.x) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Solution127 s127 = new Solution127();
		Point p1=new Point(0,0);
		Point p2=new Point(1,1);
		Point p3=new Point(2,3);
		Point p4=new Point(3,3);
		Point[] array=new Point[]{p1,p2,p3,p4};
		int result=s127.largest(array);
		System.out.println(result);
	}
}