package javaProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*main function to test the program
 * there has three functions now
 * culculateNodes()
 * culculateEdges()
 * Vertices()       doesn't finish yet
 * */
public class graphAttribution {
	public static void main(String[] args) throws IOException {
		System.out.println("Number of nodes:  = " + culculateNodes());
		System.out.println("Number of edges:  = " + culculateEdges());
		Vertices ver =new Vertices();
		ver.displayVertices(readFile());
		
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
/*count nodes
 * invoke readFile() to get the sbff(StringBuffer)
 * use indexOf(String,fromIndex) to count the number of codes
 * return the number of nodes
 **/
   @SuppressWarnings("null")
public static int culculateNodes() throws IOException{
        StringBuffer fl = new StringBuffer(readFile());
        int countNode = 0;
        int index = 0;
        String findIndex="node id = ";
        while ((index = fl.indexOf("node id", index)) != -1) {
        	index = index + findIndex.length();
            countNode++;
        }
        return countNode;
   }
/*count edges
 * invoke readFile() to get the sbff(StringBuffer)
 * use indexOf(String,fromIndex) to count the number of edges
 * return the number of edges
 * */
   public static int culculateEdges() throws IOException{
	   StringBuffer fl =new StringBuffer(readFile());
	   int countEdges  = 0;
	   int index = 0;
	   String findIndex = "edge source = ";
	   while((index = fl.indexOf("edge source", index)) != -1) {
		   index = index +findIndex.length();
		   countEdges++;
	   }
	   return countEdges;
   }

}
	
