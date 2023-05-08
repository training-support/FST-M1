package activities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Activity14 {
        public static void main(String[] args) throws IOException {
            File file = new File("src/main/resources/testfile1.txt");
            boolean fStatus = file.createNewFile();

            if(fStatus)
                System.out.println("File created");
            else
                System.out.println("Error in file creation");

            // Writing into the file
            Path fileName = Path.of("src/main/resources/testfile1.txt");
            Files.writeString(fileName, "Hello");

            //get the file Object
            File fileUtil = FileUtils.getFile("src/main/resources/testfile1.txt");
            //Read file
            System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));

        //Create directory
        File destDir = new File("resources");
        //Copy file to directory
        FileUtils.copyFileToDirectory(file, destDir);

        //Get file from new directory
        File newFile = FileUtils.getFile(destDir, "testfile1.txt");
        //Read data from file
        String newFileData = FileUtils.readFileToString(newFile, "UTF8");
        System.out.println("Data in new file: " + newFileData);
    }
}
