package algo;

import org.junit.Test;

/**
 * �������|λ����Ե�˼��
 * 
 * 1.������ת
 * 2.��鵥�������Ƿ��л�|ԲȦ
 * 3.��������ϲ�
 * 4.ɾ��������K���ڵ�
 * 5.��ȡ�����м�ڵ�
 */
public class LinkedListAlgo<T> {
	//������ת
	public static SNode reverseLinkedList(SNode list){
		SNode head=list;
		//����Ϊ�� ���� ��һ���ڵ�
		if(head==null||head.getNext()==null){
			return list;
		}
		//�������ýڵ�
		SNode p1=head;
		SNode p2=head.getNext();
		SNode p3=null;
		
		while(p2!=null){
			p3=p2.getNext();
			
			p2.setNext(p1);
			
			p1=p2;
			p2=p3;
		}
		
		//����ͷ���
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
		System.out.println("˳��:");
		linkedList.printAll();
		
		SNode head=reverseLinkedList(linkedList.getHeadNode());
		linkedList.setHeadNode(head);
		System.out.println("����:");
		linkedList.printAll();
	}
	
	//��⻷
	public static boolean checkCircle(SNode node){
		//��|һ���ڵ�|�ڶ����ڵ�û��Ӧ��|
		//�����ɻ�
		if(node==null||node.getNext()==null||node.getNext().getNext()==null){
			return Boolean.FALSE;
		}
		//����ѡ��
		SNode slow=node;
		SNode fast=node;
		
		
		while(Boolean.TRUE){
			//һ��������
			fast=fast.getNext().getNext();
			//һ����һ��
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
	//��������ϲ�|����
	public static SNode<Integer> mergeSortedList(SNode<Integer> l1,SNode<Integer> l2){
		//һ��Ϊ��|��������һ��
		if(l1==null){
			return l2;
		}
		if(l2==null){
			return l1;
		}
		
		//��������ͷ����
		SNode<Integer> h1=l1;
		SNode<Integer> h2=l2;
		//�ϲ����ͷ����
		SNode<Integer> h;
		
		//��һ�αȽ�|ȷ��ͷ�ڵ�
		if(h1.getElement()<h2.getElement()){
			h=h1;
			//�ƶ�
			h1=h1.getNext();
		}else{
			h=h2;
			//�ƶ�
			h2=h2.getNext();
		}
		
		//�����������
		SNode temp=h;
		while(h1!=null&&h2!=null){
			if(h1.getElement()<h2.getElement()){
				temp.setNext(h1);
				h1=h1.getNext();
			}else{
				temp.setNext(h2);
				h2=h2.getNext();
			}
			//�ƶ�
			temp=temp.getNext();
		}
		
		//һ��Ϊ��|ѭ������
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
		System.out.println("�ϲ���");
		h.printAll(h);
	}
	//ɾ��������K���ڵ�
	public static SNode deleteKthFromEnd(SNode head,int k){
		//��������
		SNode slow=head;
		SNode fast=head;
		
		//fast|�ƶ�k��
		int count=0;
		while(fast!=null&&count<k){
			fast=fast.getNext();
			count++;
		}
		//k����������
		if(fast==null){
			return head;
		}
		//slow|fast|ͬʱ�ƶ�|
		while(fast.getNext()!=null){
			fast=fast.getNext();
			slow=slow.getNext();
		}
		//slowΪҪɾ���ڵ�ǰһ���ڵ�
		slow.setNext(slow.getNext().getNext());
		return head;
	}
	@Test
	public void testDeleteKthFromEnd() {
		//�ڱ�
		SNode h=new SNode();
		SNode a=new SNode(1);
		SNode b=new SNode(3);
		SNode c=new SNode(5);
		SNode d=new SNode(7);
		h.setNext(a);a.setNext(b);b.setNext(c);c.setNext(d);
		System.out.println("ɾ��ǰ");
		h.printAll(h);
		SNode result=deleteKthFromEnd(h,3);
		System.out.println("ɾ����");
		result.printAll(result);
	}
	//��ȡ�����м�ڵ�
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
