package HangTester.utils.helper;

import org.testng.annotations.DataProvider;

public class DataProviderManager {
    @DataProvider(name = "data_provider_loginAdmin_excel", parallel = true)
    public Object[][] dataLoginAdminFromExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data= excelHelper.getExcelData(ExcelHelper.getCurrentDir() + "src/test/java/HangTester/nopCommerce/DataTest/Login.xlsx","Sheet1");
        return data;
    }

    @DataProvider(name = "data_provider_category_excel", parallel = true)
    public Object[][] dataCategoryFromExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data= excelHelper.getExcelData(ExcelHelper.getCurrentDir() + "src/test/java/HangTester/nopCommerce/DataTest/Category.xlsx","Add");
        return data;
    }

}
