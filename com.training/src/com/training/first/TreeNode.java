package com.training.first;

public class TreeNode {

	public int key;
	public TreeNode left;
	public TreeNode right;
	
	
	public static class Builder{
		private int key;
		private TreeNode left;
		private TreeNode right;

		public Builder(int key){
			this.key = key;
		}
		public Builder left(TreeNode left){
			this.left = left;
			return this;
		}
		public Builder right(TreeNode right){
			this.right = right;
			return this;
		}
		public TreeNode build(){
			return new TreeNode(this);
		}
	}
	private TreeNode(Builder builder){
		this.key = builder.key;
		this.left = builder.left;
		this.right = builder.right;
	}
}
