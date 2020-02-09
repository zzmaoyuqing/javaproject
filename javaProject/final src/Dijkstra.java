package group24;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;



/**
 * Dijkstra Algorithm
 * **/
public class Dijkstra {
	
	
	private Queue<Integer> visited;
	int[] distance;
	
	
	public Dijkstra(int len) {
		// TODO Auto-generated constructor stub
		visited=new LinkedList<Integer>();
		distance=new int[len];
		
	}
	
	/**
	 * <head>Dijkstra Algorithm, used to calculate the Shortest Distance</head>
	 * <p>Inputing the number of current node, it will output a file saying the connectivity with all the nodes</p>
	 * @param weight The Weight Array
	 * @param str The List of Node
	 * @param v Current Node
	 * @param edgeid The Edge Array
	 * **/
	public int dijkstra(int[][] weight,Object[] str,int v, FileWriter write, int[][] edgeid) throws IOException{
		int dia =0;
		HashMap<Integer, String> path;
		path=new HashMap<Integer, String>();
		for(int i = 0;i < str.length;i++)
			path.put(i, "");

		for(int i=0;i<str.length;i++){
			path.put(i, path.get(i)+""+str[v]);
			if(i==v) {
				distance[i]=0;
			}else if(weight[v][i]!=-1){
				distance[i]=weight[v][i];
				path.put(i, path.get(i)+"-->"+str[i]);
			}else {
				distance[i]=Integer.MAX_VALUE;
			}
		}
		visited.add(v);
		while(visited.size()<str.length){
			int k=getIndex(visited,distance);//get unvisited 获取未访问点中距离源点最近的点
			visited.add(k);
			if(k!=-1){ 
				for(int j=0;j<str.length;j++){
					if(weight[k][j]!=-1){		//判断k点能够直接到达的点
						//通过遍历各点，比较是否有比当前更短的路径，有的话，则更新distance，并更新path。
						if(distance[j]>distance[k]+weight[k][j]){
							distance[j]=distance[k]+weight[k][j];
							path.put(j, path.get(k)+"-->"+str[j]);		
						}
					}
				}	
			}
		}
		for(int h=0;h<str.length;h++){
			
			if(distance[h]==Integer.MAX_VALUE) {
				write.write(str[v]+" To node "+ "'" + str[h]+ "'" +"  no path");
			}
			
			else {
				String n =ChangetoEdge(path.get(h).toString(),edgeid);
				write.write(str[v]+" To node "+ "'" +str[h]+ "'" + ": path-> node["+path.get(h).toString()+"] edge["+n+"]; length:"+distance[h]+" ");
				dia = ChangeValue(dia,distance[h]);
			}
			write.write("\n");
		}
	
	        visited.clear();
	        return dia;
		
	}
	
	
	
	/**
	 * <p>getIndex, find the nearest node</p>
	 * **/
	private int getIndex(Queue<Integer> q,int[] dis){
		int k=-1;
		int min_num=Integer.MAX_VALUE;
		for(int i=0;i<dis.length;i++){
			if(!q.contains(i)){
				if(dis[i]<min_num){
					min_num=dis[i];
					k=i;
				}
			}
		}
		return k;
	}
	
	
	/**
	 * <p>num, Changing the String into integer</p>
	 * @param node node number
	 * **/
	private static int num(String node) {
		return Integer.parseInt(node);
	}
	
	
	
	/**
	 * <p>ChangetoEdge, used to change the node rout into edge rout</p>
	 * @param a node rout
	 * @param edgeArr EdgeID Array
	 * **/
	private static String ChangetoEdge(String a,int[][] edgeArr) {
		StringBuffer stb = new StringBuffer();
		if(a.contains("-->")) {
			String[] h =a.split("-->");
			for (int i = 0 ; i < h.length-1;i++) {
				int node1 =num(h[i]);
				int node2 = num(h[i+1]);
				stb.append(edgeArr[node1][node2]);
				stb.append("->");
			}
			stb.delete(stb.length()-2, stb.length());
		}
		return stb.toString();
		
	}
	
	
	
	/**
	 * <p>ChangeValue, Compare two value and output the large one</p>
	 * **/
	static int ChangeValue(int a, int b) {
		if(a >= b) {
			return a;
		}
		else
			return b;
	}

}
