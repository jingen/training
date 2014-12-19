package com.training.first;

public class ValidateBinarySearchTree {

	public static boolean isBinarySearchTree(TreeNode root){
		if(root==null) return true;
		return isLessThanSubtree(root.left, root.key)
				&& isGreaterThanSubtree(root.right, root.key)
				&& isBinarySearchTree(root.left)
				&& isBinarySearchTree(root.right);
	}
	public static boolean isLessThanSubtree(TreeNode p, int key){
		if(p==null) return true;
		return p.key < key && isLessThanSubtree(p.left, key)
				&& isLessThanSubtree(p.right, key);
	}
	public static boolean isGreaterThanSubtree(TreeNode p, int key){
		if(p==null) return true;
		return p.key > key && isGreaterThanSubtree(p.left, key)
				&& isGreaterThanSubtree(p.right, key);
	}
	
	public static boolean isBinarySearchTree2(TreeNode root){
		return isValid(root, null, null);
	}
	public static boolean isValid(TreeNode node, Integer low, Integer high){
		if(node == null) return true;
		return (low==null || node.key > low) && (high==null || node.key < high) 
				&& isValid(node.left, low, node.key) && isValid(node.right, node.key, high);
	}
	
	private static TreeNode prev;
	public static boolean isBinarySearchTree3(TreeNode root){
		prev = null;
		return inOrderTraverse(root);
	}
	
	private static boolean inOrderTraverse(TreeNode node){
		if(node==null) return true;
		if(inOrderTraverse(node.left)){
			if(prev!=null && node.key <= prev.key) return false;
			prev = node;
			return inOrderTraverse(node.right);
		}
		return false;
	}

	public static void main(String[] args){
		TreeNode treeNode1 = new TreeNode.Builder(6).build();
		TreeNode treeNode2 = new TreeNode.Builder(15).build();
		TreeNode treeNode3 = new TreeNode.Builder(9).left(treeNode1).right(treeNode2).build();
		TreeNode treeNode4 = new TreeNode.Builder(21).build();
//		TreeNode treeNode4 = new TreeNode.Builder(30).build();
		TreeNode treeNode5 = new TreeNode.Builder(31).build();
		TreeNode treeNode6 = new TreeNode.Builder(29).left(treeNode4).right(treeNode5).build();
		TreeNode treeNode7 = new TreeNode.Builder(43).build();
		TreeNode treeNode8 = new TreeNode.Builder(39).left(treeNode6).right(treeNode7).build();
		TreeNode treeNode9 = new TreeNode.Builder(19).left(treeNode3).right(treeNode8).build();
		
//		System.out.println(isBinarySearchTree(treeNode9));
//		System.out.println(isBinarySearchTree2(treeNode9));
		System.out.println(isBinarySearchTree3(treeNode9));
	}
}
