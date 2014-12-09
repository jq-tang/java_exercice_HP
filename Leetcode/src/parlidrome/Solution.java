package parlidrome;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(s == null || s.length() == 0)
            return result;
        ArrayList<String> cur = new ArrayList<String>();
        helper(s, cur, result);
        return result;
            
    }
    public static boolean isPalindrome(String s){
        int len = s.length();
        for(int i = 0; i < len/2; ++i){
            if(s.charAt(i) != s.charAt(len-1-i))
                return false;
        }
        return true;
    }
    public static void helper(String s, ArrayList<String> cur, List<List<String>> result){
        int len = s.length();
        if(len == 0)
            result.add(new ArrayList<String>(cur));
      
        for(int i = 1; i <= len; ++i){
            String sub = s.substring(0, i);
            if(isPalindrome(sub)){
                cur.add(sub);
                helper(s.substring(i), cur, result);
                cur.remove(cur.size()-1);
            }
        }
    }
    public static void main(String[] args){
    	String a = "a";
    	System.out.println(Solution.partition(a));
    }
}
