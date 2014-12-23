package com.training.first;

public class ConvertSortedListToBinarySearchTree {

	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	private static ListNode list;
	
	private static TreeNode sortedListToBST(int start, int end){
		if(start>end) return null;
		int mid = (start+end)/2;
		TreeNode left = sortedListToBST(start, mid-1);
		TreeNode parent = new TreeNode.Builder(list.val).build();
		parent.left = left;
		list = list.next;
		parent.right = sortedListToBST(mid+1, end);
		return parent;
	}
	
	public static TreeNode sortedListToBST(ListNode head){
		int n=0;
		ListNode p = head;
		while(p!=null){
			n++;
			p = p.next;
		}
		list = head;
		return sortedListToBST(0, n-1);
	}
	public static void main(String[] args){
//		int[] numbers = {6, 9, 15, 19, 21, 29, 31, 39, 43};	
		ListNode head = new ListNode(6);
		ListNode p = head;
		p.next = new ListNode(9);
		p = p.next;
		p.next = new ListNode(15);
		p = p.next;
		p.next = new ListNode(19);
		p = p.next;
		p.next = new ListNode(21);
		p = p.next;
		p.next = new ListNode(29);
		p = p.next;
		p.next = new ListNode(31);
		p = p.next;
		p.next = new ListNode(39);
		p = p.next;
		p.next = new ListNode(43);
		TreeNode result = sortedListToBST(head);
		System.out.println(result);
	}
}
