package JDBC_java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadClass {
	
public static void main(String[] args) throws IOException {
		
		String excelFilePath=".\\DataFile\\LogIn01.xlsx" ;    //File location
		FileInputStream inputstream=new FileInputStream(excelFilePath);
		
		XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		//Using FOR Loop
		
		int rows=sheet.getLastRowNum();   //No of rows in Excel
		int cols=sheet.getRow(1).getLastCellNum(); //No of columns in Excel
		
		for(int r=0;r<=rows;r++)    //for rows
		{
			XSSFRow row=sheet.getRow(r);
			
			for(int c=0;c<cols;c++)    //For Cell
			{
			XSSFCell cell=row.getCell(c);
			
			switch(cell.getCellType())
			{
			case STRING:System.out.println(cell.getStringCellValue());break;
			case NUMERIC:System.out.println(cell.getNumericCellValue());break;
			case BOOLEAN:System.out.println(cell.getBooleanCellValue());break;
			}
			}
			System.out.println();
		}
		
		
	}

}
