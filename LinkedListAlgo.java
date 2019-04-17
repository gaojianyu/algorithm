package algo;

import org.junit.Test;

/**
 * 多个引用|位置相对的思想
 * 
 * 1.单链表反转
 * 2.检查单链表中是否有环|圆圈
 * 3.有序链表合并
 * 4.删除倒数第K个节点
 * 5.获取链表中间节点
 */
public class LinkedListAlgo<T> {
	//单链表反转
	public static SNode reverseLinkedList(SNode list){
		SNode head=list;
		//链表为空 或者 仅一个节点
		if(head==null||head.getNext()==null){
			return list;
		}
		//三个引用节点
		SNode p1=head;
		SNode p2=head.getNext();
		SNode p3=null;
		
		while(p2!=null){
			p3=p2.getNext();
			
			p2.setNext(p1);
			
			p1=p2;
			p2=p3;
		}
		
		//处理头结点
		head.setNext(null);
		head=p1;
		return head;
	}
	@Test
	public void testReverseLinkedList(){
		LRUBaseLinkedList linkedList=new LRUBaseLinkedList();
		for (int i = 1; i < 8; i++) {
			linkedList.addNode(i);
		}
		System.out.println("顺序:");
		linkedList.printAll();
		
		SNode head=reverseLinkedList(linkedList.getHeadNode());
		linkedList.setHeadNode(head);
		System.out.println("逆序:");
		linkedList.printAll();
	}
	
	//检测环
	public static boolean checkCircle(SNode node){
		//空|一个节点|第二个节点没有应用|
		//不构成环
		if(node==null||node.getNext()==null||node.getNext().getNext()==null){
			return Boolean.FALSE;
		}
		//快慢选手
		SNode slow=node;
		SNode fast=node;
		
		
		while(Boolean.TRUE){
			//一次走两步
			fast=fast.getNext().getNext();
			//一次走一步
			slow=slow.getNext();
			if(fast==slow){
				return Boolean.TRUE;
			}
		}
		//
		return Boolean.FALSE;
	}
	@Test
	public void testCheckCircle(){
		//A>B>C>D>B
		SNode a=new SNode("A");
		SNode b=new SNode("B");
		SNode c=new SNode("C");
		SNode d=new SNode("D");
		
		a.setNext(b);b.setNext(c);c.setNext(d);
		d.setNext(b);
		
		System.out.println(checkCircle(a));
	}
	//有序链表合并|升序
	public static SNode<Integer> mergeSortedList(SNode<Integer> l1,SNode<Integer> l2){
		//一方为空|返回另外一方
		if(l1==null){
			return l2;
		}
		if(l2==null){
			return l1;
		}
		
		//两个链表头引用
		SNode<Integer> h1=l1;
		SNode<Integer> h2=l2;
		//合并后的头引用
		SNode<Integer> h;
		
		//第一次比较|确定头节点
		if(h1.getElement()<h2.getElement()){
			h=h1;
			//移动
			h1=h1.getNext();
		}else{
			h=h2;
			//移动
			h2=h2.getNext();
		}
		
		//新链表的引用
		SNode temp=h;
		while(h1!=null&&h2!=null){
			if(h1.getElement()<h2.getElement()){
				temp.setNext(h1);
				h1=h1.getNext();
			}else{
				temp.setNext(h2);
				h2=h2.getNext();
			}
			//移动
			temp=temp.getNext();
		}
		
		//一方为空|循环结束
		if(h1!=null){
			temp.setNext(h1);
		}else{
			temp.setNext(h2);
		}
		
		return h;
	}
	@Test
	public void testMergeSortedList() {
		SNode a=new SNode(1);
		SNode c=new SNode(3);
		SNode e=new SNode(5);
		SNode g=new SNode(7);
		a.setNext(c);c.setNext(e);e.setNext(g);
		
		SNode b=new SNode(2);
		SNode d=new SNode(4);
		SNode f=new SNode(6);
		b.setNext(d);d.setNext(f);
		
		SNode h=mergeSortedList(a,b);
		System.out.println("合并后");
		h.printAll(h);
	}
	//删除倒数第K个节点
	public static SNode deleteKthFromEnd(SNode head,int k){
		//两个引用
		SNode slow=head;
		SNode fast=head;
		
		//fast|移动k步
		int count=0;
		while(fast!=null&&count<k){
			fast=fast.getNext();
			count++;
		}
		//k大于链表长度
		if(fast==null){
			return head;
		}
		//slow|fast|同时移动|
		while(fast.getNext()!=null){
			fast=fast.getNext();
			slow=slow.getNext();
		}
		//slow为要删除节点前一个节点
		slow.setNext(slow.getNext().getNext());
		return head;
	}
	@Test
	public void testDeleteKthFromEnd() {
		//哨兵
		SNode h=new SNode();
		SNode a=new SNode(1);
		SNode b=new SNode(3);
		SNode c=new SNode(5);
		SNode d=new SNode(7);
		h.setNext(a);a.setNext(b);b.setNext(c);c.setNext(d);
		System.out.println("删除前");
		h.printAll(h);
		SNode result=deleteKthFromEnd(h,3);
		System.out.println("删除后");
		result.printAll(result);
	}
	//获取链表中间节点
	public static SNode getMiddleSNode(SNode head){
		if(head==null){
			return null;
		}
		SNode slow=head;
		SNode fast=head;
		while(fast.getNext()!=null&&fast.getNext().getNext()!=null){
			slow=slow.getNext();
			fast=fast.getNext().getNext();
		}
		return slow;
	}
	public static void main(String[] args) {
		SNode a=new SNode(1);
		a.printAll(a);
		SNode mid=getMiddleSNode(a);
		System.out.println(mid.getElement());
	}
}
