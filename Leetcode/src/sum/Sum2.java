package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Sum2 {
	public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        
        if(digits == null || digits.length() == 0)
            return result;
        HashMap<Integer,String> map = new HashMap<Integer, String>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        dfs(result, digits.length(), 0, new StringBuilder(), map, digits);
        return result;
    }
    public static void dfs(List<String> result, int len, int count, StringBuilder cur, HashMap<Integer, String> map, String digits){
        if(count == len){
            result.add(new String(cur));
            
            return;
        }
            int num = digits.charAt(count) - '0';
            String tmp = map.get(num);
            for(int j = 0; j < tmp.length(); j++){
                cur.append(tmp.charAt(j));
                dfs(result, len, count+1, cur, map, digits);
                cur.deleteCharAt(cur.length()-1);
            }
        }
        
   
	 public static void main(String[] args){
		 String str = "22";
		 List<String> res = Sum2.letterCombinations(str);
		 System.out.println(res);
	 }
}
