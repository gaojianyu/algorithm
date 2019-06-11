package algo;

import java.util.LinkedList;
import java.util.Queue;

/*
 * ����ͼ
 * ��������
 */
public class Graph {
	//����ĸ���
	private int v;
	//�ڽӱ�
	private LinkedList<Integer>[] adj;
	//
	private boolean found=Boolean.FALSE;
	
	//����
	public Graph(int v){
		this.v=v;
		adj=new LinkedList[v];
		
		for (int i = 0; i < v; i++) {
			adj[i]=new LinkedList<Integer>();
		}
	}
	
	//��ӱ�|˫��
	public void addEdge(int s,int t){
		adj[s].add(t);
		adj[t].add(s);
	}
	
	//�������|���·��
	public void bfs(int s,int t){
		//�������
		if(s==t){
			return;
		}
		//�����Ƿ񱻷���
		boolean[] visited=new boolean[v];
		//�������˳��
		Queue<Integer> queue=new LinkedList<Integer>();
		//�±궥���ǰǰһ������|prev[q]=w|q��ǰһ������Ϊw
		int[] prev=new int[v];
		//��ʼ��Ĭ��ֵ
		for (int i = 0; i < prev.length; i++) {
			prev[i]=-1;
		}
		
		//���
		queue.add(s);
		visited[s]=Boolean.TRUE;
		//ѭ��
		while(queue.size()!=0){
			int w=queue.poll();
			//w���ڽ�
			for(int i=0;i<adj[w].size();i++){
				int q=adj[w].get(i);
				//����qδ������
				if(!visited[q]){
					prev[q]=w;
					if(q==t){
						//�ҵ�t
						print(prev,s,t);
						return;
					}
					visited[q]=Boolean.TRUE;
					queue.add(q);
				}
			}
		}
	}
	
	//�������|����˼��|��һ�����
	public void dfs(int s,int t){
		found=Boolean.FALSE;
		//�����Ƿ񱻷���
		boolean[] visited=new boolean[v];
		//�±궥���ǰǰһ������|prev[q]=w|q��ǰһ������Ϊw
		int[] prev=new int[v];
		//��ʼ��Ĭ��ֵ
		for (int i = 0; i < prev.length; i++) {
			prev[i]=-1;
		}
		//�ݹ�
		recurDfs(s,t,visited,prev);
		if(found){
			print(prev,s,t);
		}
	}
	//��ȵݹ�
	private void recurDfs(int w,int t,boolean[] visited,int[] prev){
		//�������
		if(found){
			return;
		}
		//���ʶ���w
		visited[w]=Boolean.TRUE;
		if(w==t){
			found=Boolean.TRUE;
			return;
		}
		
		//ѭ��|w���ڽ�
		for(int i=0;i<adj[w].size();i++){
			int q=adj[w].get(i);
			if(!visited[q]){
				prev[q]=w;
				//q���ڽ�
				recurDfs(q,t,visited,prev);
			}
		}
	}
	
	//�ݹ��ӡ
	public void print(int[] prev,int s,int t){
		if(prev[t]!=-1 && s!=t){
			print(prev,s,prev[t]);
		}
		System.out.print(t+"->");
	}
	
	public static void main(String[] args) {
		//{0,1,2,3}
		Graph graph=new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		
//		graph.bfs(0, 3);
		graph.dfs(0, 3);
	}
}
