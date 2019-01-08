package laicode_java;
import java.io.*;
import java.util.*;

public class Solution520 {
	public static long kSub(int k, List<Integer> nums) {
	    // Write your code here
        int sum[] = new int[nums.size()];
        long count = 0;
        sum[0] = nums.get(0);

        // 1 2 3 4 1
        // 1 3 6 10 11
        // 
        for (int i = 1; i < nums.size(); i++) {
            sum[i] = sum[i - 1] + nums.get(i);
        }
        int kVals[] = new int[k];
        // 0 1 2
        for (int i = 0; i < sum.length; i++) {
            int mod = sum[i] % k;
            count += kVals[mod];
            kVals[mod]++;
            if (mod == 0) {
                count++;
            }

        }
        return count;
    }
	
	public class Vertex {
	    public int val;
	    public List childNodes;
	    
	}
	
	
	
	private final static int start = 12;
	public static void main(String[] args) {
		List<Integer> result = new ArrayList<>();
		result.add(1);
		result.add(2);
		result.add(3);
		result.add(4);
		result.add(1);
		kSub(3, result);
		
		// TODO Auto-generated method stub
		String csvFile = "/Users/fshen/Downloads/depth.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = "\t";
        int[] range = new int[] {20427,20172,19917,19662,19407,19152,18897,18617,18337,18057,17777,17497,17217,16937,16632,16327,16022,15717,15412,15107,14802,14497,14192,13887,13582,13277,12972,12667,12362};
        int[] counts = new int[] {2,10,10,10,10,10,10,11,11,11,11,11,11,11,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12};
//        int[] range = new int[] {20427,20172};
//        int[] counts = new int[] {2, 10, 10};
        int maxDepth = Integer.MIN_VALUE;
        int minDepth = Integer.MAX_VALUE;
        Map<Integer, Integer> dict = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use tab as separator
                String[] depth = line.split(cvsSplitBy);
                dict.put(Integer.valueOf(depth[0]), Integer.valueOf(depth[1]));
                // System.out.println(dict.get(Integer.valueOf(depth[0])));
                maxDepth = Math.max(maxDepth, Integer.valueOf(depth[0]));
                minDepth = Math.min(minDepth, Integer.valueOf(depth[0]));
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        for(int i=-1; i<range.length; i++) {
        	int left, right;
        	if(i==-1) {
        		left = range[0]; right = maxDepth;
        	} else if(i==range.length-1) {
        		right = range[i]; left = minDepth;
        	} else {
        		right = range[i]; left = range[i+1];
        	}
        	findSolution(true, i+1, counts, left, right, 60, dict);
        }
	}
	
	static List<Integer> findSolution(boolean mixed, int index, int[] counts, int x, int y, int max, Map<Integer, Integer> dict) {
		List<Integer> result = new ArrayList<>();
		int maxLength = 0;
		int color = 1;
		int length[] = new int[y];
		int depth[] = new int[y];
		for(int i=1; i<=8; i++) {
			int tmplength[] = new int[y];
			int tmpdepth[] = new int[y];
			int currLength = Integer.MIN_VALUE;
			for(int j=x+start; j<y; j++) {
				if(dict.containsKey(j) && dict.get(j)==i) {
					for(int k=max; k>=max/2; k--) {
						if(tmplength[j-k]+1 >= tmplength[j]) {
							tmplength[j] = tmplength[j-k]+1;
							tmpdepth[j] = j-k;
						}
					}
				} else {
					if(mixed) {
						tmplength[j] = tmplength[j-1];
						tmpdepth[j] = tmpdepth[j-1];
					}
				}
				currLength = tmplength[j];
			}
			if(currLength>=counts[index]) {
				maxLength = currLength;
				color = i;
				length = tmplength.clone();
				depth = tmpdepth.clone();
				break;
			}
		}
		
		if(maxLength>counts[index]) {
			int m;
			System.out.println("Starting print solution " + x + " " + y + " " + maxLength + " " + color);
			Set<String> outputs = new HashSet<>();
			for(m=y-1; m>=x+start; m--) {
				if(length[m]==maxLength) {
					int n = m;
					String combo = "";
					int needs = counts[index];
					while(depth[n]>0 && needs>0) {
						combo += String.valueOf(depth[n]) + "\t";
						n = depth[n];
						needs--;
					}
					if(!outputs.contains(combo)) {
						outputs.add(combo);
						System.out.println(combo);
					}
				}
			}
			return result;
		} else {
			return findSolution(mixed, index, counts, x, y, max-1, dict);
		}
	}
	
}
