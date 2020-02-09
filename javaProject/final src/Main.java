package group24;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import group24.Calculating;
import group24.ReadingWriting;


public class Main {


//Main Function
 public static void main(String[] args) {
	 
  BufferedReader objReader = null;
  Scanner selectmod = new Scanner(System.in);
  try {
	  	  System.out.println("Guten Tag!\nPress Enter to Start");
	  	  selectmod.nextLine();
		  String mode = ReadingWriting.address(selectmod);
		  String data = ReadingWriting.file(mode);
		  System.out.println("number of node=" + Calculating.nodeCount(data));
		  System.out.println("node name:\n" + ReadingWriting.nodeNameList(data));
		  System.out.println("number of edge=" + Calculating.edgeCount(data));
		  System.out.println("edge name:\n" + ReadingWriting.edgeNameList(data));
		  System.out.println("diameter:= " + ReadingWriting.write(data));
		  System.out.println("connectivity please check the file on \" outputfile.txt");


		  
		  
		  
	  	  	  }
    
  catch (IOException e) {

   e.printStackTrace();

  } finally {

   try {
    if (objReader != null)
     objReader.close();
   } catch (IOException ex) {
    ex.printStackTrace();
   }
  }
    
 }
 
}
