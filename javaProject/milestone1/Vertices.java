package javaProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Vertices {
	public void main(String args[]) throws IOException {
		displayVertices(readFile());
	}
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
	
	public void displayVertices(StringBuffer sbff) {
		for(int i = 0 ;i <= sbff.length();i++) {
			if(sbff.toString().contains("node id = "))
			System.out.println("\tVertex " + i + ": 'v" + i + "'");
		}
	}
}
