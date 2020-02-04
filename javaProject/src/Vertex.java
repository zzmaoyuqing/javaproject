package javaProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Vertex {
/*count nodes
 * invoke readFile() to get the sbff(StringBuffer)
 * use indexOf(String,fromIndex) to count the number of codes
 * return the number of nodes
 **/
	   @SuppressWarnings("null")
	public int culculateNodes(StringBuffer sbff) throws IOException{
		   
	       int countNode = 0;
	       int index = 0;
	       String findIndex="node id = ";
	       while ((index = sbff.indexOf("node id", index)) != -1) {
	    	   index = index + findIndex.length();
	           countNode++;
	       }
	       return countNode;
	}
	   
	 public List<String>  displayVertices(StringBuffer buff) {
		 StringBuffer sb = new StringBuffer(buff);
		 List<String> list = new ArrayList<String>();
		 int startIndex = 0;
		 int s ;
		 while((startIndex = sb.indexOf("<data key=\"v_id\">",startIndex))!= -1) {		 
		 	 startIndex = sb.indexOf("<data key=\"v_id\">", startIndex);
		 	 int Index = sb.indexOf(">", startIndex);
			 int endIndex = sb.indexOf("<", Index + 1);
			 String str = sb.substring(Index + 1,endIndex);
			 list.add(str);
			 s = endIndex;
			 endIndex = startIndex;
			 startIndex = s;
		 }
		 return list;
	 }
}
