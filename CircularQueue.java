package algo;

public class CircularQueue {
	private String[] items;
	private int size;
	
	private int head=0;
	private int tail=0;
	
	public CircularQueue(int capacity){
		this.items=new String[capacity];
		this.size=capacity;
	}
	
	//入队
	public boolean enqueue(String item){
		//队满
		if((tail+1)%size==head){
			return false;
		}else{
			items[tail]=item;
			tail=(tail+1)%size;
			return true;
		}
	}
	
	//出队
	public String dequeue(){
		String item=null;
		//队空
		if(head==tail){
			return item;
		}else{
			item=items[head];
			head=(head+1)%size;
			return item;
		}
	}
	
	public void printAll(){
		if(size==0){
			System.out.println("");
		}else{
			int headLocal=head;
			while((headLocal%size)!=tail){
				System.out.print(items[headLocal%size]+",");
				headLocal++;
			}
			System.out.println();
		}
	}

	public void printAllW() {
		if (0 == size)
			return;
		for (int i = head; i % size != tail; ++i) {
//			System.out.print(items[i] + " ");
			System.out.print(items[i%size] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		CircularQueue queue=new CircularQueue(5);
		queue.enqueue("1");
		queue.enqueue("2");
		queue.enqueue("3");
		queue.printAllW();
		System.out.println("出队:"+queue.dequeue());
		System.out.println("出队:"+queue.dequeue());
		System.out.println("出队:"+queue.dequeue());
		queue.enqueue("5");
		queue.enqueue("6");
		queue.enqueue("7");
		queue.enqueue("8");
		queue.printAllW();
	}
}
