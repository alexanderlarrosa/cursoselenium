package SimulacroExamen.PageObject;

import SimulacroExamen.Steps.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LandringPage {

    //Variables

    public WebDriver driver;
    public String URL = "https://es.airbnb.com/";
    public SearchResultsPage searchResultsPage;
    public ExperiencePage experiencePage;


    //Constructor

    public LandringPage(WebDriver remoteDriver){
        this.driver=remoteDriver;
        PageFactory.initElements(driver,this);
    }

    //Metodos

    public void initAirbnbPage(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        PageFactory.initElements(driver,this);
    }

    public SearchResultsPage ingresoBusqueda(String ciudad) throws InterruptedException {
        Thread.sleep(1000);
        inputPlace.sendKeys(ciudad);
        inputFechaLlegada.click();
        seleccionCalendario(Constants.FECHA_LLEGADA,Constants.FECHA_PARTIDA);
        inputHuespedes.click();

        for(int i=0; i<Constants.HUESPEDES_ADULTOS; i++){
            huespedesAdultos.click();
        }
        for(int i=0; i<Constants.HUESPEDES_MENORES; i++){
            huespedesMenores.click();
        }
        for(int i=0; i<Constants.HUESPEDES_BEBES; i++){
            huespedesBebes.click();
        }
        inputSearch.click();
        searchResultsPage = new SearchResultsPage(driver);
        return searchResultsPage;

    }

    public void seleccionCalendario(String fechaLlegada, String fechaPartida){
        String xpathFechaLlegada="//*[@data-testid='datepicker-day-"+fechaLlegada+"']";
        String xpathFechaPartida="//*[@data-testid='datepicker-day-"+fechaPartida+"']";
        WebElement calendarioLLegada=driver.findElement(By.xpath(xpathFechaLlegada));
        WebElement calendarioPartida=driver.findElement(By.xpath(xpathFechaPartida));
        calendarioLLegada.click();
        calendarioPartida.click();
    }

    public void ingresoBusquedaExperiencias(){
        experienciasPlaceInput.sendKeys(Constants.CITY);
        inputFecha.click();
        seleccionCalendario(Constants.FECHA_LLEGADA, Constants.FECHA_PARTIDA);
        searchButton.click();
    }

    public ExperiencePage ingresoEnExperiencias() throws InterruptedException {
        Thread.sleep(1000);
        WebElement experienciasButton = driver.findElement(By.id("search-block-tab-false-EXPERIENCES"));
        experienciasButton.click();
        Assert.assertTrue(experienciasButton.getAttribute("aria-selected").equals("true"));
        experiencePage=new ExperiencePage(driver);
        return experiencePage;
    }

    public void muestroLugaresCercanos(){
        WebElement lugaresCercanosElement = driver.findElement(By.xpath("//*[@style='--column-count:4;']"));
    }

    //Find By

    @FindBy(name = "query")
    WebElement inputPlace;

    @FindBy(xpath = "//*[@data-testid='structured-search-input-field-split-dates-0']")
    WebElement inputFechaLlegada;

    @FindBy(xpath = "//*[@data-testid='structured-search-input-field-guests-button']")
    WebElement inputHuespedes;

    @FindBy(xpath = "(//*[@aria-label='aumentar valor'])[1]")
    WebElement huespedesAdultos;

    @FindBy(xpath = "(//*[@aria-label='aumentar valor'])[2]")
    WebElement huespedesMenores;

    @FindBy(xpath = "(//*[@aria-label='aumentar valor'])[3]")
    WebElement huespedesBebes;

    @FindBy(xpath = "//*[@data-testid='structured-search-input-search-button']")
    WebElement inputSearch;

    @FindBy(xpath = "//*[@placeholder='¿A dónde viajas?']")
    WebElement experienciasPlaceInput;

    @FindBy(xpath = "//*[@data-testid='structured-search-input-field-dates-button']")
    WebElement inputFecha;

    @FindBy(xpath = "//*[@data-testid='structured-search-input-search-button']")
    WebElement searchButton;

    @FindBy(id = "search-block-tab-false-EXPERIENCES")
    WebElement experienciasButton;










}
