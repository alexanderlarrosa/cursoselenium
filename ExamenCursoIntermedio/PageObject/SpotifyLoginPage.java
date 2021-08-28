package ExamenCursoIntermedio.PageObject;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class SpotifyLoginPage {

    //Variables

    public WebDriver driver;
    public String URL = "https://www.spotify.com/uy/signup/";
    public Faker faker;


    //Constructor

    public SpotifyLoginPage(WebDriver remoteDriver){
        this.driver=remoteDriver;
        PageFactory.initElements(driver,this);
    }

    //Metodos

    public void completoFurmularioRegistro(String unEmail){

        WebElement email = driver.findElement(By.id("email"));
        WebElement confirmEmail = driver.findElement(By.id("confirm"));
        email.sendKeys(unEmail);
        confirmEmail.sendKeys(unEmail);

    }

    public boolean validoErrorEmail(String error) throws InterruptedException {
        boolean esValido=false;
        //El campo de emial es el primero, por eso busco el primer error, sino buscaria una lista de errores
        Thread.sleep(1000);
        WebElement errorLabel = driver.findElement(By.xpath("//*[@aria-label='Indicador de error']"));
        if(errorLabel.getText().equals(error)){
            esValido=true;
        }
        return esValido;
    }
}
