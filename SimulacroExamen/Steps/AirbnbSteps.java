package SimulacroExamen.Steps;

import SimulacroExamen.PageObject.ExperiencePage;
import SimulacroExamen.PageObject.LandringPage;
import SimulacroExamen.PageObject.SearchResultsPage;
import SimulacroExamen.Steps.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AirbnbSteps {

    //Variables

    public WebDriver driver;
    public LandringPage landringPage;
    public SearchResultsPage searchResultsPage;
    public ExperiencePage experiencePage;

    @Given("Estoy en el sitio de airbnb")
    public void estoy_en_el_sitio_de_airbnb() {
        // Write code here that turns the phrase above into concrete actions
        landringPage=new LandringPage(driver);
        landringPage.initAirbnbPage();
    }

    @When("Ingreso los datos de busqueda de Ciudad1")
    public void ingreso_los_datos_de_busqueda_de_ciudad1() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        searchResultsPage=landringPage.ingresoBusqueda(Constants.CITY);


    }

    @Then("Valido que la informacion de Ciudad1 sea correcta")
    public void valido_que_la_informacion_de_ciudad1_sea_correcta() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(searchResultsPage.validoInformacionViaje(Constants.CITY));
    }

    @When("Ingreso los datos de busqueda de Ciudad2")
    public void ingreso_los_datos_de_busqueda_de_ciudad2() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        searchResultsPage=landringPage.ingresoBusqueda(Constants.CITY2);
    }

    @Then("Valido que la informacion de Ciudad2 sea correcta")
    public void valido_que_la_informacion_de_ciudad2_sea_correcta() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(searchResultsPage.validoInformacionViaje(Constants.CITY2));
    }

    @When("Ingreso los datos de busqueda de Ciudad3")
    public void ingreso_los_datos_de_busqueda_de_ciudad3() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        searchResultsPage=landringPage.ingresoBusqueda(Constants.CITY3);
    }

    @Then("Valido que la informacion de Ciudad3 sea correcta")
    public void valido_que_la_informacion_de_ciudad3_sea_correcta() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(searchResultsPage.validoInformacionViaje(Constants.CITY3));
    }

    @When("Ingreso en experiencias")
    public void ingreso_en_experiencias() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        landringPage.ingresoEnExperiencias();


    }


    @When("Ingreso los datos de busqueda de experiencia")
    public void ingreso_los_datos_de_busqueda_de_experiencia() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        experiencePage = landringPage.ingresoEnExperiencias();
        landringPage.ingresoBusquedaExperiencias();

    }

    @Then("Valido que luegar y fechas sean correctos")
    public void valido_que_luegar_y_fechas_sean_correctos() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(experiencePage.validoFechasLugar());

    }

    @Then("Muestro lista lugares cercanos")
    public void muestro_lista_lugares_cercanos() {
        // Write code here that turns the phrase above into concrete actions
        landringPage.muestroLugaresCercanos();
    }








}
