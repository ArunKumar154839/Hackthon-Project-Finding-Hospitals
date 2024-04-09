package utilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
 
public class ExcelUtility {	


	static String path = System.getProperty("user.dir")+"\\TestData\\FindingHospitals.xlsx";
	
	/*
	public static void write(String sheetName, int rownum, int colnum, String data)throws IOException {

		//Opening the excel file
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\FindingHospitals.xlsx");

		XSSFWorkbook book =new XSSFWorkbook(file);

		//Creating the sheet if it does not exist
		if(book.getSheetIndex(sheetName)==-1) 
		{
			book.createSheet(sheetName);              

		}

		//creating Sheet
		XSSFSheet sheet=book.getSheet(sheetName);

		//creating Row
		if(sheet.getRow(rownum)==null) 
		{
			sheet.createRow(rownum);
		}

		XSSFRow row =sheet.getRow(rownum);   

		// Creating cell
		XSSFCell cell=row.createCell(colnum);

		//Setting the data in the column
		cell.setCellValue(data);

		FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\ExcelFile.xlsx");

		book.write(fo);
		book.close();
		file.close();
		fo.flush();
		fo.close();

	}
	*/
	
	public static void clearExcel(String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\FindingHospitals.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		fis.close();
		
		if(work.getSheetIndex(sheetName) != -1) {
			XSSFSheet sheet = work.getSheet(sheetName);
			while(sheet.getLastRowNum() >= 0) {
				 XSSFRow row = sheet.getRow(sheet.getLastRowNum());
				sheet.removeRow(row);
			}
			FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\FindingHospitals.xlsx");
			work.write(fos);
			fos.close();
			work.close();
		}
	}
	//Method to write data into the cell 
			public static void write(String sheetName,int rownum,int colnum,String data) throws IOException
			{
				File xlfile=new File(path);
				if(!xlfile.exists())    // If file not exists then create new file
				{
				XSSFWorkbook workbook=new XSSFWorkbook();
				FileOutputStream fo=new FileOutputStream(path);
				workbook.write(fo);
				}
				FileInputStream fi=new FileInputStream(path);
				XSSFWorkbook workbook=new XSSFWorkbook(fi);
				if(workbook.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
					workbook.createSheet(sheetName);
				XSSFSheet sheet=workbook.getSheet(sheetName);
				if(sheet.getRow(rownum)==null)   // If row not exists then create new Row
						sheet.createRow(rownum);
				XSSFRow row=sheet.getRow(rownum);
				XSSFCell cell=row.createCell(colnum);
				cell.setCellValue(data);
				FileOutputStream fo=new FileOutputStream(path);
				workbook.write(fo);		
				workbook.close();
				fi.close();
				fo.close();
			}
}