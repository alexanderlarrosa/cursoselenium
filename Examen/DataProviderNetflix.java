package Examen;

import org.testng.annotations.DataProvider;

public class DataProviderNetflix {

    @DataProvider(name="emails")
    public Object[][] mail(){
        return new Object[][]{
                {"ejemplotest@gmail.com"},
                {"cuenta@gmail.com"},
                {"pruebaexamen@gmail.com"}
        };
    }
}
