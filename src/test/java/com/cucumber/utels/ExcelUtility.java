package com.cucumber.utels;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Workbook book;
	public static Sheet sheet;

	public static void openExcel(String filePath) {

		try {
			FileInputStream fileIS = new FileInputStream(filePath);
			book = new XSSFWorkbook(fileIS);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void loadSheet(String sheetName) {
		sheet = book.getSheet(sheetName);
	}

	public static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

}
