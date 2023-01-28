package HangTester.utils.helper;

import org.testng.annotations.DataProvider;

public class DataProviderManager {

    //LOGIN
    @DataProvider(name = "data_provider_loginAdmin_excel", parallel = true)
    public Object[][] dataLoginAdminFromExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data= excelHelper.getExcelData(ExcelHelper.getCurrentDir() + "src/test/java/HangTester/nopCommerce/DataTest/Login.xlsx","Sheet1");
        return data;
    }

    //CATEGORY
        //ADD
    @DataProvider(name = "data_provider_categoryAdd_excel", parallel = true)
    public Object[][] dataCategoryAddFromExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data= excelHelper.getExcelData(ExcelHelper.getCurrentDir() + "src/test/java/HangTester/nopCommerce/DataTest/Category.xlsx","Add");
        return data;
    }

        //EDIT
        @DataProvider(name = "data_provider_categoryEdit_excel", parallel = true)
        public Object[][] dataCategoryEditFromExcel() {
            ExcelHelper excelHelper = new ExcelHelper();
            Object[][] data= excelHelper.getExcelData(ExcelHelper.getCurrentDir() + "src/test/java/HangTester/nopCommerce/DataTest/Category.xlsx","Edit");
            return data;
        }

        //DELETE
        @DataProvider(name = "data_provider_categoryDel_excel", parallel = true)
        public Object[][] dataCategoryDeleteFromExcel() {
            ExcelHelper excelHelper = new ExcelHelper();
            Object[][] data= excelHelper.getExcelData(ExcelHelper.getCurrentDir() + "src/test/java/HangTester/nopCommerce/DataTest/Category.xlsx","Delete");
            return data;
        }

}
