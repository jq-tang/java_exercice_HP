package singlenum;

public class Solution {
	public static int singleNumber(int[] A) {
		if(A == null || A.length == 0)
            return 0;
        int result = 0;
        int[] bits = new int[32];
        for(int a : A){
            int i = 0;
            while(a != 0){
                bits[i++] += (a & 1);
                a = a >>> 1;
            }
        }
        for(int i = 31; i >= 0; --i){
            result = (result << 1) + (bits[i]%3);
        }
        return result;
    }
	
	public static void main(String[] args){
		int[] A = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
		System.out.println(Solution.singleNumber(A));
	}
}
