package activities;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class Activity14 {
	
	public static void main(String args[]) throws IOException
	{
		File file = new File("src/activities/Text1.txt");
		boolean fileStatus = file.createNewFile();
		if(fileStatus)
			System.out.println("File Created Successfully");
		else
			System.out.println("File Creation error");
	
		FileWriter FW = new FileWriter(file);
		FW.append("The new file is created\n");
	    FW.close();
		
	    //Retrive Data present in file
	    
	    File retriveFile = FileUtils.getFile("src/activities/Text1.txt");
	    System.out.println("Content present in File : " +FileUtils.readFileToString(retriveFile, "UTF8"));
	    
	    //Create a directory
	    
	    File Dir = new File("Resources");
	    Dir.mkdir();
	    //Copy file to Directory
	    FileUtils.copyFileToDirectory(file, Dir);
      
	    //Get file from Directory
	    
	    File gt = FileUtils.getFile(Dir,"Text1.txt");
	   
	    String content =FileUtils.readFileToString(gt,"UTF8");
	    System.out.println("The Data present in File :" +content);    
	}

}
