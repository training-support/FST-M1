package activities;
import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Activity15 {
	private static String FILE_NAME = "resources/TestSheet.xlsx";

	public static void main (String args[])
	{
		XSSFWorkbook xsf =new XSSFWorkbook();
		XSSFSheet sheet = xsf.createSheet("Datatypes in Java");
		
		Object[][] datatypes = {
			    {"Datatype", "Type", "Size(in bytes)"},
			    {"int", "Primitive", 2},
			    {"float", "Primitive", 4},
			    {"double", "Primitive", 8},
			    {"char", "Primitive", 1},
			    {"String", "Non-Primitive", "No fixed size"}
			};
		
		int rowNum = 0;

		for (Object[] datatype : datatypes) {
		    Row row = sheet.createRow(rowNum++);
		    int colNum = 0;
		    for (Object field : datatype) {
		        Cell cell = row.createCell(colNum++);
		        if (field instanceof String) {
		            cell.setCellValue((String) field);
		        } else if (field instanceof Integer) {
		            cell.setCellValue((Integer) field);
		        }
		    }
		}

		try {
			FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
			xsf.write(outputStream);
			xsf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 System.out.println("Completed");
		 
	}
}
