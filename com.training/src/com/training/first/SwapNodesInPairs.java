package com.training.first;

import com.training.first.MergeTwoSortedList.ListNode;
import com.training.first.MergeTwoSortedList;

public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = head;
		ListNode prev = dummy;
		while (p != null && p.next != null) {
			ListNode q = p.next, r = p.next.next;
			prev.next = q;
			q.next = p;
			p.next = r;
			prev = p;
			p = r;
		}
		return dummy.next;
	}
	
	public ListNode swapPairs2(ListNode head){
		ListNode helper = new ListNode(0);
		helper.next = head;
		ListNode p = head;
		ListNode prev = helper;
		while(p != null && p.next != null){
			ListNode p1 = p.next, p2 = p.next.next;
			prev.next = p1;
			p1.next = p;
			p.next = p2;
			prev = p;
			p = p2;
		}
		return helper.next;
	}
	
	public static void main(String[] args){
		SwapNodesInPairs swap = new SwapNodesInPairs();
		ListNode list = new ListNode(3);
		ListNode p = list;
		p.next = new ListNode(5);
		p = p.next;
		p.next = new ListNode(8);
		p = p.next;
		p.next = new ListNode(9);
		p = p.next;
		p.next = new ListNode(6);
//		MergeTwoSortedList.out(list);
//		MergeTwoSortedList.out(swap.swapPairs(list));
		MergeTwoSortedList.out(swap.swapPairs2(list));
	}
}
