package com.training.first;

import java.util.HashMap;
import java.util.Map;

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
		RandomListNode(RandomListNode node){
			this.val = node.val;
			this.index = node.val;
		}
		@Override
		public String toString(){
			return "Val is"+val+", Index is" +index+", random is [" + random.val +","+random.index +"]";
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
	
	public static RandomListNode copyRandomList2(RandomListNode head){
		RandomListNode p = head;
		while(p != null){
			RandomListNode next = p.next;
			RandomListNode copy = new RandomListNode(p);
			p.next = copy;
			copy.next = next;
			p = next;
		}
		p = head;
		while(p != null){
			p.next.random = (p.random != null) ? p.random.next:null;
			p = p.next.next;
		}
		p = head;
		RandomListNode headCopy = (p!=null)? p.next : null;
		while(p != null){
			RandomListNode copy = p.next;
			p.next = copy.next;
			p = p.next;
			copy.next = (p!=null)? p.next:null;
		}
		return headCopy;

	}
	
	public static void out(RandomListNode listNode){
		RandomListNode p = listNode;
		while(p!=null){
			System.out.println(p);
			p = p.next;
		}
	}
	public static void main(String[] args){
		RandomListNode l1 = new RandomListNode(11,1);
		RandomListNode p = l1;
		p.next = new RandomListNode(8,2);
		p.random = l1.next;
		p = p.next;
		p.next = new RandomListNode(9,3);
		p.random = l1.next.next;
		p = p.next;
		p.next = new RandomListNode(3,4);
		p.random = l1.next.next.next;
		p = p.next;
		p.next = new RandomListNode(18,5);
		p.random = l1.next.next.next.next;
		p.next.random = l1 ;
//		out(l1);
//		out(copyRandomList(l1));
		out(copyRandomList2(l1));
	}
}
