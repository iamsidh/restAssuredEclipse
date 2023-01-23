package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath,String sheetName) {
		try {
			
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		
		
	}

	public static void getRowCount() {
		try {
			/*
			 * String ProjectDir = System.getProperty("user.dir");
			 * System.out.println(ProjectDir);
			 * 
			 * String excelPath = "./Data/TestData.xlsx";
			 * 
			 * XSSFWorkbook workbook = new XSSFWorkbook(excelPath); workbook.close();
			 * XSSFSheet sheet = workbook.getSheet("Sheet1");
			 */

			int rowCount = sheet.getPhysicalNumberOfRows();

			System.out.println("No Of Rows : " + rowCount);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	public static void getCellData(int rowNum, int colNum) {

		try {
			
			//String value = sheet.getRow(1).getCell(0).getStringCellValue();

			DataFormatter formatter = new DataFormatter();
			Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
			/*
			 * System.out.println(value); System.out.println(value2);
			 */
			System.out.println(value);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
