package Utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadingCreateAccount {

	public static String[][] read(String datafile) throws IOException {


		XSSFWorkbook book = new XSSFWorkbook("./Data/"+datafile+".xlsx");

		XSSFSheet sheet = book.getSheetAt(0);

		int rowCount = sheet.getLastRowNum();
		System.out.println("total number of rows :"+rowCount);

		int columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println("total number of columns :"+columnCount);
		
		// 2 dimensional string (excel --> rows and columns)
		
		String [][] data = new String[rowCount][columnCount];
		
		for (int i = 1; i <=rowCount; i++) {

			XSSFRow row = sheet.getRow(i);
			 
			for (int j = 0; j < columnCount; j++) {
				
				XSSFCell cell = row.getCell(j);
				
				data[i-1][j]= cell.getStringCellValue();
			}
		}
		
		book.close();
		return data;
	}
}
