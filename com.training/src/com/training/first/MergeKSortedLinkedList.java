package com.training.first;

import com.training.first.MergeTwoSortedList.ListNode;

public class MergeKSortedLinkedList {

	public static ListNode merge(ListNode list1, ListNode list2){
		ListNode helper = new ListNode(0);
		ListNode p = helper, p1 = list1, p2 = list2;
		while(p1!=null && p2!=null){
//			int val1 = (p1!=null)? p1.val:Integer.MAX_VALUE;
//			int val2 = (p2!=null)? p2.val:Integer.MAX_VALUE;
			if(p1.val > p2.val){
				p.next = p2;
				p2 = p2.next;
			}else{
				p.next = p1;
				p1 = p1.next;
			}
			p = p.next;
		}
		if(p1!=null) p.next=p1;
		if(p2!=null) p.next=p2;
		return helper.next;
	}
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(3);
		ListNode p = l1;
		p.next = new ListNode(8);
		p = p.next;
		p.next = new ListNode(9);
		p = p.next;
		p.next = new ListNode(11);
		p = p.next;
		p.next = new ListNode(18);
		ListNode l2 = new ListNode(4);
		p = l2;
		p.next = new ListNode(5);
		p = p.next;
		p.next = new ListNode(7);
		p = p.next;
		p.next = new ListNode(13);
		p = p.next;
		p.next = new ListNode(19);
		
//		MergeTwoSortedList.out(l1);
//		MergeTwoSortedList.out(l2);
//		merge(l1,l2);
		MergeTwoSortedList.out(merge(l1, l2));
	}
}
