package com.training.first;

public class ConvertSortedArrayToBinarySearchTree {
	public static TreeNode convertToBST(int[] numbers, int start, int end) {
		if (start > end) return null;
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode.Builder(numbers[mid]).build();
		node.left = convertToBST(numbers, start, mid - 1);
		node.right = convertToBST(numbers, mid + 1, end);
		return node;
	}

	public static TreeNode convertToBST(int[] numbers) {
		return convertToBST(numbers, 0, numbers.length - 1);
	}
	
	public static void main(String[] args){
		int[] numbers = {6, 9, 15, 19, 21, 29, 31, 39, 43};
		TreeNode root = convertToBST(numbers);
		System.out.println(root);
	}
}
