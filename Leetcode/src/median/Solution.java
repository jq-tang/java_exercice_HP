package median;

public class Solution {
	public double findMedianSortedArrays(int A[], int B[]) {
        int lena = A.length;
        int lenb = B.length;
        if((lena + lenb) % 2 == 0){
            return 0.5 * (findKth(A, 0, lena-1, B, 0, lenb-1, (lena + lenb) >> 1) + findKth(A, 0, lena-1, B, 0, lenb-1, ((lena + lenb) >> 1) + 1));
        }
        else{
            return findKth(A, 0, lena-1, B, 0, lenb-1, (lena + lenb + 1) >> 1);      
        }
    }
    
    public int findKth(int[] A, int aleft, int aright, int[] B, int bleft, int bright, int k){
        // if(aleft > aright || bleft > bright){
        //     return -10000;
        // }
        if(aleft > aright){
            return B[bleft+k-1];
        }
        if(bleft > bright){
            return A[aleft+k-1];
        }
        if(k == 1){
            return Math.min(A[aleft], B[bleft]);
        }
        int amid = (aleft + aright) >> 1;
        int bmid = (bleft + bright) >> 1;
        if(A[amid] < B[bmid]){
            if(amid - aleft >= k){
                return findKth(A, aleft+1, aright, B, bleft, bmid-1, k);
            }
            else{
                return findKth(A, amid+1, aright, B, bleft, bright, k - (amid-aleft) - 1);
            }
        }
        else{
            if(bmid - bleft >= k){
                return findKth(A, aleft, amid-1, B, bleft, bright, k);                
            }
            else{
                return findKth(A, aleft+1, aright, B, bmid+1, bright, k - (bmid-bleft) - 1);
            }
        }
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] A = {1,2,3};
    	int[] B = {1,2,3};
    	System.out.println(s.findMedianSortedArrays(A, B));
    }
}
