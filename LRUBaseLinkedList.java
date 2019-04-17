package algo;

import java.util.Scanner;



/**
 * 基于单链表LRU算法（java）
 */
public class LRUBaseLinkedList<T> {

	//头结点|哨兵
	private SNode<T> headNode;
	//链表长度
	private Integer length;
	//链表容量
	private Integer capacity;
	
	//默认链表容量
	private static final Integer DEFAULT_CAPACITY=10;
	
	//构造方法
	public LRUBaseLinkedList(){
		this.headNode=new SNode();
		this.capacity=DEFAULT_CAPACITY;
		this.length=0;
	}
	//指定容量
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
	
	//添加节点
	public void addNode(T data){
		//添加前查询是否已经存在|如果存在返回其前一个节点
		SNode preNode=findPreNode(data);
		
		if(preNode!=null){
			//删除
			deleteNodeNext(preNode);
			//插入头部
			insertNodeAtBegain(data);
		}else{
			if(length>=this.capacity){
				//删除尾部节点
				deleteNodeAtEnd();
			}
			//插入头部
			insertNodeAtBegain(data);
		}
	}

	//删除指定节点下一个节点
	public void deleteNodeNext(SNode preNode){
		SNode temp=preNode.getNext();
		preNode.setNext(temp.getNext());
		temp=null;
		length--;
	}
	//链表头部插入节点
	public void insertNodeAtBegain(T data){
		SNode next=headNode.getNext();
		headNode.setNext(new SNode(data,next));
		length++;
	}
	//查找元素的前一个节点
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
	//删除尾节点
	public void deleteNodeAtEnd(){
		SNode pre=headNode;
		//空链表直接返回
		if(pre.getNext()==null){
			return;
		}
		//倒数第二个
		while(pre.getNext().getNext()!=null){
			pre=pre.getNext();
		}
		
		SNode last=pre.getNext();
		pre.setNext(null);
		last=null;
		length--;
	}
	
	//打印所有值
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
