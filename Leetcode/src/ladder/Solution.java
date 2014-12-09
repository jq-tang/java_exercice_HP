package ladder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
	class wordNode{
        String s;
        int sequence;
        wordNode(String str, int count){
            s = str;
            sequence = count;
        }
    }
    public int ladderLength(String start, String end, Set<String> dict) {
        if(!dict.contains(start) || !dict.contains(end)){
            return Integer.MAX_VALUE;
        }
        Queue<wordNode> queue = new LinkedList<wordNode>();
        queue.add(new wordNode(start, 1));
        while(!queue.isEmpty()){
            wordNode node = queue.poll();
            String str = node.s;
            if(str.equals(end)){
                return node.sequence;
            }
            else{
                for(int i = 0; i < str.length(); ++i){
                char[] word = str.toCharArray();
                for(char c = 'a'; c <= 'z'; ++c){
                    if(word[i] == c){
                        continue;
                    }
                    word[i] = c;
                    String tmp = word.toString();
                    if(dict.contains(tmp)){
                        queue.add(new wordNode(tmp, node.sequence+1));
                        dict.remove(tmp);
                    }
                }
                }
            }
        }
        return -1;
    }
    
    public int divide(int dividend, int divisor) {
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }
        if(dividend == 0){
            return 0;
        }
        int result = 0;
        boolean minus = false;
        if(dividend == Integer.MIN_VALUE){
            result ++;
            dividend += Math.abs(divisor);
        }
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ){
            minus = true;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int digit = 0;
        while((dividend >> digit) > divisor){
            digit ++;
        }
        while(digit >= 0){
            dividend -= (divisor << digit);
            result += 1 << digit;
            digit--;
        }
        if(minus){
            return -result;
        }
        return result;
    }
    public static void main(String[] args){
    	Solution s = new Solution();
//    	Set<String> set = new HashSet<String>();
//    	set.add("a");
//    	set.add("b");
//    	set.add("c");
//    	System.out.println(s.ladderLength("a", "c", set));
    
    	System.out.println(s.divide(-1010369383, -2147483648));
    }
}
