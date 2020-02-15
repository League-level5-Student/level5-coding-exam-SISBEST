package Coding_Exam_B;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CodingExamB {
	static String out = "S Debug \n";
	/*
	 * This is a logging program for collecting TODO comments in a program. The program will scan
	 * Through all the files in the Coding_Exam_B/classes package, and collect all the comments that start
	 * with //TODO: and write them to their own file. See the TODO_Log_example.txt file for an idea of what 
	 * the final file output will look like.
	 */
	
	
	public static String getLoggingInfo(String fileName) {
		/*
		 * 1. Complete the getLoggingInfoMethod.
		 *    The method takes in a String for a file and returns a String. 
		 *    The method will open the file a read through it. It will then 
		 *    take all the comments that begin with //TODO: and combine them 
		 *    into one large String. The string will also state the file name and
		 *    the line number for where each TODO was found. 
		*/
			out+="File:"+fileName+"\n";
			System.out.println(out);
			try {
				String l="";
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				while(br.readLine() != null || br.readLine() != "") {
					l=br.readLine();
					System.out.println(l);
					if(l != null || l != "") {
						if(l.contains("//TODO:")) {
							out+=l+"\n";
							System.out.println(out);
						}
					}
				}
			} catch (Exception e) {
			}
		return out;
	}
	
	public static void main(String[] args) {
		String finalLogString = getLoggingInfo("src/Coding_Exam_B/classes/Camera.java");
		out = "";
		//finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/RayTracedImageViewer.java");
		out = "";
		//finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/RayTracer.java");
		out = "";
		//finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/Vector3.java");
		out = "";
		/*
		 * 2. Write the finalLogString to a file called TODO_Log.txt. The file should match TODO_Log_example.txt. 
		 */
		try {
			FileWriter fw = new FileWriter("TODO_Log.txt");
			fw.write(finalLogString);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
