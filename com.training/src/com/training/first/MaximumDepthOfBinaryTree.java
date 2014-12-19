package com.training.first;

public class MaximumDepthOfBinaryTree {

	public static int maxDepth(TreeNode node){
		if(node==null) return 0;
		return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
	}
	public static void main(String[] args){
		
	}
}
