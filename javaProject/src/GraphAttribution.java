package javaProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * main function to launch the program
 * input graph information
 * calculate nodes'and edges' number
 * display nodes' and edges' name
 * calculate shortest path
 * */
public class GraphAttribution {
	public static void main(String[] args) throws IOException {
		StringBuffer file = GraphAttribution.readFile();
		Vertex ver = new Vertex();
		Edge edge = new Edge();
		System.out.println("Number of nodes:  = " + ver.calculateNodes(file));
		System.out.println("Number of edges:  = " + edge.calculateEdges(file));
		System.out.println("Vertex IDs: " + ver.displayVertices(file));
		System.out.println("Edge IDs: " + edge.displayEdges(file));
		
		int[][] weight = {
				 {0,-1,8,-1,-1,-1,7,3,9,3,-1,-1,-1,-1,-1},
				 {-1,0,-1,3,9,-1,9,-1,5,-1,9,-1,-1,-1,-1},
				 {8,-1,0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				 {-1,3,-1,0,-1,7,-1,-1,1,4,1,8,-1,-1,-1},
				 {-1,9,-1,-1,0,8,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				 {-1,-1,-1,7,8,0,3,-1,1,-1,-1,-1,-1,-1,-1},
				 {7,9,-1,-1,-1,3,0,4,-1,-1,3,-1,-1,-1,2},
				 {3,-1,-1,-1,-1,-1,4,0,-1,-1,3,-1,-1,-1,-1},
				 {9,5,-1,1,-1,1,-1,-1,0,-1,-1,-1,-1,-1,-1},
				 {3,-1,-1,4,-1,-1,-1,-1,-1,0,-1,-1,-1,7,8},
				 {-1,9,-1,1,-1,-1,3,3,-1,-1,0,4,-1,-1,-1},
				 {-1,-1,-1,8,-1,-1,-1,-1,-1,-1,4,0,-1,-1,8},
				 {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,-1,6},
				 {-1,-1,-1,-1,-1,-1,-1,-1,-1,7,-1,-1,-1,0,8},
				 {-1,-1,-1,-1,-1,-1,2,-1,-1,8,-1,8,6,8,0}};
		Integer[] nodeName = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14}; 
		int len = nodeName.length;
		Dijkstra dijkstra = new Dijkstra(len);
        //traverse nodeName,so that each node could be the first node and search for shortest path
		for(int i = 0;i < nodeName.length;i++){
			dijkstra.dijkstra(weight, nodeName, i);
		} 
	}
	
/**read file and get an object in StringBuffer which can be invoked easily
 * read *.graphml file into BufferedReader
 * use String to save the BufferedReader object(with readLine() function) ,also in order to judge if there still has next line to read
 * use StringBuffer to save the String object 
 * return an object in StringBuffer
*/
    @SuppressWarnings("null")
	public static StringBuffer readFile() throws IOException {
        BufferedReader buf = null;
        StringBuffer sbff = null;
        try {
            buf = new BufferedReader(new FileReader("/home/yuqing/Downloads/small_graph.graphml"));
            String str = null;
            sbff =new StringBuffer();
            while ((str = buf.readLine()) != null) {
                sbff.append(str);
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return sbff;
    }
}
	

