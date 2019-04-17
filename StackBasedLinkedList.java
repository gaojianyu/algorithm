package algo;
/*
 * ջ
 * �������޵����Ա�
 * 
 * ����
 * 1.��������ջ
 * 2.���ʽ��ֵ(��ֵջ|�����ջ)
 * 3.����ƥ��
 */
public class StackBasedLinkedList<T> {
	//ջ��
	SNode top=null;

	//get
	public SNode getTop() {
		return top;
	}
	
	public void push(T value){
		SNode node=new SNode(value);
		//��ջ
		if(top==null){
			top=node;
		}else{
			node.setNext(top);
			top=node;
		}
	}
	

	public T pop(){
		if(top==null){
			return null;
		}
		T value=(T) top.getElement();
		top=top.getNext();
		return value;
	}
	
	public static void main(String[] args) {
		StackBasedLinkedList stack=new StackBasedLinkedList();
		stack.push(2);
		stack.push(4);
		stack.push(6);
		stack.push(8);
		SNode first=stack.getTop();
		first.printAll(first);
		System.out.println("����|"+stack.pop());
		first=stack.getTop();
		first.printAll(first);
	}
}
