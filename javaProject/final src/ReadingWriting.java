package group24;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * <head> ReadingWriting</head>
 * <p>In charge of reading and writing</p>
 * */



public class ReadingWriting {
	
	/**<head>address</head>
	 * <p>address , used to Choose the graph</p>
	 * */
	static String address(Scanner S) {
		 
		 System.out.println("Please Select the ananlizing File");
		 System.out.println("1.small graph\n2.med graph\n3.Large graph");
		 String mode = null;
		 String a = S.nextLine();
		 while((!a.contains("1")) & (!a.contains("2")) & (!a.contains("3"))) {
			 System.out.println("wrong input, please try again");
			 a = S.nextLine();
		 }
		 if(a.contentEquals("2")) {
			  System.out.println("\nMedium Graph has:");
			  mode = "./medium_graph.graphml";
		  }
		  if(a.contentEquals("1")) {
			  System.out.println("\nSmall Graph has:");
			  mode = "./small_graph.graphml";
		  }
		  if(a.contentEquals("3")) {
			  System.out.println("\nLarge Graph has:");
			  mode = "./large_graph.graphml";
		  }
		  return mode;
	 }
	
	/**<head>file</head>
	 * <p>file, used the StringBuffer and FileReader to put GraphML in to a String</p>
	 * @param address address
	 * */
	static String file(String address) throws IOException {
		 BufferedReader brd = new BufferedReader(new FileReader(address));
		 StringBuffer sbf = new StringBuffer();
		 String l = null;
		 while((l = brd.readLine()) != null) {
			  sbf.append(l);
		  }
		 brd.close();
		 l = sbf.toString();
		return l;
	 }
	
	
	
	/**<head>nodeNameList</head>
	 * <p>nodeNameList used to generate the list of node</p>
	 * @param data GraphML file
	 * */
	
	static String nodeNameList(String data) {
		StringBuffer hh = new StringBuffer();
		String list = null;
		int n1 = 0;
		while (data.contains("node id=")){
			int n = data.indexOf("node id=");
			n = data.indexOf("\"",n) + 1;
			n1 = data.indexOf("\"",n) - 1;
			
			for (int i = 0; i <= (n1-n); i++) {
				hh.append(data.charAt(n + i));
			}
			hh.append(", ");
			data = data.replaceFirst("node id=", "HHHH");
		}
		hh.delete(hh.length() - 2, hh.length());
		list = hh.toString();
		return list;
		}
	
	
	/**<head>edgeNameList</head>
	 * <p>edgeNameList used to generate the list of edge</p>
	 * @param data GraphML file
	 * */
	static String edgeNameList(String data) {
		StringBuffer hh = new StringBuffer();
		String list = null;
		int n1 = 0;
		while (data.contains("e_id\">")){
			int n = data.indexOf("e_id\">");
			n = data.indexOf(">",n) + 1;
			n1 = data.indexOf("<",n) - 1;
			for (int i = 0; i <= (n1 - n); i++) {
				hh.append(data.charAt(n + i));
			}
			hh.append(", ");
			data = data.replaceFirst("e_id\">", "HHHH");
		}
		hh.delete(hh.length() - 2, hh.length());
		list = hh.toString();

		return list;
	}
	
	
	/**<head>write</head>
	 * <p>write, write the result into  file</p>
	 * @param data GraphML file
	 * */
	static int write (String data) throws IOException {
		  int[][] weight = ArrayGen.nodeDataArray(data);
		  int[][] edgeid = ArrayGen.edgeArray(data);
		  Integer[] nodeName = ArrayGen.NodeNameI(data);
		  int len = nodeName.length;
		  int dia = 0;
		  int dia1 = 0;
		  
		  Dijkstra dijkstra = new Dijkstra(len);
		  FileWriter write = new FileWriter("./outputfile.txt");
			for(int i = 0;i < nodeName.length;i++){
				write.write("Source node " + i + ":\n");
				dia1 = dijkstra.dijkstra(weight, nodeName, i,write,edgeid);

				dia = Dijkstra.ChangeValue(dia,dia1);
			}
			write.close();
			return dia;
	}
	

}
