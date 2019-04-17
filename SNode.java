package algo;


public class SNode<T> {
	//当前节点数值
	private T element;
	//当前节点下一节点
	private SNode next;
	
	//构造方法
	//空节点
	public SNode(){
		this.next=null;
	}
	//仅有值
	public SNode(T element){
		this.element=element;
	}
	//完整构造
	public SNode(T element,SNode next){
		this.element=element;
		this.next=next;
	}
	//get set
	public T getElement() {
		return element;
	}
	public void setElement(T element) {
		this.element = element;
	}
	public SNode getNext() {
		return next;
	}
	public void setNext(SNode next) {
		this.next = next;
	}
	//打印node及之后节点的值
	public void printAll(SNode node){
		while(node!=null){
			System.out.print(node.getElement()+",");
			node=node.getNext();
		}
		System.out.println();
	}
}
