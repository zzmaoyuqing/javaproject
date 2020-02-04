package testGraph8;

import java.util.HashMap;
import java.util.Map;

//encapsulate the information about nodes
public class Node {
	private String name;
	private Map<Node,Integer> child = new HashMap<>();//childNode is the node which connects with startNode
	
	public Node(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addChild(Node child, Integer distance) {
		this.child.put(child,distance);
	}
	
	public Map<Node,Integer> getChild(){
		return child;
	}
	
	public void setChild(Map<Node,Integer> child) {
		this.child = child;
	}
}
