package algo;
//ʱ�临�Ӷ�O(n^2)
public class SortN2 {
	//ð������
	//��λ��������
	public static void bubbleSort(int[] array){
		if(array==null){
			return;
		}
		int length=array.length;
		for(int i=0;i<length;i++){
			//���û�����ݽ���|ֹͣѭ��
			boolean flag=Boolean.FALSE;
			//-i-1|ѭ����j++|����Խ��
			for(int j=0;j<length-i-1;j++){
				if(array[j+1]<array[j]){
					//����|���м����|�����������
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
	
	//��������
	//��λ��������
	public static void insertSort(int[] array){
		if(array==null){
			return;
		}
		int length=array.length;
		//�ӵڶ���Ԫ�ؿ�ʼȡֵ
		for(int i=1;i<length;i++){
			//δ����Ԫ��
			int curValue=array[i];
			//�������������һ��Ԫ���±�
			int preIndex=i-1;
			//�Ӻ���ǰ|���Ҳ���λ��
			for(;preIndex>=0;preIndex--){
				if(array[preIndex]>curValue){
					//����ƶ�|û���м����
					array[preIndex+1]=array[preIndex];
				}else{
					//�ҵ�λ��
					break;
				}
			}
			//��ֵ
			//System.out.println(preIndex);
			array[preIndex+1]=curValue;
		}
		for(int item:array){
			System.out.print(item+",");
		}
		return;
	}
	
	//ѡ������
	//��λ��������|���ȶ�����
	public static void selectionSort(int[] array){
		//ʹ�ó�����
	}
	
	public static void main(String[] args) {
		int[] array={4,5,6,1,3,2};
//		insertSort(array);
		bubbleSort(array);
	}
}
