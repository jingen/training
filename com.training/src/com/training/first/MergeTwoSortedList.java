package com.training.first;

public class MergeTwoSortedList {
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public static ListNode merge(ListNode list1, ListNode list2){
		ListNode fakeHead = new ListNode(0);
		ListNode pointer = fakeHead;
		while(list1!=null && list2!=null){
			if(list1.val < list2.val){
				pointer.next = list1;
				list1 = list1.next;
			}else{
				pointer.next = list2;
				list2 = list2.next;
			}
			pointer = pointer.next;
		}
		if(list1!=null) pointer.next = list1;
		if(list2!=null) pointer.next = list2;
		return fakeHead.next;
	}
	
	public static void out(ListNode head){
		ListNode p = head;
		while(p!=null){
			System.out.println(p.val);
			p = p.next;
		}
	}
	public static void main(String[] args){
		// 2, 8, 23, 59
		ListNode list1 = new ListNode(2);
		ListNode p = list1;
		p.next = new ListNode(8);
		p = p.next;
		p.next = new ListNode(23);
		p = p.next;
		p.next = new ListNode(59);
//		out(list1);
		
		// 3, 5, 7, 11, 13, 25
		ListNode list2 = new ListNode(3);
		p = list2;
		p.next = new ListNode(5);
		p = p.next;
		p.next = new ListNode(7);
		p = p.next;
		p.next = new ListNode(11);
		p = p.next;
		p.next = new ListNode(13);
		p = p.next;
		p.next = new ListNode(25);
//		out(list2);
		
		p = merge(list1, list2);
		out(p);
	}
}
