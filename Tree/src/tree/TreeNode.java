package tree;

public class TreeNode {
	TreeNode left, right;
	int val = 0;
	TreeNode(int val){
		this.setVal(val);
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
}
