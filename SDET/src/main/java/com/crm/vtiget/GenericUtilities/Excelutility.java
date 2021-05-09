package com.crm.vtiget.GenericUtilities;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excelutility {
	/*this method used to read data from specific execel sheet
	 * @para sheetname, row num , cellnum, cell string value,throwable
	 */
	
	public String getExcelData(String sheetName,int rownum,int cellnum) throws Throwable {
		
			  FileInputStream file=new FileInputStream(IPathConstant.EXCELFILEPATH);
			  Workbook workbook=WorkbookFactory.create(file);
			   Sheet sheet=workbook.getSheet(sheetName);
			   Row row=sheet.getRow(rownum);
			  Cell cell=row.getCell(cellnum);
			  String value = cell.getStringCellValue();
			   return value;
			   }
	public String getexcelData(String sheetName,String tcID,String headerValue) throws Throwable {
		  FileInputStream file=new FileInputStream(IPathConstant.EXCELFILEPATH);
		  Workbook workbook=WorkbookFactory.create(file);
		  Sheet sheet=workbook.getSheet(sheetName);
		  int lastRow=sheet.getLastRowNum();
		  int expectedRow=0;
		  for(int i=0;i<=lastRow;i++) {
		   String testCaseID=sheet.getRow(i).getCell(0).getStringCellValue();
		   if(testCaseID.equalsIgnoreCase(tcID)) {
		    expectedRow=i;
		    break;
		   }
		   
		  }
		  expectedRow--;
		  int expectedColumn=0;
		  int lastCell=sheet.getRow(expectedRow).getLastCellNum();
		  for(int j=0;j<lastCell;j++) {
		   String value=sheet.getRow(expectedRow).getCell(j).getStringCellValue();
		   if(value.equalsIgnoreCase(headerValue)) {
		    expectedColumn=j;
		    break;
		   }
		  }
		  return sheet.getRow(expectedRow+1).getCell(expectedColumn).getStringCellValue();
		 }

	
public String getExcelTestData(String sheetName,int rownum,int cellnum) throws Throwable {
	
	  FileInputStream file=new FileInputStream(IPathConstant.TESTDATAPATH);
	  Workbook workbook=WorkbookFactory.create(file);
	   Sheet sheet=workbook.getSheet(sheetName);
	   Row row=sheet.getRow(rownum);
	  Cell cell=row.getCell(cellnum);
	  String value = cell.getStringCellValue();
	   return value;
	   }}

