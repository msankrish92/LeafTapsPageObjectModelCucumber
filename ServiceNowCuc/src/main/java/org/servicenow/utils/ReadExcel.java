package org.servicenow.utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public String[][] readCell(String path) throws IOException {
		
		XSSFWorkbook excel = new XSSFWorkbook("./data/"+path+".xlsx");
		
		XSSFSheet sheet = excel.getSheet("Sheet1");
		
		int rowCount = sheet.getLastRowNum();
		
		int colCount = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowCount][colCount];
		
		for(int i=1; i<=rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return data;
		
		
		
	}
	
}
