package LRU;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Test {
	 public int largestRectangleArea(int[] height) {
	        if(height == null || height.length == 0)
	            return 0;
	        int max = 0;
	        int len = height.length;
	        int[] dup = new int[len+1];
	        dup = Arrays.copyOf(height, height.length + 1);
	        Stack<Integer> s = new Stack<Integer>();
	        int i = 0;
	        while(i <= len){
	            if(s.isEmpty() || dup[i] >= dup[s.peek()]){
	                s.push(i++);
	            }
	            else{
	                int t = s.pop();
	                max = Math.max(max, dup[t] * (s.isEmpty() ? i : i - s.peek() - 1));
	            }
	        }
	        return max;
	    }

    public static void main(String[] args) {  
    	int[] a = {1};
        System.out.println(new Test().largestRectangleArea(a));  
    }  
}