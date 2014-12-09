package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        int lens = s.length();
        int lenp = p.length();
        int i = 0, j = 0, star = -1;
        while(i < lens){
            if(j < lenp && s.charAt(i) == p.charAt(j) || s.charAt(j) == '?'){
                i++;
                j++;
            }
            else if(j < lenp && p.charAt(j) == '*'){
                star = j++;
            }
            else if(star != -1){
                i++;
                j = star + 1;
            }
            else{
                return false;
            }
        }
        while(j < lenp && p.charAt(j) == '*'){
            j++;
        }
        return j == lenp;
    }
 	public static void main(String[] args){
		Solution s = new Solution();
		String[] a = {"", ""};
        System.out.println(s.isMatch("aa", "*"));
	}
}
