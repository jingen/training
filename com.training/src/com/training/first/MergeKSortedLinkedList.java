package com.training.first;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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
	
	public static ListNode mergeKLists2(List<ListNode> lists){
		if(lists==null) throw new IllegalArgumentException("lists is null.");
		if(lists.isEmpty()) return null;
		int end = lists.size() - 1;
		while(end>0){
			int begin = 0;
			while(begin<end){
				lists.set(begin, merge(lists.get(begin), lists.get(end)));
				begin++;
				end--;
			}
		}
		return lists.get(0);
	}
	
	
	private static final Comparator<ListNode> listComparator = 
			new Comparator<ListNode>(){
		@Override
		public int compare(ListNode x, ListNode y){
			return x.val - y.val;
		}
	};
	public static ListNode mergeLists(List<ListNode> lists){
		if(lists==null) throw new IllegalArgumentException("Lists is null.");
		if(lists.isEmpty()) return null;
		Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), listComparator);
		for(ListNode listNode: lists){
			if(listNode!=null) {
				queue.add(listNode);
			}
		}
		
		ListNode helperHead = new ListNode(0);
		ListNode p = helperHead;
		while(!queue.isEmpty()){
			ListNode listNode = queue.poll();
			p.next = listNode;
			p = p.next;
			if(listNode.next!=null){
				queue.add(listNode.next);
			}
		}
		return helperHead.next;
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
		
		
		ListNode l3 = new ListNode(1);
		p = l3;
		p.next = new ListNode(12);
		p = p.next;
		p.next = new ListNode(17);
		p = p.next;
		p.next = new ListNode(33);
		p = p.next;
		p.next = new ListNode(59);
		
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
//		MergeTwoSortedList.out(mergeLists(lists));
		MergeTwoSortedList.out(mergeKLists2(lists));
	}
}
