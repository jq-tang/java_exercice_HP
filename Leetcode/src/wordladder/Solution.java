package wordladder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
	 public int ladderLength(String start, String end, Set<String> dict) {
	        if(start ==  end)
	            return 1;
	        if(!dict.contains(start))
	            return Integer.MAX_VALUE;
	        Queue<String> queue = new LinkedList<String>();
	        Queue<Integer> count = new LinkedList<Integer>();
	        queue.add(start);
	        count.add(1);
	        while(!queue.isEmpty()){
	            String s = queue.poll();
	            int cur = count.poll();
	            if(s.equals(end)){
	                return cur;
	            }
	            else{
	                for(int i = 0; i < s.length(); ++i){
	                    char[] s_array = s.toCharArray();
	                    for(char c = 'a'; c <= 'z'; ++c){
	                        if(c == s_array[i]){
	                            continue;
	                        }
	                        s_array[i] = c;
	                        String s_next = new String(s_array);
	                        if(dict.contains(s_next)){
	                            queue.add(s_next);
	                            count.add(++cur);
	                            dict.remove(s_next);
	                        }
	                    }
	                }
	            }
	        }
	        return 0;
	    }
	 public static void main(String[] args){
		 HashSet set = new HashSet();
		 set.add("a");
		 set.add("b");
		 set.add("c");
		 Solution s = new Solution();
		 System.out.println(s.ladderLength("a", "c", set));
	 }
}
