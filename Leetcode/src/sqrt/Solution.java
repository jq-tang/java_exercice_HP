package sqrt;

public class Solution {
	public int sqrt(int x) {
        if(x <= 0){
            return 0;
        }
        int left = 0;
        int right = (x >> 1) + 1;
        while(left < right){
            int mid = (left + right) >> 1;
            int tmp = mid * mid;
            if(tmp == x){
                return mid;
            }
            else if(tmp < x ){
                left = mid ;
            }
            else {
                right = mid ;
            }
        }
        return left;
    }
	
	public static void main(String[] args){
		Solution s = new Solution();
		int n = Integer.MIN_VALUE;
		n = -n;
		System.out.println(n);
	}
}
