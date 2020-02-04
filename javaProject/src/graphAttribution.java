package javaProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/*main function to test the program
 * there has three functions now
 * culculateNodes()
 * culculateEdges()
 *
 * */
public class graphAttribution {
	public static void main(String[] args) throws IOException {
		StringBuffer file = graphAttribution.readFile();
		Vertex ver = new Vertex();
		Edge edge = new Edge();
		System.out.println("Number of nodes:  = " + ver.culculateNodes(file));
		System.out.println("Number of edges:  = " + edge.culculateEdges(file));
		System.out.println("Vertex IDs: " + ver.displayVertices(file));
		System.out.println("Edge IDs: " + edge.displayEdges(file));
	}
	
/*read file and get an object in StringBuffer which can be invoked easily
 * read *.graphml file into BufferedReader
 * use String to save the BufferedReader object(with readLine() function) ,also in order to judge if there still has next line to read
 * use StringBuffer to save the String object 
 * return an object in StringBuffer
*/
    @SuppressWarnings("null")
	public static StringBuffer readFile() throws IOException {
        BufferedReader buf = null;
        StringBuffer sbff=null;
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
	

