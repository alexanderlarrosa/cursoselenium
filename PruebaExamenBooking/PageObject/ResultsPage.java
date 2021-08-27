package PruebaExamenBooking.PageObject;

import PruebaExamenBooking.Helpers.Constans;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ResultsPage {

    //variables
    public WebDriver driver;
    String URL = "https://www.booking.com/";

    //Constructor
    public ResultsPage(WebDriver remoteDriver){
        this.driver=remoteDriver;
    }

    //Metodos

    public boolean validarBusqueda(String city){
        boolean esValido = false;
        WebElement inputSearch = driver.findElement(By.xpath("//*[@data-component='search/destination/input-placeholder']"));
        WebElement huespedesAdultos = driver.findElement(By.xpath("//*[@aria-label='Número de adultos']"));
        WebElement huespedesMenores = driver.findElement(By.xpath("//*[@aria-label='Número de niños']"));
        Select selectHuespedes = new Select(huespedesAdultos);
        WebElement selectHuespedElement = selectHuespedes.getFirstSelectedOption();
        String selectedHuesped = selectHuespedElement.getText();
        String inputCity = inputSearch.getAttribute("placeholder");
        String cantHuespedesAdultos = Constans.CANT_ADUTLOS+"";
        if(inputCity.contains(city)&&selectedHuesped.contains(cantHuespedesAdultos)){
            esValido=true;
        }
        return esValido;
    }
}
