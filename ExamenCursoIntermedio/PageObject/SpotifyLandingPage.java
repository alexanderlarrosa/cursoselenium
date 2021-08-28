package ExamenCursoIntermedio.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpotifyLandingPage {

    //Variables

    public WebDriver driver;
    public String URL = "https://www.spotify.com/uy/signup/";


    //Constructor

    public SpotifyLandingPage(WebDriver remoteDriver){
        this.driver=remoteDriver;
        PageFactory.initElements(driver,this);
    }

    //Metodos

    public void initSpotifyPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        PageFactory.initElements(driver,this);
    }

    public boolean validadPlan(String unPlan){
        boolean esValido=false;
        List<WebElement> h3s = driver.findElements(By.tagName("h3"));
        for(WebElement e:h3s){
            if(e.getText().equals("Individual")){
                esValido=true;
            }
        }
        return esValido;
    }

    public void ingresoEnPremium(){
        driver.navigate().to("https://www.spotify.com/uy/premium/");

    }

    public SpotifyLoginPage ingresoEnLoginPage(){
        SpotifyLoginPage loginPage = new SpotifyLoginPage(driver);
        return loginPage;
    }

    public SpotifyAgreementPage ingresoEnAgreementPage(){
        driver.navigate().to("https://www.spotify.com/uy/legal/end-user-agreement/");
        SpotifyAgreementPage agreementPage = new SpotifyAgreementPage(driver);
        return agreementPage;
    }
}
