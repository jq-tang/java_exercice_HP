package wordbreak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	 	public List<String> wordBreak(String s, Set<String> dict) {
	        List<String> result = new ArrayList<String>();
	        if(s == null || s.length() == 0){
	            return result;
	        }
	        return helper(s, dict, new StringBuilder(), 0, result);
	    }
	    
	    public List<String> helper(String s, Set<String> dict, StringBuilder sb, int index, List<String> result){
	        if(index == s.length()){
	            result.add(sb.toString());
	        }
	        for(int i = index+1; i <= s.length() && !dict.isEmpty(); ++i){
	            String tmp = s.substring(index, i);
	            if(dict.contains(tmp)){
	                sb.append(" ");
	                sb.append(tmp);
	                dict.remove(tmp);
	                helper(s, dict, sb, i, result);
	                dict.add(tmp);
	            }
	        }
	        return result;
	    }
	    public static void main(String[] args){
	    	String s = "leetcode";
	    	Set<String> dict = new HashSet<String>();
	    	dict.add("leet");
	    	dict.add("code");
	    	
	    	Solution sol = new Solution();
	    	sol.wordBreak(s, dict);
	    }
}
