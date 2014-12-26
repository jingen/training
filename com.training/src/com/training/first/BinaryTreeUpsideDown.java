package com.training.first;

public class BinaryTreeUpsideDown {

	public static TreeNode upsideDown(TreeNode root){
		
	}
	public static void main(String[] args){
        TreeNode treeNode1 = new TreeNode.Builder(2).build();
        TreeNode treeNode2 = new TreeNode.Builder(3).build();
        TreeNode treeNode3 = new TreeNode.Builder(2).left(treeNode1).right(treeNode2).build();
        TreeNode treeNode4 = new TreeNode.Builder(4).build();
        TreeNode treeNode5 = new TreeNode.Builder(1).left(treeNode3).right(treeNode4).build();
        BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
        System.out.println(b.maxPathSum(treeNode5));
	}
}
