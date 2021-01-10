package Utils;

public class ExcelUtilDemo {

	public static void main(String[] args) {

		String ProjectPath = System.getProperty("user.dir");
		
		ExcelUtils excel = new ExcelUtils(ProjectPath+"/Excel/data.xlsx", "Sheet1");
		
		excel.GetRowCount();
		excel.getCellDataString(0, 0);
		excel.getCellDataNumber(1, 1);
		
	}

}
