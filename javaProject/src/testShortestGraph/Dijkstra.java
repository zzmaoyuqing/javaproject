package testGraph8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dijkstra {
	Set<Node> unvisited = new HashSet<Node>();
	Set<Node> visited = new HashSet<Node>();
	Map<String,Integer> path = new HashMap<String,Integer>();//encapsulate distance of nodes
	Map<String,String> pathInfo = new HashMap<String,String>();//encapsulate path info nodes
	
	public Node init() {
		path.put("n0",Integer.MAX_VALUE);
		pathInfo.put("n0", "0");
		path.put("n1",Integer.MAX_VALUE);
		pathInfo.put("n1", "0");
		path.put("n2",8);
		pathInfo.put("n2", "0-->2");
		path.put("n3",Integer.MAX_VALUE);
		pathInfo.put("n3", "0");
		path.put("n4",Integer.MAX_VALUE);
		pathInfo.put("n4", "0");
		path.put("n5",Integer.MAX_VALUE);
		pathInfo.put("n5", "0");
		path.put("n6",7);
		pathInfo.put("n7", "0-->3");
		path.put("n7",3);
		pathInfo.put("n7", "0-->7");
		path.put("n8",9);
		pathInfo.put("n8", "0-->8");
		path.put("n9",3);
		pathInfo.put("n9", "0-->9");
		path.put("n10",Integer.MAX_VALUE);
		pathInfo.put("n10", "0");
		path.put("n11",Integer.MAX_VALUE);
		pathInfo.put("n11", "0");
		path.put("n12",Integer.MAX_VALUE);
		pathInfo.put("n12", "0");
		path.put("n12",Integer.MAX_VALUE);
		pathInfo.put("n13", "0");
		path.put("n14",Integer.MAX_VALUE);
		pathInfo.put("n14", "0");
		//put start node into visited set,and put others into unvisited set
		Node start = new MapBuilder().build(unvisited, visited);
		return start;	
	}
	
	public void computePath(Node start) {
		Node nearest = getShortestPath(start);
		if(nearest == null) {
			return;
		}
		visited.add(nearest);//traversed nodes
		unvisited.remove(nearest);
		
		Map<Node,Integer> childs = nearest.getChild();
		for(Node child : childs.keySet()) {
			if(unvisited.contains(child)) {
				Integer newCompute = path.get(nearest.getName())+childs.get(child);
				if(newCompute < path.get(child.getName())) {
					path.put(child.getName(),newCompute);
					pathInfo.put(child.getName(), pathInfo.get(nearest.getName()) + "->" + child.getName());
				}
			}
		}
		computePath(start);//iteration ,ensure every node is traversed
		computePath(nearest);
	}
	
	public void printPathInfo() {
		Set<Map.Entry<String,String>> pathInfos = pathInfo.entrySet();
		for(Map.Entry<String,String> pathInfo : pathInfos) {
			System.out.println(pathInfo.getKey() + ":" + pathInfo.getValue());
		}
	}
	
	public Node getShortestPath(Node node) {
		Node rest = null;
		int minDis = Integer.MAX_VALUE;
		Map<Node, Integer> childs = node.getChild();
		for(Node child : childs.keySet()) {
			if(unvisited.contains(child)) {
				int distance = childs.get(child);
				if(distance < minDis) {
					minDis = distance;
					rest = child;
				}
			}
		}
		return rest;
	}
	
	
	public static void main(String[] args){
		Dijkstra test = new Dijkstra();
		Node start = test.init();
		test.computePath(start);
		test.printPathInfo();
	}
}
