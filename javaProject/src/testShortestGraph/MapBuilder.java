package testGraph8;

import java.util.Set;
/*this function is for returning the start node
 * unvisited set saves nodes which unvisited
 * visited set saves nodes which visited
 * */

public class MapBuilder {
	public Node build(Set<Node> unvisited,Set<Node> visited) {
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
		
		node0.getChild().put(node2, 8);
		node0.getChild().put(node6, 7);
		node0.getChild().put(node7, 3);
		node0.getChild().put(node8, 9);
		node0.getChild().put(node9, 3);
		
		node1.getChild().put(node3, 3);
		node1.getChild().put(node4, 9);
		node1.getChild().put(node6, 9);
		node1.getChild().put(node8, 5);
		node1.getChild().put(node10, 9);
		
		node2.getChild().put(node0, 8);
		
		node3.getChild().put(node1, 3);
		node3.getChild().put(node5, 7);
		node3.getChild().put(node8, 1);
		node3.getChild().put(node9, 4);
		node3.getChild().put(node10, 1);
		node3.getChild().put(node11, 8);
		
		node4.getChild().put(node1, 9);
		node4.getChild().put(node5, 8);
		
		node5.getChild().put(node3, 7);
		node5.getChild().put(node4, 8);
		node5.getChild().put(node6, 3);
		node5.getChild().put(node8, 1);
		
		node6.getChild().put(node0, 7);
		node6.getChild().put(node1, 9);
		node6.getChild().put(node5, 3);
		node6.getChild().put(node7, 4);
		node6.getChild().put(node10, 3);
		node6.getChild().put(node14, 2);
		
		node7.getChild().put(node0, 3);
		node7.getChild().put(node6, 4);
		node7.getChild().put(node10, 3);
		
		node8.getChild().put(node0, 9);
		node8.getChild().put(node1, 5);
		node8.getChild().put(node3, 1);
		node8.getChild().put(node5, 1);
		
		node9.getChild().put(node0, 3);
		node9.getChild().put(node3, 4);
		node9.getChild().put(node13, 7);
		node9.getChild().put(node14, 8);
		
		node10.getChild().put(node1, 9);
		node10.getChild().put(node3, 1);
		node10.getChild().put(node6, 3);
		node10.getChild().put(node7, 3);
		node10.getChild().put(node11, 4);
		
		node11.getChild().put(node3, 8);
		node11.getChild().put(node10, 4);
		node11.getChild().put(node14, 8);
		
		node12.getChild().put(node14, 6);
		
		node13.getChild().put(node9, 7);
		node13.getChild().put(node14, 8);
		
		node14.getChild().put(node6, 2);
		node14.getChild().put(node9, 8);
		node14.getChild().put(node11, 8);
		node14.getChild().put(node12, 6);
		node14.getChild().put(node13, 8);
		
		unvisited.add(node1);
		unvisited.add(node2);
		unvisited.add(node3);
		unvisited.add(node4);
		unvisited.add(node5);
		unvisited.add(node6);
		unvisited.add(node7);
		unvisited.add(node8);
		unvisited.add(node9);
		unvisited.add(node10);
		unvisited.add(node11);
		unvisited.add(node12);
		unvisited.add(node13);
		unvisited.add(node14);
		
		visited.add(node0);
		return node0;
		
	}
}
