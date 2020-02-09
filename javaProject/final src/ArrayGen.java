package group24;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Used to generate the arrays**/
public class ArrayGen {
	
	
	/**
	 * <p> Used to Create the array of node </p>
	 * 
	 * @param data GraphML File
	 * **/
	
	static int[][] nodeDataArray(String data) throws IOException{

		int count = Calculating.nodeCount(data);

		int[][] datare = new int[count][count];

		 for (int i = 0 ; i <= count - 1 ; i++) {
			 for (int j = 0 ; j <= count - 1; j++) {
				 
				 datare[i][j] = Calculating.edgeWeight(data, gennum(i), gennum(j));
			 }
		 }
		 for (int i = 0; i <= count - 1; i ++) {
			 datare[i][i]=0;
		 }
		 
		 FileWriter write = new FileWriter("./array.txt");
		 for( int i = 0; i <= count - 1; i++) {
			 write.write(Arrays.toString(datare[i]) + "\n");
		 }
		 write.close();
		 
		 return datare;
	}
	
	
	
	/**
	 * <p> Used to Create the array of edge </p>
	 * 
	 * @param data GraphML File
	 * **/
	static int[][] edgeArray(String data){

		int count = Calculating.nodeCount(data);

		int[][] datare = new int[count][count];

		 for (int i = 0 ; i <= count - 1 ; i++) {
			 for (int j = 0 ; j <= count - 1; j++) {
				 
				 datare[i][j]=Calculating.edgeID(data, gennum(i), gennum(j));
			 }
		 }
		 for (int i = 0; i <= count - 1; i ++) {
			 datare[i][i] = -1;
		 }
		 return datare;

	}
	
	
	/**
	 * Used to create an integer array containing the Name of node
	 * @param data GraphML
	 * **/
	static Integer[] NodeNameI(String data) {
		int num = Calculating.nodeCount(data);
		Integer[] result = new Integer[num];
		for( int i = 0 ; i < num ; i++) {
			result[i] = i;
		}
		return result;
	}
	
	
	/**
	 * Used to generate the node name
	 * @param a node name
	 * **/
	private static String gennum(int a) {
		StringBuffer sta = new StringBuffer();
		String A = sta.append("n").append(a).toString();
		return A;		
		
	}

}
