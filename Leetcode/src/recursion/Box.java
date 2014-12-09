package recursion;

import java.util.ArrayList;

public class Box {
	public static ArrayList<Integer> creatStack(int[] boxes, int bottom){
		int max_height = 0;
		ArrayList<Integer> max_stack = null;
		for(int i = 0; i < boxes.length; ++i){
			if(boxes[i] < bottom){
				ArrayList<Integer> new_stack = creatStack(boxes, boxes[i]);
				int new_height = new_stack.size();
				if(new_height > max_height){
					max_stack = new_stack;
					max_height = new_height;
				}
			}
		}
		if(max_stack == null){
			max_stack = new ArrayList<Integer>();
		}
		if(bottom != 10){
			max_stack.add(0, bottom);
		}
		return max_stack;
	}
	public static void main(String[] args){
		int[] box = {3,1};
		System.out.println(Box.creatStack(box, 10));
	}
}
