package PruebaExamenBooking.PageObject;

import PruebaExamenBooking.Helpers.Constans;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class LandingPage {

    //variables
    public WebDriver driver;
    String URL = "https://www.booking.com/";
    public ResultsPage resultsPage;

    //Constructor
    public LandingPage(WebDriver remoteDriver){
        this.driver=remoteDriver;
    }

    //Metodos

    public void initBooking(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        PageFactory.initElements(driver,this);
    }

    public ResultsPage ingresoBusqueda(String ciudad) throws InterruptedException {
        WebElement inputCiudad = driver.findElement(By.id("ss"));
        inputCiudad.sendKeys(ciudad);
        WebElement inputFechaIngreso = driver.findElement(By.xpath("//*[@data-calendar2-type='checkin']"));
        inputFechaIngreso.click();
        WebElement fechaIngreso = driver.findElement(By.xpath("//*[@data-date='2021-09-14']"));
        fechaIngreso.click();
        WebElement fechaSalida = driver.findElement(By.xpath("//*[@data-date='2021-09-24']"));
        fechaSalida.click();
        WebElement inputHuespedes = driver.findElement(By.xpath("//*[@data-component='search/group/group-with-modal']"));
        inputHuespedes.click();
        WebElement huespedesAdultos = driver.findElement(By.xpath("//*[@aria-label='Aumenta el número de Adultos']"));
        WebElement reduceHuespedesAdultos = driver.findElement(By.xpath("//*[@aria-label='Reduce el número de Adultos']"));
        WebElement huespedesMenores = driver.findElement(By.xpath("//*[@aria-label='Aumenta el número de Niños']"));
        WebElement cantHabitaciones = driver.findElement(By.xpath("//*[@aria-label='Aumenta el número de Habitaciones']"));
        if(Constans.CANT_ADUTLOS>2){
            for(int i=0; i<Constans.CANT_ADUTLOS-2; i++){
                huespedesAdultos.click();
            }
        }
        if(Constans.CANT_ADUTLOS==1){
            reduceHuespedesAdultos.click();
        }
        for(int i=0; i<Constans.CANT_MENORES; i++){
            huespedesMenores.click();
        }
        //Thread.sleep(1000);
        WebElement edadMenoresSelector = driver.findElement(By.xpath("//*[@name='age']"));
        Select selectAge = new Select(edadMenoresSelector);
        selectAge.selectByValue("4");
        WebElement searchBtn = driver.findElement(By.xpath("//button[@data-sb-id='main']"));
        searchBtn.click();
        resultsPage=new ResultsPage(driver);
        return resultsPage;
    }


}
