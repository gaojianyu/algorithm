package algo;
/*
 * 栈
 * 操作受限的线性表
 * 
 * 场景
 * 1.函数调用栈
 * 2.表达式求值(数值栈|运算符栈)
 * 3.括号匹配
 */
public class StackBasedLinkedList<T> {
	//栈顶
	SNode top=null;

	//get
	public SNode getTop() {
		return top;
	}
	
	public void push(T value){
		SNode node=new SNode(value);
		//空栈
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
		System.out.println("弹出|"+stack.pop());
		first=stack.getTop();
		first.printAll(first);
	}
}
