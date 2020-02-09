package testGraph7;


import java.util.*;
 
public class Dijkstra {
	private Queue<Integer> visited;
	int[] distance;
	
	public Dijkstra(int len) {
		// TODO Auto-generated constructor stub
		visited=new LinkedList<Integer>();
		distance=new int[len];
		
	}
	
	private int getIndex(Queue<Integer> q,int[] dis)
	{
		int k=-1;
		int min_num=Integer.MAX_VALUE;
		for(int i=0;i<dis.length;i++)
		{
			if(!q.contains(i))
			{
				if(dis[i]<min_num)
				{
					min_num=dis[i];
					k=i;
				}
			}
		}
		return k;
	}
	
	public void dijkstra(int[][] weight,Object[] str,int v)
	{
		HashMap<Integer, String> path;
		path=new HashMap<Integer, String>();
		for(int i=0;i<str.length;i++)
			path.put(i, "");
		
		//初始化路径长度数组distance
		for(int i=0;i<str.length;i++)
		{
			path.put(i, path.get(i)+""+str[v]);
			if(i==v)
				distance[i]=0;
			else if(weight[v][i]!=-1)
			{
				distance[i]=weight[v][i];
				path.put(i, path.get(i)+"-->"+str[i]);
			}
			
			else
				distance[i]=Integer.MAX_VALUE;
		}
		visited.add(v);
		while(visited.size()<str.length)
		{
			int k=getIndex(visited,distance);//获取未访问点中距离源点最近的点
			visited.add(k);
			if(k!=-1)
			{
				
				for(int j=0;j<str.length;j++)
				{
					if(weight[k][j]!=-1)//判断k点能够直接到达的点
					{
						//通过遍历各点，比较是否有比当前更短的路径，有的话，则更新distance，并更新path。
						if(distance[j]>distance[k]+weight[k][j])
						{
							distance[j]=distance[k]+weight[k][j];
							path.put(j, path.get(k)+"-->"+str[j]);					
						}
					}
					
				}
			}
		}
		for(int h=0;h<str.length;h++)
		{
		//	System.out.printf(str[v]+"-->"+str[h]);
			if(distance[h]==Integer.MAX_VALUE)
				System.out.print(str[v]+" to node "+ "'" + str[h]+ "'" +"  no path");
			else
				System.out.print(str[v]+" to node "+ "'" +str[h]+ "'" + ": path->["+path.get(h).toString() +"]; length:"+distance[h]+" ");
			System.out.println();
		}
                visited.clear();
		
	}
}
