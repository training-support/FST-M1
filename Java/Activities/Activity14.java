package Activities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Activity14 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/MyFile.txt");
        boolean fStatus = file.createNewFile();
        if(fStatus) {

            System.out.println("File created successfully!");

        } else {

            System.out.println("File already exists at this path.");

        }
        File fileUtil = FileUtils.getFile("src/main/resources/MyFile.txt");
        System.out.println("File contains the following data: " + FileUtils.readFileToString(fileUtil, "UTF8"));
        File destDir = new File("src/main/Resources2");
        FileUtils.copyFileToDirectory(file, destDir);
        File newFile = FileUtils.getFile(destDir, "MyFile.txt");
        String newFileData = FileUtils.readFileToString(newFile, "UTF8");
        System.out.println("Data in new file: " + newFileData);
    }

}
