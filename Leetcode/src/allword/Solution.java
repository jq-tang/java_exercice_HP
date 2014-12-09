package allword;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Solution {
	public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        if(L == null || L.length == 0) {
            return result;
        }
        HashMap<String, Integer> needtofind = new HashMap<String, Integer>();
        
        for(String str : L){
            if(needtofind.containsKey(str)) {
                needtofind.put(str, needtofind.get(str)+1);
            }
            else {
                needtofind.put(str, 1);
            }
        }
        int count = 0, step = L[0].length();
        for(int i = 0; i < step; ++i) {
            HashMap<String, Integer> hasfound = new HashMap<String, Integer>();
            int start = i;
            for(int j = i; j <= S.length() - step; j += step) {
                String str = S.substring(j, j + step);
                if(needtofind.containsKey(str)) {
                    if(hasfound.containsKey(str)) {
                        hasfound.put(str, hasfound.get(str)+1);
                        if(hasfound.get(str) <= needtofind.get(str)) {
                            count ++;
                        }
                    }
                    else{
                        hasfound.put(str, 1);
                        count++;
                    }
                    if(count >= L.length) {
                        String left = S.substring(start, start+step);
                        while(hasfound.get(left) > needtofind.get(left)) {
                            hasfound.put(left, hasfound.get(left)-1);
                            start += step;
                            left = S.substring(start, start + step);
                        }
                    }
                    if(count == L.length) {
                        result.add(start);
                        String key = S.substring(start, start + step);
                        hasfound.put(key, hasfound.get(key)-1);
                        start += step;
                        count--;
                    }
                }
                else {
                    start = j + step;
                    hasfound.clear();
                    count = 0;
                }
            }
            
        }
        return result;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] L = {"foo","bar"};
		s.findSubstring("barfoothefoobarman", L);
	}
}
