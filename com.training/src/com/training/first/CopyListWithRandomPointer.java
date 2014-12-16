package com.training.first;

import java.util.HashMap;
import java.util.Map;

import com.training.first.MergeTwoSortedList.ListNode;

public class CopyListWithRandomPointer {

	public static class RandomListNode{
		int val;
		int index;
		RandomListNode next;
		RandomListNode random;
		RandomListNode(int val, int index){
			this.val = val;
			this.index = index;
		}
	}
	
	public static RandomListNode copyRandomList(RandomListNode head){
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode p = head;
		RandomListNode helperHead = new RandomListNode(0, -1);
		RandomListNode q = helperHead;
		while(p != null){
			q.next = new RandomListNode(p.val, p.index);
			map.put(p, q.next);
			p = p.next;
			q = q.next;
		}
		p=head;
		q=helperHead;
		while(p!=null){
			q.next.random = map.get(p.random);
			p = p.next;
			q = q.next;
		}
		return helperHead.next;
	}
	
	public static void out(ListNode listNode){
		MergeTwoSortedList.out(listNode);
	}
	public static void main(String[] args){
		ListNode l1 = new ListNode(11);
		ListNode p = l1;
		p.next = new ListNode(8);
		p = p.next;
		p.next = new ListNode(9);
		p = p.next;
		p.next = new ListNode(3);
		p = p.next;
		p.next = new ListNode(18);
	}
}
