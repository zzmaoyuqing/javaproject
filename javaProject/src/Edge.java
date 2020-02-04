package javaProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Edge {
/*count edges
 * invoke readFile() to get the sbff(StringBuffer)
 * use indexOf(String,fromIndex) to count the number of edges
 * return the number of edges
 * */
	public int culculateEdges(StringBuffer sbff) throws IOException{
		int countEdges  = 0;
		int index = 0;
		String findIndex = "edge source = ";
		while((index = sbff.indexOf("edge source", index)) != -1) {
			index = index +findIndex.length();
			countEdges++;
		}
		return countEdges;
	}
	
	
	public List<String> displayEdges(StringBuffer buff){
		StringBuffer sb = new StringBuffer(buff);
		List<String> list = new ArrayList<String>();
		int startIndex = 0;
		int s = 0;
		while((startIndex = sb.indexOf("<data key=\"e_id\">", startIndex)) != -1) {		
			startIndex = sb.indexOf("<data key=\"e_id\">", startIndex);
			int Index = sb.indexOf(">", startIndex);
			int endIndex = sb.indexOf("<", Index + 1);
			String str = sb.substring(Index + 1, endIndex);
			list.add(str);
			s = endIndex;
			endIndex = startIndex;
			startIndex = s;
		}
		return list;
	}
}

