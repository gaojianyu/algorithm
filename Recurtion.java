package algo;

import java.util.HashMap;
import java.util.Map;

public class Recurtion {
	public static int Func(int n){
		if(n==4){
			return 2;
		}else{
			return 2*Func(n+1);
		}
	}
	
	//�����ظ�����
	//�ݹ�|1.�������ʱ����
	public static int Depth=0;
	public static Map<Integer,Integer> Value=new HashMap<Integer,Integer>();
	static{
		Value.put(1, 1);
		Value.put(2, 2);
	}
	public static int Step(int n){
		Depth++;
		if(Value.containsKey(n)){
			return Value.get(n);
		}else{
			int step1=Step(n-1);
			int step2=Step(n-2);
			if(!Value.containsKey(n-1)){
				Value.put(n-1, step1);
			}
			if(!Value.containsKey(n-2)){
				Value.put(n-2, step2);
			}
			return step1+step2;
		}
	}
	
	//����
	public static int price=1;
	//�һ���ƿ��
	public static int exchange=2;
	public static int trade(int n){
		//��ƿ�ɶһ�������
		int ret=n/exchange;
		//�һ���Ŀ�ƿ��
		int empty=n/exchange+n%exchange;
		
		//�߽�����|��ƿ�����Զһ�
		if(empty>1){
			return ret+trade(empty);
		}else{
			return ret;
		}
	}

	public static void main(String[] args) {
		int money=5;
		int buyNumber=money/price;
		int sum=buyNumber+trade(buyNumber);
		System.out.println(sum);
	}
}
