package algo;


public class SNode<T> {
	//��ǰ�ڵ���ֵ
	private T element;
	//��ǰ�ڵ���һ�ڵ�
	private SNode next;
	
	//���췽��
	//�սڵ�
	public SNode(){
		this.next=null;
	}
	//����ֵ
	public SNode(T element){
		this.element=element;
	}
	//��������
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
	//��ӡnode��֮��ڵ��ֵ
	public void printAll(SNode node){
		while(node!=null){
			System.out.print(node.getElement()+",");
			node=node.getNext();
		}
		System.out.println();
	}
}
