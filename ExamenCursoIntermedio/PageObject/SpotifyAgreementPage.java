package ExamenCursoIntermedio.PageObject;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SpotifyAgreementPage {

    //Variables

    public WebDriver driver;
    public String URL = "https://www.spotify.com/uy/signup/";
    public Faker faker;


    //Constructor

    public SpotifyAgreementPage(WebDriver remoteDriver){
        this.driver=remoteDriver;
        PageFactory.initElements(driver,this);
    }

    //Metodos

    public boolean validoLink(String link){
        boolean esValido=false;
        List<WebElement> listaLinks = driver.findElements(By.tagName("a"));
        for(WebElement e: listaLinks){
            if(e.getText().equals(link)){
                esValido=true;
            }
        }
        return esValido;
    }

}
