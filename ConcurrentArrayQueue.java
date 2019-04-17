package algo;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentArrayQueue<T> {
	private Object[] ring;
	private AtomicInteger headIndex=new AtomicInteger(0);
	private AtomicInteger tailIndex=new AtomicInteger(0);
	
	public ConcurrentArrayQueue(int capacity){
		ring=new Object[capacity+1];
	}
	
	public boolean push(T element){
		int currentHeadIndex;
		int currentTailIndex;
		
		do{
			//操作前获得下标
			currentHeadIndex=headIndex.get();
			currentTailIndex=tailIndex.get();
			
			//队满
			if((currentTailIndex+1)%ring.length==currentHeadIndex){
				return false;
			}
			
		}while(tailIndex.compareAndSet(currentTailIndex, currentTailIndex+1));
		//CAS后赋值
		ring[currentTailIndex % ring.length] = element;
		
		return Boolean.FALSE;
	}
	
	public static void main(String[] args) {
		
	}
}
