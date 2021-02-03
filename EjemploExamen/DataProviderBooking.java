package EjemploExamen;

import org.testng.annotations.DataProvider;

public class DataProviderBooking {

    @DataProvider(name="correos")
    public Object[][] mail(){
        return new Object[][]{
                {"testing"},
                {"ejempl.com"},
                {"@gmail.com"}
        };
    }

}
