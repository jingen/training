package com.training.first;

public class BalancedBinaryTree {


	public static int maxDepth(TreeNode root){
		if(root==null) return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
	
	public static boolean isBalanced(TreeNode root){
		if(root==null) return true;
		return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 &&
				isBalanced(root.left) && isBalanced(root.right);
	}

	public static final int NOTBALANCED = -1;
	public static int maxDepth2(TreeNode root){
		if(root==null) return 0;
		int L = maxDepth2(root.left);
		if(L==NOTBALANCED) return NOTBALANCED;
		int R = maxDepth2(root.right);
		if(R==NOTBALANCED) return NOTBALANCED;
		return Math.abs(R-L) <= 1 ? Math.max(R, L) + 1 : NOTBALANCED;
	}
	public static boolean isBalanced2(TreeNode root){
		return maxDepth2(root) != NOTBALANCED;
	}
	public static void main(String[] args){
		TreeNode treeNode1 = new TreeNode.Builder(6).build();
		TreeNode treeNode2 = new TreeNode.Builder(15).build();
		TreeNode treeNode3 = new TreeNode.Builder(9).left(treeNode1).right(treeNode2).build();
		TreeNode treeNode4 = new TreeNode.Builder(21).build();
		TreeNode treeNode5 = new TreeNode.Builder(31).build();
		TreeNode treeNode6 = new TreeNode.Builder(29).left(treeNode4).right(treeNode5).build();
		TreeNode treeNode7 = new TreeNode.Builder(43).build();
		TreeNode treeNode8 = new TreeNode.Builder(39).left(treeNode6).right(treeNode7).build();
		TreeNode treeNode9 = new TreeNode.Builder(19).left(treeNode3).right(treeNode8).build();	
//		TreeNode treeNode10 = new TreeNode.Builder(32).build();
//		treeNode5.right = treeNode10;
//		System.out.println(maxDepth(treeNode9));
		System.out.println(isBalanced(treeNode9));
		System.out.println(isBalanced2(treeNode9));
	}
}
