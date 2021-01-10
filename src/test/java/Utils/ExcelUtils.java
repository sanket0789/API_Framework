package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String ProjectPath;
	static XSSFWorkbook Workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {

		try {


			Workbook = new XSSFWorkbook(excelPath);
			sheet = Workbook.getSheet(sheetName);
		}

		catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}

	public static void main(String[] args) {

		//GetRowCount();
		//getCellDataString(0,0);
		//getCellDataNumber(1,1);

	}

	public static int GetRowCount() {

		int rowCount = 0;

		try {

			rowCount = sheet.getPhysicalNumberOfRows();

			System.out.println("No of Rows : " + rowCount);

		}

		catch (Exception exp) {


			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}
		return rowCount;

	}

	public static String getCellDataString(int rowNum, int colNum) {

		String CellData = null;
		try {

			CellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println(CellData);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return CellData;

	}

	public static void getCellDataNumber(int rowNum, int colNum) {


		try {

			double CellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(CellData);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}


	}

	public static int GetColCount() {

		int colCount = 0;

		try {

			colCount = sheet.getRow(0).getPhysicalNumberOfCells();

			System.out.println("No of Columns : " + colCount);

		}

		catch (Exception exp) {


			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}
		return colCount;

	}



}
