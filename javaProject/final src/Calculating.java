package group24;



/**
 * Calculation including the method calculating node, edge
*/


public class Calculating {
	
	/**
	 * <p>nodeCount method inputing the graphML file(which transferred into String), it will return the amount of Node</p>
	 * @param data GraphMLString
	 * */
	static int nodeCount(String data){
		 int nodee = 0;
		  while(data.contains("node id")) {
			  nodee++;
			  data = data.replaceFirst("node id", "HHH");}
		  return nodee;	 
	 }
	
	
	/**
	 * <head1>edgeCount</head1>
	 * <p>edgeCount method inputing the graphML file(which transferred into String),it will return the amount of edge</p>
	 * @param data GraphMLString
	 * */
	static int edgeCount(String data){
		 int edgee = 0;
		  while(data.contains("edge source")) {
			  edgee++;
			  data = data.replaceFirst("edge source", "HHH");}
		  return edgee;	 
	 }
	
	
	/**
	 * <head1>gen</head1>
	 * <p>Searching Target Generator to create ex: source="n1" target="n2"</p>
	 * */
	
	 static String gen(String node1, String node2) {
		 StringBuffer sear1 = new StringBuffer();
		 
		 if (num(node1) > num(node2)) {
			 String t = node1;
			 node1 = node2;
			 node2 = t;
		 }
		 sear1.append("source=\"").append(node1).append("\" target=\"").append(node2).append("\"");
		 return sear1.toString();
		 }
	 
	 
	 
	 /**
	  * <head1>edgeID</head1>
	  * <p>edgeID, used to find the edge id between two node</p>
	  * @param data GraphMLString
	  * */
	 static int edgeID(String data,String node1, String node2) {
		 String san = gen(node1, node2);
		 StringBuffer edgenumber = new StringBuffer();
		 int num = 0;
		 int ind,ind1 = 0;
		 
		 
		 if(node1 == node2) {
			 num = -1;
		 }
		 else if (data.contains(san)) {
			 ind = data.indexOf(san);
			 ind = data.indexOf("e_id",ind);
			 ind = data.indexOf(">",ind) + 1;
			 ind1 = data.indexOf("<",ind) - 1;
			 for (int i = 0; i <= (ind1-ind); i++) {
				 edgenumber.append(data.charAt(ind + i));
			 }
			 num = Integer.parseInt(edgenumber.toString());
		 }
		 else
			 num = -1;		 		 		 
		 return num;
		 }
		
	 
	 /**
	  * <head1>num</head1>
	  * <p>num, used to transfer the node name into integer</p>
	  * */
	 static int num(String node) {
			StringBuffer stb = new  StringBuffer();
			int a = 0;
			a = Integer.parseInt(stb.append(node).delete(0, 1).toString());
			stb.delete(0, stb.length());
			return a;
		}
	 
	 /**
	  * <head1>edgeWeight</head1>
	  * <p>edgeWeight, used to find the weight between two node</p>
	  * @param data GraphMLString
	  * @param node1 node with 'n'
	  * @param node2 node with 'n'
	  * */
	 static int edgeWeight(String a,String node1,String node2) {
		 String san = gen(node1, node2);
		 StringBuffer edgeweight = new StringBuffer();
		 int num = 0;
		 int ind,ind1 = 0;
		 if(node1 == node2 ) {
			 num = -1;
		 }
		 else if(a.contains(san)) {
			 ind = a.indexOf(san);
			 ind = a.indexOf("e_weight",ind);
			 ind = a.indexOf(">",ind) + 1;
			 ind1 = a.indexOf("<",ind) - 1;
			 for (int i = 0; i <= (ind1-ind); i++) {
				 edgeweight.append(a.charAt(ind + i));
			 }	
			 
			 num = Integer.parseInt(edgeweight.toString());				 
		 }
		 else
			 num = -1;

		 return num;
	 }


}
