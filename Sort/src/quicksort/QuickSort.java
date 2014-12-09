package quicksort;

public class QuickSort {
	public void quickSort(int[] A, int i, int j) {
		int left = i, right = j;
		int mid = A[(i + j) >> 1];
		while (i <= j) {
			while (A[i] < mid) {
				i++;
			}
			while (A[j] > mid) {
				j--;
			}
			if (i <= j) {
				swap(A, i, j);
				i++;
				j--;
			}
		}
		if (left < j) {
			quickSort(A, left, j);
		}
		if (right > i) {
			quickSort(A, i, right);
		}
	}
	
	public void swap(int[] a, int i, int j){
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	 public static void main(String a[]){
         
		QuickSort sorter = new QuickSort();
        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        int[] A = {3,2,1,4};
        
        sorter.quickSort(input, 0, input.length-1);
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
	}
}
