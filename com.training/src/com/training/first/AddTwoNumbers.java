package com.training.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTwoNumbers {

	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode list1, ListNode list2){
		ListNode head = new ListNode(0);
		ListNode p = head;
		ListNode p1 = list1, p2 = list2;
		int carry = 0;
		while(p1!=null || p2!=null){
			int digit1 = (p1!=null)? p1.val : 0;
			int digit2 = (p2!=null)? p2.val : 0;
			int digit = digit1 + digit2 + carry;
			carry = digit/10;
			p.next = new ListNode(digit%10);
			p = p.next;
			if(p1!=null) p1=p1.next;
			if(p2!=null) p2=p2.next;
		}
		if(carry>0) p.next = new ListNode(carry);
		return head.next;
	}
	
	public static List<Integer> addTwoNumbers2(List<Integer> list1, List<Integer> list2){
		List<Integer> list = new ArrayList<Integer>();
		int carry = 0;
		int length = Math.max(list1.size(), list2.size());
		for(int i=0; i<length; i++){
			int digit1 = (i<list1.size())? list1.get(i):0;
			int digit2 = (i<list2.size())? list2.get(i):0;
			int digit = digit1 + digit2 + carry;
			carry = digit/10;
			list.add(digit%10);
		}
		if(carry>0) list.add(carry);
		return list;
	}
	public static void out(ListNode list){
		while(list!=null){
			System.out.println(list.val);
			list = list.next;
		}
	}
	public static void main(String[] args){
		ListNode list1 = new ListNode(2);
		ListNode p = list1;
		p.next = new ListNode(4);
		p = p.next;
		p.next = new ListNode(3);
		
		ListNode list2 = new ListNode(5);
		p = list2;
		p.next = new ListNode(6);
		p = p.next;
//		p.next = new ListNode(4);
		p.next = new ListNode(8);
		
//		out(list1);
//		out(list2);
		out(addTwoNumbers(list1, list2));
		
		Integer[] list = {2,4,3};
		List<Integer> l1 = Arrays.asList(list);
		list = new Integer[]{5,6,8};
		List<Integer> l2 = Arrays.asList(list);
		
		System.out.println(addTwoNumbers2(l1,l2));
	}
}
