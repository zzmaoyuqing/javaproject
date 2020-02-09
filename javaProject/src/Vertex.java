package javaProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Vertex {
	/**
	 * get the number of nodes
	 * 
	 * @param  StringBuffer type
	 **/
	 @SuppressWarnings("null")
	public int calculateNodes(StringBuffer sbff) throws IOException{
	       int countNode = 0;
	       int index = 0;
	       String findIndex="node id = ";
	       while ((index = sbff.indexOf("node id", index)) != -1) {
	    	   index = index + findIndex.length();
	           countNode++;
	       }
	       return countNode;
	}
	 /**
	  * get the list of vertices' name
	  * @param  StringBuffer type
	  * */	   
	 public List<String> displayVertices(StringBuffer sbff) {
		 StringBuffer sb = new StringBuffer(sbff);
		 List<String> list = new ArrayList<String>();
		 int startIndex = 0;
		 int s ;
		 while((startIndex = sb.indexOf("<data key=\"v_id\">",startIndex)) != -1) {		 
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
