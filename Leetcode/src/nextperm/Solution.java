package nextperm;

import java.util.Arrays;

public class Solution {
	public void nextPermutation(int[] num) {
        for(int i = num.length - 2; i >= 0; --i){
            for(int j = num.length - 1; j > i; --j){
                if(num[i] < num[j]){
                    swap(num, i, j);
                    Arrays.sort(num, i+1 , num.length);
                    return;
                }
            }
        }
        for(int i = 1; i < num.length; ++i){
            for(int j = 0; j < num.length - i; ++j){
                swap(num, j, j + 1);
            }
        }
    }
    
    public void swap(int[] A, int i, int j){
        A[i] = A[i] ^ A[j];
        A[j] = A[i] ^ A[j];
        A[i] = A[i] ^ A[j];
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] num = {1,3,2};
    	s.nextPermutation(num);
    	System.out.println(num);
    }
}
