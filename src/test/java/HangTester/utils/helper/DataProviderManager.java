package HangTester.utils.helper;

import org.testng.annotations.DataProvider;

public class DataProviderManager {

    //LOGIN
    @DataProvider(name = "data_provider_loginAdmin_excel", parallel = false)
    public Object[][] dataLoginAdminFromExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data;
        data = excelHelper.getExcelData(ExcelHelper.getCurrentDir() + "src/test/java/HangTester/nopCommerce/DataTest/Login.xlsx","login");
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

    //MANUFACTURE
         //ADD
        @DataProvider(name = "data_provider_manufactureAdd_excel", parallel = true)
        public Object[][] dataManufactureAddFromExcel() {
            ExcelHelper excelHelper = new ExcelHelper();
            Object[][] data= excelHelper.getExcelData(ExcelHelper.getCurrentDir() + "src/test/java/HangTester/nopCommerce/DataTest/Manufactures.xlsx","Add");
            return data;
        }

        //EDIT
        @DataProvider(name = "data_provider_manufactureEdit_excel", parallel = true)
        public Object[][] dataManufactureEditFromExcel() {
         ExcelHelper excelHelper = new ExcelHelper();
            Object[][] data= excelHelper.getExcelData(ExcelHelper.getCurrentDir() + "src/test/java/HangTester/nopCommerce/DataTest/Manufactures.xlsx","Edit");
            return data;
        }

         //DELETE
        @DataProvider(name = "data_provider_manufactureDel_excel", parallel = true)
        public Object[][] dataManufactureDeleteFromExcel() {
            ExcelHelper excelHelper = new ExcelHelper();
         Object[][] data= excelHelper.getExcelData(ExcelHelper.getCurrentDir() + "src/test/java/HangTester/nopCommerce/DataTest/Manufactures.xlsx","Delete");
         return data;
        }

    //PRODUCT
    //ADD
    @DataProvider(name = "data_provider_productAdd_excel", parallel = true)
    public Object[][] dataProductAddFromExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data= excelHelper.getExcelData(ExcelHelper.getCurrentDir() + "src/test/java/HangTester/nopCommerce/DataTest/Product.xlsx","Add");
        return data;
    }

    //EDIT
    @DataProvider(name = "data_provider_productEdit_excel", parallel = true)
    public Object[][] dataProductEditFromExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data= excelHelper.getExcelData(ExcelHelper.getCurrentDir() + "src/test/java/HangTester/nopCommerce/DataTest/Product.xlsx","Edit");
        return data;
    }

    //DELETE
    @DataProvider(name = "data_provider_productDel_excel", parallel = true)
    public Object[][] dataProductDeleteFromExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data= excelHelper.getExcelData(ExcelHelper.getCurrentDir() + "src/test/java/HangTester/nopCommerce/DataTest/Product.xlsx","Delete");
        return data;
    }
}
