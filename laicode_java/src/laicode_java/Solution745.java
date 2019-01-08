package laicode_java;

public class Solution745 {

    class TrieNode {
        String str;
        TrieNode[] links;
        public TrieNode(String s) {
            this.str = s;
            this.links = new TrieNode[26];
        }
    }
    TrieNode root;
    
    public Solution745(String[] words) {
        root = new TrieNode("");
        for(int i=0; i<words.length; i++) {
            TrieNode cur = root;
            char[] arr = words[i].toCharArray();
            for(int j=0; j<arr.length; j++) {
                if(cur.links[arr[j]-'a'] == null) {
                    cur.links[arr[j]-'a'] = new TrieNode("");
                }
                cur = cur.links[arr[j]-'a'];
            }
            cur.str = words[i];
        }
    }
    
    public int f(String prefix, String suffix) {
        TrieNode start = helper(prefix);
        if(start==null) {
            return -1;
        }
        int[] res = new int[1];
        StringBuilder sf = new StringBuilder(suffix);
        helper1(start, sf.reverse(), res);
        return res[0];
    }
    
    public TrieNode helper(String s) {
        TrieNode cur = root;
        char[] arr = s.toCharArray();
        for(int j=0; j<arr.length; j++) {
            if(cur.links[arr[j]-'a'] == null) {
                return null;
            }
            cur = cur.links[arr[j]-'a'];
        }
        return cur;
    }
    
    
    public void helper1(TrieNode root, StringBuilder sf, int[] res) {
        if(res[0]==1) {
            return;
        }
        if(root.str!=null) {
            StringBuilder sb = new StringBuilder(root.str);
            if(sb.length()>=sf.length()) {
                int index = sb.reverse().indexOf(sf.toString());
                if(index==0) {
                    res[0] = 1;
                    return;
                }
            }
        }
        for(int i=0; i<26; i++) {
            helper1(root.links[i], sf, res);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = new String[] {"apple"};
		Solution745 ss = new Solution745(s);
		ss.f("a", "e");
	}

}
