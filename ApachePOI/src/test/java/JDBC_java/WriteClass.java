package JDBC_java;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteClass {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Emp Info");
		
		Object empdata[][]= {
				{"EmpID","Name","Job"},
				{101,"Raj","Doctor"},
				{102,"Rajesh","DR"}
	         };
		
		int rows=empdata.length;
		int cols=empdata[0].length;
		
		System.out.println(rows);
		System.out.println(cols);
		
		for(int r=0;r<rows;r++)
		{
			XSSFRow row=sheet.createRow(r);   //Create Row
			for(int c=0;c<cols;c++)
			{
				XSSFCell cell=row.createCell(c);
				Object value=empdata[r][c];
				
				if(value instanceof String)
					cell.setCellValue((String)value);
				if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);
			}
		}
		
		String filepath=".\\DataFile\\employe.xlsx";
		FileOutputStream outstream=new FileOutputStream(filepath);
		workbook.write(outstream);
		
		outstream.close();
		
		System.out.println("File created successfully");
}}
