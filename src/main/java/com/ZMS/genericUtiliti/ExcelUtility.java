package com.ZMS.genericUtiliti;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility {
/**
 * This method will read data from Excel
 * @param driver
 * @param sheetName
 * @param rowNo
 * @param cellNo
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String readDataFromExcel(WebDriver driver, String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis =new FileInputStream(IPathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		String data = cell.getStringCellValue();
		return data;
		
	}
	/**
	 * This method is used to write data inside excel sheet
	 * @param driver
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @param cellNo 
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(WebDriver driver, String sheetName, int rowNo,  String value, int cellNo) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook wb = WorkbookFactory.create(new FileInputStream(IPathConstants.excelpath));
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.createRow(rowNo);
		Cell cell =row.createCell(cellNo);
		cell.setCellValue(value);
		
		FileOutputStream fos =new FileOutputStream(IPathConstants.excelpath);
		wb.write(fos);
		wb.close();
	}
	
	
	/**
	 * This method will fetch count row created in excel sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook wb = WorkbookFactory.create(new FileInputStream(IPathConstants.excelpath));
		Sheet sh = wb.getSheet(sheetName);
		int row = sh.getLastRowNum();
		return row;
	}
	/**
	 * This method will read multiple data from excel sheet
	 * @param SheetName
	 * @param columnName
	 * @param valueColumn
	 * @param driver
	 * @param jLib
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String, String> getMultipleDataFromExcel(String SheetName, int keycolNo, int valueColumn,WebDriver driver,JavaUtility jLib) throws Throwable {
		
		//Fetching data from excel
		FileInputStream fi =new FileInputStream(IPathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		
		HashMap<String, String> map =new HashMap<String, String>();
		for(int i=1;i<=count;i++) {
			String key =sh.getRow(i).getCell(keycolNo).getStringCellValue();
			String value =sh.getRow(i).getCell(valueColumn).getStringCellValue();
			map.put(key, value);
		}
		
		for( Entry<String, String> s:map.entrySet()) {
			if(s.getKey().contains("accountname")) {
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue()+jLib.getRandomNumber());
			}
			
			else {
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
			}
		}
		return map;
	}
	
	public Object[][] getMultipleDataFromDataProvider() throws Throwable {
		FileInputStream fis =new FileInputStream(IPathConstants.excelpath);
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DP");
		int lastRow = sh.getLastRowNum()+1;
		int lastCell=sh.getRow(0).getLastCellNum();
		
		Object[][] obj =new Object[lastRow][lastCell];
		for(int i =0;i<lastRow;i++) {
			for(int j =0;j<lastCell;j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
