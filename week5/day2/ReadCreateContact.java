package week4.day4.weeklyassignment;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadCreateContact {

	public static String[][] readContact(String datafile) throws IOException
	{

		XSSFWorkbook book = new XSSFWorkbook("./Data/"+datafile+".xlsx");

		XSSFSheet sheet = book.getSheetAt(0);

		int rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);

		int columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println(columnCount);

		String[][] data = new String [rowCount] [columnCount];

		for (int i = 1; i <= rowCount; i++) {

			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < columnCount; j++) {

				XSSFCell cellValue = row.getCell(j);
				data[i-1][j]= cellValue.getStringCellValue();
			}
		}

		book.close();
		return data;
	}
}

