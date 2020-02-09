package javaProject;


import java.util.*;
 
public class Dijkstra {
	private Queue<Integer> visited;
	int[] distance;
	
	public Dijkstra(int len) {
		// TODO Auto-generated constructor stub
		visited = new LinkedList<Integer>();
		distance = new int[len];
		
	}
	//find the nearest node 
	private int getIndex(Queue<Integer> q,int[] dis){
		int k = -1;
		int min_num = Integer.MAX_VALUE;
		for(int i = 0;i < dis.length;i++){
			if(!q.contains(i)){
				if(dis[i] < min_num){
					min_num = dis[i];
					k = i;
				}
			}
		}
		return k;
	}
	
	public void dijkstra(int[][] weight,Object[] nodeName,int v){
		HashMap<Integer, String> path;
		path = new HashMap<Integer, String>();
		for(int i = 0;i < nodeName.length;i++)
			path.put(i, "");
		
		//initialize  int[] distance
		for(int i = 0;i < nodeName.length;i++){
			path.put(i, path.get(i)+""+nodeName[v]);
			if(i == v) {
				distance[i]=0;
			}else if(weight[v][i] != -1){
				distance[i] = weight[v][i];
				path.put(i, path.get(i)+"-->"+nodeName[i]);
			}else {
				distance[i] = Integer.MAX_VALUE;
			}
		}
		visited.add(v);
		while(visited.size() < nodeName.length){
			int k = getIndex(visited,distance);//get unvisited node which is nearest to start node
			visited.add(k);
			if(k != -1){ 
				for(int j = 0;j < nodeName.length;j++){
					if(weight[k][j] != -1){		//judge node which has direct connection with node k
						//traverse all nodes,and compare is there has a shortest path,update distance[] and path if there has
						if(distance[j] > distance[k] + weight[k][j]){
							distance[j] = distance[k]+ weight[k][j];
							path.put(j, path.get(k) + "-->" + nodeName[j]);		
						}
					}
				}	
			}
		}
		
		for(int h = 0;h < nodeName.length;h++){
			if(distance[h] == Integer.MAX_VALUE)
				System.out.print(nodeName[v] + " To node " + "'" + nodeName[h] + "'" + "  no path");
			else
				System.out.print(nodeName[v] + " To node " + "'" + nodeName[h] + "'" + ": path->[" + path.get(h).toString() + "]; length:" + distance[h] + " ");
			System.out.println();
		}
            visited.clear();
		
	}
}
