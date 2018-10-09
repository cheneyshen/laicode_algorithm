package laicode_java;

import java.util.*;

/*
 * Amazon
 */
public class Solution505 {
	public int logfileSort(List<String> files) {
		Collections.sort(files, new Comparator<String>() {
			public int compare(String s1, String s2) {
				String[] s11 = s1.split("\\s");
				String[] s22 = s2.split("\\s");
				char[] ch1 = s11[1].toCharArray();
				char[] ch2 = s22[1].toCharArray();
				int min = Math.min(ch1.length, ch2.length);
				for(int i=0; i<min; i++) {
					if(Character.isDigit(ch1[i]) && Character.isAlphabetic(ch2[i])) {
						return 1;
					} else if(Character.isDigit(ch2[i]) && Character.isAlphabetic(ch1[i])) {
						return -1;
					} else if(ch1[i] == ch2[i]) {
						continue;
					} else if(ch1[i] < ch2[i]) {
						return -1;
					} else {
						return 1;
					}
					
				}
				return 0;
			}
		});
		return 0;
	}
	
	List<String> substringK(String str, int k) {
		List<String> result = new ArrayList<>();
		Map<Character, Integer> vmap = new HashMap<>();
		for(int i=0; i<k;i++) {
			vmap.put(str.charAt(i), vmap.getOrDefault(str.charAt(i), 0)+1);
		}
		int start = 0;
		do {
			if(vmap.size() == k) {
				result.add(str.substring(start, k));
			}
			if (start == str.length() - k) break;
			vmap.put(str.charAt(start), vmap.getOrDefault(str.charAt(start), 0) - 1);
			if(vmap.get(str.charAt(start)) == 0) {
				vmap.remove(str.charAt(start));
			}
			vmap.put(str.charAt(k), vmap.getOrDefault(str.charAt(k), 0)+1);
			start++;
		} while(true);
		return result;
	}
	
	boolean notAphla(Character c) {
		return !(('a'<=c) && (c<='z'));
	}
	
	String mostCommonWord(String paragraph, List<String> banned) {
		paragraph = paragraph.toLowerCase();
		String[] words = paragraph.split("[ !?',;.]");
		Set<String> bannedWords = new HashSet<>();
		for(int i=0; i<banned.size(); i++) {
			bannedWords.add(banned.get(i).toLowerCase());
		}
		Map<String, Integer> wordCount = new HashMap<>();
		String word = null;
		String mostCommonWord = null;
		int maxCount = 0;
		for(int i=0; i<words.length; i++) {
			word = words[i];
			if(bannedWords.contains(word) || word.isEmpty()) {
				continue;
			}
			int count = wordCount.containsKey(word) ? wordCount.get(word) + 1 : 1;
			wordCount.put(word, count);
			if(count > maxCount) {
				maxCount = count;
				mostCommonWord = word;
			}
		}
		return mostCommonWord;
	}
	
	public static class Location {
		int x, y;
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static List<List<Integer>> findKNearest(int total, List<List<Integer>> locations, int k) {
		List<Location> locList = new ArrayList<>();
		for(List<Integer> location : locations) {
			locList.add(new Location(location.get(0), location.get(1)));
		}
		PriorityQueue<Location> pq = new PriorityQueue<>(k, new Comparator<Location>() {
			@Override
			public int compare(Location p1, Location p2) {
				int d1 = (p1.x*p1.x + p1.y*p1.y);
				int d2 = (p2.x*p2.x + p2.y*p2.y);
				return d2-d1;
			}
		});
		for(Location loc:locList) {
			pq.add(loc);
			if(pq.size()>k) {
				pq.poll();
			}
		}
		List<List<Integer>> result = new ArrayList<>();
		while(!pq.isEmpty()) {
			List<Integer> point = new ArrayList<>();
			Location loc = pq.poll();
			point.addAll(Arrays.asList(loc.x, loc.y));
			result.add(point);
		}
		return result;
	}
	
	public static class Pair {
		int fgId, bgId, req;
		public Pair(int fgId, int bgId, int req) {
			this.fgId = fgId;
			this.bgId = bgId;
			this.req = req;
		}
	}
	public static List<List<Integer>> optimalUtilization(int capacity, List<List<Integer>> foreground, List<List<Integer>> background) {
		List<List<Integer>> result = new ArrayList<>();
		List<Pair> pairs = new ArrayList<>();
		for(List<Integer> fg : foreground) {
			for(List<Integer> bg : background) {
				int fgId = fg.get(0), bgId = bg.get(0);
				int req = fg.get(1) + bg.get(1);
				pairs.add(new Pair(fgId, bgId, req));
			}
		}
		
		Collections.sort(pairs, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				if(p1.req < p2.req) return -1;
				else if(p1.req > p2.req) return 1;
				else return 0;
			}
		});
		
		int optimalMemory = 0;
		for(int i=pairs.size()-1; i>=0; i--) {
			Pair pair = pairs.get(i);
			if(pair.req <= capacity && optimalMemory == 0) {
				optimalMemory = pair.req;
				break;
			}
		}
		for(Pair pair : pairs) {
			if(pair.req == optimalMemory) {
				List<Integer> curr = new ArrayList<>();
				curr.addAll(Arrays.asList(pair.fgId, pair.bgId));
				result.add(curr);
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
