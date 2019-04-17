package algo;

import java.util.Scanner;



/**
 * ���ڵ�����LRU�㷨��java��
 */
public class LRUBaseLinkedList<T> {

	//ͷ���|�ڱ�
	private SNode<T> headNode;
	//������
	private Integer length;
	//��������
	private Integer capacity;
	
	//Ĭ����������
	private static final Integer DEFAULT_CAPACITY=10;
	
	//���췽��
	public LRUBaseLinkedList(){
		this.headNode=new SNode();
		this.capacity=DEFAULT_CAPACITY;
		this.length=0;
	}
	//ָ������
	public LRUBaseLinkedList(Integer capacity){
		this.headNode=new SNode();
		this.capacity=capacity;
		this.length=0;
	}
	//get
	public SNode<T> getHeadNode() {
		return headNode;
	}
	public Integer getLength() {
		return length;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public static Integer getDefaultCapacity() {
		return DEFAULT_CAPACITY;
	}
	//set
	public void setHeadNode(SNode<T> headNode) {
		this.headNode = headNode;
	}
	
	//��ӽڵ�
	public void addNode(T data){
		//���ǰ��ѯ�Ƿ��Ѿ�����|������ڷ�����ǰһ���ڵ�
		SNode preNode=findPreNode(data);
		
		if(preNode!=null){
			//ɾ��
			deleteNodeNext(preNode);
			//����ͷ��
			insertNodeAtBegain(data);
		}else{
			if(length>=this.capacity){
				//ɾ��β���ڵ�
				deleteNodeAtEnd();
			}
			//����ͷ��
			insertNodeAtBegain(data);
		}
	}

	//ɾ��ָ���ڵ���һ���ڵ�
	public void deleteNodeNext(SNode preNode){
		SNode temp=preNode.getNext();
		preNode.setNext(temp.getNext());
		temp=null;
		length--;
	}
	//����ͷ������ڵ�
	public void insertNodeAtBegain(T data){
		SNode next=headNode.getNext();
		headNode.setNext(new SNode(data,next));
		length++;
	}
	//����Ԫ�ص�ǰһ���ڵ�
	public SNode findPreNode(T data){
		SNode pre=headNode;
		while(pre.getNext()!=null){
			if(data.equals(pre.getNext().getElement())){
				return pre;
			}
			pre=pre.getNext();
		}
		return null;
	}
	//ɾ��β�ڵ�
	public void deleteNodeAtEnd(){
		SNode pre=headNode;
		//������ֱ�ӷ���
		if(pre.getNext()==null){
			return;
		}
		//�����ڶ���
		while(pre.getNext().getNext()!=null){
			pre=pre.getNext();
		}
		
		SNode last=pre.getNext();
		pre.setNext(null);
		last=null;
		length--;
	}
	
	//��ӡ����ֵ
	public void printAll(){
		SNode node=headNode;
		while(node!=null){
			System.out.print(node.getElement()+",");
			node=node.getNext();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LRUBaseLinkedList linkedList=new LRUBaseLinkedList();
		Scanner scanner = new Scanner(System.in);
		while(true){
			linkedList.addNode(scanner.nextInt());
			linkedList.printAll();
		}
	}
}
