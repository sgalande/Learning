package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelSheet;
	private static XSSFWorkbook ExcelWorkBook;
	private static  XSSFCell ExcelCell;

	public static Object[][]getTabArray(String excelFilePath,String sheetName) throws Exception {

		String [][]tabArray = null;

		try {
			FileInputStream excelFile = new FileInputStream(excelFilePath);
			ExcelWorkBook = new XSSFWorkbook(excelFile);
			ExcelSheet = ExcelWorkBook.getSheet(sheetName);

			int startRow = 1;
			int startCol = 1;

			int ci,cj;

			int totalRowCount = ExcelSheet.getLastRowNum();
			int totalColCount = getTotalNumberOfColumn(ExcelSheet);

			tabArray = new String[totalRowCount][totalColCount];
			ci = 0;

			for (int i = startRow;  i<= totalRowCount; i++,ci++) {
				cj =0;
				for (int j = startCol; j <= totalColCount; j++,cj++) {
					tabArray[ci][cj] = getCellData(i,j);
					System.out.println(tabArray);
				}
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return tabArray;

	}

	private static int getTotalNumberOfColumn(XSSFSheet sheet) {
		int columnCount;
		columnCount = sheet.getRow(0).getLastCellNum();
		return columnCount-1;
	}

	private static String getCellData(int rowNum, int colNum) throws Exception {
		ExcelCell = ExcelSheet.getRow(rowNum).getCell(colNum);
		Object result;
		switch (ExcelCell.getCellTypeEnum()) {
		case NUMERIC:
			result = ExcelCell.getNumericCellValue();
			break;

		case STRING:
			result = ExcelCell.getStringCellValue();
			break;
			
		case BOOLEAN:
			result = ExcelCell.getBooleanCellValue();
			break;
			
		case BLANK:
			result = "";
			break;

		default:
			throw new Exception("Not found matching cell type");
		}

		return result.toString();
	}
}
