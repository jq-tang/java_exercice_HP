
public class SListNode {
	Object item;
	SListNode next;
	public int val;
	SListNode(Object i, SListNode next){
		this.item = i;
		this.next = next;
	}
	SListNode(Object obj){
		this.item = obj;
		this.next = null;
	}
	SListNode(int val){
		this.val = val;
	}
}
//Definition for binary tree
class TreeNode {
     Object val;
     TreeNode left;
     TreeNode right;
     TreeNode(Object item) { val = item; }
 }