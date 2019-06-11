package algo;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 无向图
 * 基于链表
 */
public class Graph {
	//顶点的个数
	private int v;
	//邻接表
	private LinkedList<Integer>[] adj;
	//
	private boolean found=Boolean.FALSE;
	
	//构造
	public Graph(int v){
		this.v=v;
		adj=new LinkedList[v];
		
		for (int i = 0; i < v; i++) {
			adj[i]=new LinkedList<Integer>();
		}
	}
	
	//添加边|双向
	public void addEdge(int s,int t){
		adj[s].add(t);
		adj[t].add(s);
	}
	
	//广度优先|最短路径
	public void bfs(int s,int t){
		//保护语句
		if(s==t){
			return;
		}
		//顶点是否被访问
		boolean[] visited=new boolean[v];
		//顶点访问顺序
		Queue<Integer> queue=new LinkedList<Integer>();
		//下标顶点的前前一个顶点|prev[q]=w|q的前一个顶点为w
		int[] prev=new int[v];
		//初始化默认值
		for (int i = 0; i < prev.length; i++) {
			prev[i]=-1;
		}
		
		//起点
		queue.add(s);
		visited[s]=Boolean.TRUE;
		//循环
		while(queue.size()!=0){
			int w=queue.poll();
			//w的邻接
			for(int i=0;i<adj[w].size();i++){
				int q=adj[w].get(i);
				//顶点q未被访问
				if(!visited[q]){
					prev[q]=w;
					if(q==t){
						//找到t
						print(prev,s,t);
						return;
					}
					visited[q]=Boolean.TRUE;
					queue.add(q);
				}
			}
		}
	}
	
	//深度优先|回溯思想|不一定最短
	public void dfs(int s,int t){
		found=Boolean.FALSE;
		//顶点是否被访问
		boolean[] visited=new boolean[v];
		//下标顶点的前前一个顶点|prev[q]=w|q的前一个顶点为w
		int[] prev=new int[v];
		//初始化默认值
		for (int i = 0; i < prev.length; i++) {
			prev[i]=-1;
		}
		//递归
		recurDfs(s,t,visited,prev);
		if(found){
			print(prev,s,t);
		}
	}
	//深度递归
	private void recurDfs(int w,int t,boolean[] visited,int[] prev){
		//保护语句
		if(found){
			return;
		}
		//访问顶点w
		visited[w]=Boolean.TRUE;
		if(w==t){
			found=Boolean.TRUE;
			return;
		}
		
		//循环|w的邻接
		for(int i=0;i<adj[w].size();i++){
			int q=adj[w].get(i);
			if(!visited[q]){
				prev[q]=w;
				//q的邻接
				recurDfs(q,t,visited,prev);
			}
		}
	}
	
	//递归打印
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
