package com.training.first;

public class BinaryTreeUpsideDown {

	//p.left = parent.right;
	//p.right = parent;
	public static TreeNode upsideDown(TreeNode root){
		TreeNode p = root, parent = null, parentRight = null;
		while(p!=null){
			TreeNode left = p.left;
			p.left = parentRight;
			parentRight = p.right;
			p.right = parent;
			parent = p;
			p = left;
		}
		return parent;
	}

	public static TreeNode upsideDownBottomUp(TreeNode p, TreeNode parent){
		if (p == null) return parent;
		TreeNode root = upsideDownBottomUp(p.left, p);
		p.left = parent == null ? parent : parent.right;
		p.right = parent;
		return root;
	}
	
	public static TreeNode upsideDown2(TreeNode root){
		return upsideDownBottomUp(root, null);
	}
	public static void main(String[] args){
        TreeNode treeNode1 = new TreeNode.Builder(2).build();
        TreeNode treeNode2 = new TreeNode.Builder(3).build();
        TreeNode treeNode3 = new TreeNode.Builder(2).left(treeNode1).right(treeNode2).build();
        TreeNode treeNode4 = new TreeNode.Builder(4).build();
        TreeNode treeNode5 = new TreeNode.Builder(1).left(treeNode3).right(treeNode4).build();
//        TreeNode newRoot = upsideDown(treeNode5);
        TreeNode newRoot = upsideDown2(treeNode5);
        System.out.println(newRoot);
	}
}
