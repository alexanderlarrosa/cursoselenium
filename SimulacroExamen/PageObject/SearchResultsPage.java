package SimulacroExamen.PageObject;

import SimulacroExamen.Steps.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    //Variables

    public WebDriver driver;

    //Constructor

    public SearchResultsPage(WebDriver remoteDriver){
        this.driver=remoteDriver;
        PageFactory.initElements(driver,this);
    }

    //Metodos

    public boolean validoInformacionViaje(String city){
        boolean esValido = false;
        String inputText = littleSearchInput.getText();
        int totalHuespedes = Constants.HUESPEDES_ADULTOS+Constants.HUESPEDES_MENORES+Constants.HUESPEDES_BEBES;
        String cantidadHuespedes = ""+totalHuespedes+" huéspedes";
        if(inputText.contains(city)&&inputText.contains(cantidadHuespedes)){
            esValido=true;
        }
        return esValido;
    }

    //Find By

    @FindBy(xpath = "//*[@data-testid='little-search']")
    WebElement littleSearchInput;

}
