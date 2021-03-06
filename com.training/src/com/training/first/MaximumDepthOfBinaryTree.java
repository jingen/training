package com.training.first;

public class MaximumDepthOfBinaryTree {

	public static int maxDepth(TreeNode node){
		if(node==null) return 0;
		return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
	}
	public static void main(String[] args){
		TreeNode treeNode1 = new TreeNode.Builder(6).build();
		TreeNode treeNode2 = new TreeNode.Builder(15).build();
//		TreeNode treeNode3 = new TreeNode.Builder(9).build();
		TreeNode treeNode3 = new TreeNode.Builder(9).left(treeNode1).right(treeNode2).build();
		TreeNode treeNode4 = new TreeNode.Builder(21).build();
//		TreeNode treeNode4 = new TreeNode.Builder(30).build();
		TreeNode treeNode5 = new TreeNode.Builder(31).build();
		TreeNode treeNode6 = new TreeNode.Builder(29).left(treeNode4).right(treeNode5).build();
		TreeNode treeNode7 = new TreeNode.Builder(43).build();
		TreeNode treeNode8 = new TreeNode.Builder(39).left(treeNode6).right(treeNode7).build();
		TreeNode treeNode9 = new TreeNode.Builder(19).left(treeNode3).right(treeNode8).build();	
		TreeNode treeNode10 = new TreeNode.Builder(32).build();
		treeNode5.right = treeNode10;
		System.out.println(maxDepth(treeNode9));
	}
}
