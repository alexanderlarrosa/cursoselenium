package SimulacroExamen.PageObject;

import SimulacroExamen.Steps.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExperiencePage {

    //Variables

    public WebDriver driver;
    public SearchResultsPage searchResultsPage;

    //Constructor

    public ExperiencePage(WebDriver remoteDriver){
        this.driver=remoteDriver;
        PageFactory.initElements(driver,this);
    }

    //Metodos

    public boolean validoFechasLugar() throws InterruptedException {
        boolean esValido=false;
        //WebElement littleSearchInput = driver.findElement(By.xpath("//*[@data-testid='little-search']"));
        Thread.sleep(1000);
        if(littleSearchInput.getText().contains(Constants.CITY)){
            esValido=true;
        }
        return esValido;
    }

    //Find By

    @FindBy(xpath = "//*[@data-testid='little-search']")
    WebElement littleSearchInput;
}
