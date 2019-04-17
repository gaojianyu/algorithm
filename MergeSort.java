package algo;
/*
 * ȫ����array|ʵ��
 */
public class MergeSort {
	
	public static void mergeSort(int[] array){
		if(array==null||array.length<2){
			return;
		}
		mergeSortInternal(array,0,array.length-1);
	}
	
	
	public static void mergeSortInternal(int[] array,int begin,int end){
		//��ֹ����|����Ԫ��
		if(begin>=end){
			return;
		}
		//����
		int middle=begin+(end-begin)/2;
		
		//�ݹ�
		mergeSortInternal(array,begin,middle);
		mergeSortInternal(array,middle+1,end);
		
		//�ϲ�
		merge(array,begin,middle,end);
	}
	//�ϲ�������������
	public static void merge(int[] array,int begin,int middle,int end){
		//����������ʼ�±�
		int i=begin;
		int j=middle+1;
		//�ϲ�����ʱ����
		int[] temp=new int[end-begin+1];
		int k=0;
		
		while(i<=middle&&j<=end){
			if(array[i]<=array[j]){
				temp[k++]=array[i++];
			}else{
				temp[k++]=array[j++];
			}
		}
		if(i<=middle){
			while(i<=middle){
				temp[k++]=array[i++];
			}
		}else if(j<=end){
			while(j<=end){
				temp[k++]=array[j++];
			}
		}
		//���λ��
		for(int index=0;index<=temp.length-1;index++){
			array[begin+index]=temp[index];
		}
	}
	
	public static void main(String[] args) {
		int[] array={11,8,3,9,7,1,2,5};
		mergeSort(array);
		for(int item:array){
			System.out.print(item+",");
		}
	}
}
