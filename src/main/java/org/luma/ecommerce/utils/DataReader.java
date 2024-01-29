package org.luma.ecommerce.utils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataReader 
{
	
	 public static String[][] getExcelDdata() throws IOException
	 {
		 FileInputStream file = new FileInputStream("./data/ExcelData.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		 int rowCount = sheet.getLastRowNum();
		 int colCount = sheet.getRow(0).getLastCellNum();
		 String[][] data = new String[rowCount][colCount];

			for (int i = 1; i <= rowCount; i++) 
			{
				XSSFRow eachRow = sheet.getRow(i);
				for (int j = 0; j < colCount; j++) 
				{
					XSSFCell eachCell = eachRow.getCell(j);
					data[i - 1][j] = eachCell.getStringCellValue();
					//System.out.println(data[i - 1][j]);
				}
			}
		return data;
	 }

}
