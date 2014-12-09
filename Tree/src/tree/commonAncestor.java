package tree;

public class commonAncestor {
	public static TreeNode commonAncestorBad(TreeNode root, TreeNode p, TreeNode q){
		if(root == null)
			return null;
		if(root == p && root == q){
			return root;
		}
		TreeNode x = commonAncestorBad(root.left, p, q);
		if(x != null && x != p && x != q){
			return x;
		}
		TreeNode y = commonAncestorBad(root.right, p, q);
		if(y != null && y != p && y != q)
		{
			return y;
		}
		if(x != null && y != null){
			return root;
		}
		else if(root == p || root == q){
			return root;
		}
		else{
			return x == null ? y : x;
		}
	
	}
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return -10000;
        int tmp = maxSum(root, -10000);
        return tmp;
    }
    public int maxSum(TreeNode root, int max){
        if(root == null){
            return -10000;
        }
        int leftMax = maxSum(root.left, max);
        int rightMax = maxSum(root.right, max);
        int val = root.val;
        if(leftMax > 0)
        	val += leftMax;
        if(rightMax > 0)
        	val += rightMax;
        int childMax = Math.max(leftMax, rightMax);
        max =  Math.max(val, max);
        if(childMax > 0){
            return childMax + root.val;
        }
        else
            return root.val;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length)
            return null;
        return build(inorder, postorder, 0, postorder.length-1, 0, postorder.length-1);
    }
    public TreeNode build(int[] inorder, int[] postorder, int startInorder, int endInorder, int startPost, int endPost){
        if(startInorder > endInorder || startPost > endPost){
            return null;
        }
        TreeNode root = new TreeNode(postorder[endPost]);
        //find the num of left subtree
        int n = 0;
        for(int i = startInorder; i < endInorder; ++i){
            if(inorder[endPost] == i){
                break;
            }
            n++;
        }
        root.left = build(inorder, postorder, startInorder, n+startInorder-1, startPost, startPost+n-1 );
        root.right = build(inorder, postorder, startInorder+n+1, endInorder, startPost+n, endPost-1 );
        return root;
    }
	public static void main(String[] args){
		commonAncestor ans = new commonAncestor();
		int[] a = {1,2};
		int[] b = {2,1};
		TreeNode result = ans.buildTree(a, b);
		System.out.println(result);
	}
}
