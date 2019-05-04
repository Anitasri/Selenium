package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String projectLocation;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath,String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet=workbook.getSheet(sheetName); //reference variable
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int getRowCount() {
 
		int rowCount=sheet.getPhysicalNumberOfRows();
		System.out.println("Row count:"+rowCount);
		return rowCount;
	}

	public static int getColCount() {

		int colCount=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Column count:"+colCount);
		return colCount;
	}


	public static String getCellDataString(int rowNum,int colNum) {

		String cellData=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		//System.out.println(cellData);
		return cellData;

	}

	public static void getCellDataNumber(int rowNum,int colNum) {

		double cellData=sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		System.out.println(cellData);


	}

}
