package com.inetBanking.utilities;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;

	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFCellStyle;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ReadExcelFile {
		
		public static FileInputStream inputStream;	
		public static FileOutputStream outputStream;
		public static XSSFWorkbook workBook;
		public static XSSFSheet excelSheet;
		public static XSSFRow row;
		public static XSSFCell cell;
		public static XSSFCellStyle style;
		
	public static String getCellValue(String fileName, String sheetName, int rowNo,int cellNo)	
	 {
		try {
			
			    inputStream =new FileInputStream(fileName);
			    workBook=new XSSFWorkbook(inputStream);
			    excelSheet=workBook.getSheet(sheetName);
			    row=excelSheet.getRow(rowNo);
			    cell=row.getCell(cellNo);
			    workBook.close();
			    return cell.getStringCellValue();
			    
		} catch (Exception e) {
			
			return "";
			// TODO: handle exception
		}
				
	}

	public static void setCellValue(String fileName, String sheetName, int rowNo,int cellNo,String data)	
	{
		
		try {
			    inputStream =new FileInputStream(fileName);
			    workBook=new XSSFWorkbook(inputStream);
			    excelSheet=workBook.getSheet(sheetName);
			    row=excelSheet.getRow(rowNo);
			    cell=row.createCell(cellNo);
			    cell.setCellValue(data);
			    outputStream=new FileOutputStream(fileName); 
			    workBook.write(outputStream);
			    workBook.close();
			    inputStream.close();
			    outputStream.close();
			
	}        
		catch (Exception e)
		{
	         
	}
	}
	public static int getRowCount (String fileName, String sheetName)
	{
		try {
			
		    inputStream =new FileInputStream(fileName);
		    workBook=new XSSFWorkbook(inputStream);
		    excelSheet=workBook.getSheet(sheetName);
		    
		    int ttlRows=excelSheet.getLastRowNum() +1;
		    
		    workBook.close();
		    
		    return ttlRows;
		    
		}
		       catch (Exception e)
		{
		    	   return 0;
		}
	}

	public static int getColCount (String fileName, String sheetName, int rowNo)
	{
		try
		{		
		    inputStream =new FileInputStream(fileName);
		    workBook=new XSSFWorkbook(inputStream);
		    excelSheet=workBook.getSheet(sheetName);
		    
		    int ttlCells=excelSheet.getRow(0).getLastCellNum();
		    
	          workBook.close();
		    
		    return ttlCells;
		    
	      }       
		catch (Exception e)
		{
	   	   return 0;
	   }
	}

	}



