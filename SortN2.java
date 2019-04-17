package algo;
//时间复杂度O(n^2)
public class SortN2 {
	//冒泡排序
	//高位是有序区
	public static void bubbleSort(int[] array){
		if(array==null){
			return;
		}
		int length=array.length;
		for(int i=0;i<length;i++){
			//如果没有数据交换|停止循环
			boolean flag=Boolean.FALSE;
			//-i-1|循环内j++|数组越界
			for(int j=0;j<length-i-1;j++){
				if(array[j+1]<array[j]){
					//交换|有中间变量|不如插入排序
					int temp=array[j+1];
					array[j+1]=array[j];
					array[j]=temp;
					
					flag=Boolean.TRUE;
				}
			}
			if(!flag){
				//
				break;
			}
		}
		for(int item:array){
			System.out.print(item+",");
		}
	}
	
	//插入排序
	//低位是有序区
	public static void insertSort(int[] array){
		if(array==null){
			return;
		}
		int length=array.length;
		//从第二个元素开始取值
		for(int i=1;i<length;i++){
			//未排序元素
			int curValue=array[i];
			//已排序区的最后一个元素下标
			int preIndex=i-1;
			//从后向前|查找插入位置
			for(;preIndex>=0;preIndex--){
				if(array[preIndex]>curValue){
					//向后移动|没有中间变量
					array[preIndex+1]=array[preIndex];
				}else{
					//找到位置
					break;
				}
			}
			//赋值
			//System.out.println(preIndex);
			array[preIndex+1]=curValue;
		}
		for(int item:array){
			System.out.print(item+",");
		}
		return;
	}
	
	//选择排序
	//低位是有序区|不稳定排序
	public static void selectionSort(int[] array){
		//使用场景低
	}
	
	public static void main(String[] args) {
		int[] array={4,5,6,1,3,2};
//		insertSort(array);
		bubbleSort(array);
	}
}
