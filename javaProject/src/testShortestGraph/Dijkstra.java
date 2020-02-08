package testGraph8;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Dijkstra {
	List<Node> unvisited = new LinkedList<Node>();
	List<Node> visited = new LinkedList<Node>();
	Map<Node,Integer> path = new HashMap<Node,Integer>();//encapsulate distance of nodes
	Map<String,String> pathInfo = new HashMap<String,String>();//encapsulate path info nodes
	
	public  static List<Node> build() {
		Node node0 = new Node("n0");
		Node node1 = new Node("n1");
		Node node2 = new Node("n2");
		Node node3 = new Node("n3");
		Node node4 = new Node("n4");
		Node node5 = new Node("n5");
		Node node6 = new Node("n6");
		Node node7 = new Node("n7");
		Node node8 = new Node("n8");
		Node node9 = new Node("n9");
		Node node10 = new Node("n10");
		Node node11 = new Node("n11");
		Node node12 = new Node("n12");
		Node node13 = new Node("n13");
		Node node14 = new Node("n14");
		
		node0.addChild(node2, 8);
		node0.addChild(node6, 7);
		node0.addChild(node7, 3);
		node0.addChild(node8, 9);
		node0.addChild(node9, 3);
		
		node1.addChild(node3, 3);
		node1.addChild(node4, 9);
		node1.addChild(node6, 9);
		node1.addChild(node8, 5);
		node1.addChild(node10, 9);
		
		node2.addChild(node0, 8);
		
		node3.addChild(node1, 3);
		node3.addChild(node5, 7);
		node3.addChild(node8, 1);
		node3.addChild(node9, 4);
		node3.addChild(node10, 1);
		node3.addChild(node11, 8);
		
		node4.addChild(node1, 9);
		node4.addChild(node5, 8);
		
		node5.addChild(node3, 7);
		node5.addChild(node4, 8);
		node5.addChild(node6, 3);
		node5.addChild(node8, 1);
		
		node6.addChild(node0, 7);
		node6.addChild(node1, 9);
		node6.addChild(node5, 3);
		node6.addChild(node7, 4);
		node6.addChild(node10, 3);
		node6.addChild(node14, 2);
		
		node7.addChild(node0, 3);
		node7.addChild(node6, 4);
		node7.addChild(node10, 3);
		
		node8.addChild(node0, 9);
		node8.addChild(node1, 5);
		node8.addChild(node3, 1);
		node8.addChild(node5, 1);
		
		node9.addChild(node0, 3);
		node9.addChild(node3, 4);
		node9.addChild(node13, 7);
		node9.addChild(node14, 8);
		
		node10.addChild(node1, 9);
		node10.addChild(node3, 1);
		node10.addChild(node6, 3);
		node10.addChild(node7, 3);
		node10.addChild(node11, 4);
		
		node11.addChild(node3, 8);
		node11.addChild(node10, 4);
		node11.addChild(node14, 8);
		
		node12.addChild(node14, 6);
		
		node13.addChild(node9, 7);
		node13.addChild(node14, 8);
		
		node14.addChild(node6, 2);
		node14.addChild(node9, 8);
		node14.addChild(node11, 8);
		node14.addChild(node12, 6);
		node14.addChild(node13, 8);
		
		List<Node> list = new LinkedList<Node>();
		list.add(node0);
		list.add(node1);
		list.add(node2);
		list.add(node3);
		list.add(node4);
		list.add(node5);
		list.add(node6);
		list.add(node7);
		list.add(node8);
		list.add(node9);
		list.add(node10);
		list.add(node11);
		list.add(node12);
		list.add(node13);
		list.add(node14);
		return list;
		
	}
	

	public void computePath(Node start) {
		Node nearest = getNearestNode(start);
		if(nearest == null) {
			return;
		}
		visited.add(nearest);//traversed nodes
		unvisited.remove(nearest);
		
		int shortestLen = start.getChild().get(nearest);//save the shortest length from start node to current nearest node
		Map<Node,Integer> childs = nearest.getChild();
		for(Node child:childs.keySet()) {
			if(unvisited.contains(child)) {
				Integer newCompute = shortestLen + childs.get(child);
				if(newCompute < start.getChild().get(nearest)) {
					path.put(child,newCompute);
					System.out.println(start.getName() + "->" + path.get(child) + "newCompute:" + newCompute);
				}
			}
		}
		
		
		if(unvisited.isEmpty()) {
			return;
		}

		computePath(nearest);
	}
	
	
	//this method is for searching the nearest node 
	private Node getNearestNode(Node node) {
		Node rest = null;
		int minDis = Integer.MAX_VALUE;
		Map<Node, Integer> childs = node.getChild();
		//traverse all nodes which have connection whit "node" and pick the node which has shortest path of them
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
		List<Node> allNodes = build();
		Node startNode = allNodes.get(9);
		test.visited.clear();
		test.unvisited = allNodes;
		test.computePath(startNode);
		//System.out.println(allNodes.get(0).getName());
	}
}
