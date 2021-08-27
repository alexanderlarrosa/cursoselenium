package PruebaExamenBooking.Steps;

import Ecommerce_site.Constants;
import PruebaExamenBooking.Helpers.Constans;
import PruebaExamenBooking.PageObject.LandingPage;
import PruebaExamenBooking.PageObject.ResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.image.RescaleOp;
import java.util.concurrent.TimeUnit;

public class BookingSteps {

    public WebDriver driver;
    public String URL ="https://www.booking.com/";
    public LandingPage landingPage;
    public ResultsPage resultsPage;

    @Given("Estoy en el sitio de booking")
    public void estoy_en_el_sitio_de_booking() {
        // Write code here that turns the phrase above into concrete actions
        landingPage = new LandingPage(driver);
        landingPage.initBooking();
    }

    @When("Ingreso la busqueda de Ciudad1")
    public void ingreso_la_busqueda_de_ciudad1() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        resultsPage=landingPage.ingresoBusqueda(Constans.CIUDAD);

    }

    @Then("Valido que la info de Ciudad1 sea correcta")
    public void valido_que_la_info_de_ciudad1_sea_correcta() {
        // Write code here that turns the phrase above into concrete actions
        boolean esValido = resultsPage.validarBusqueda(Constans.CIUDAD);
        Assert.assertTrue(esValido);
    }

    @When("Ingreso la busqueda de Ciudad2")
    public void ingreso_la_busqueda_de_ciudad2() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        resultsPage=landingPage.ingresoBusqueda(Constans.CIUDAD2);
    }

    @Then("Valido que la info de Ciudad2 sea correcta")
    public void valido_que_la_info_de_ciudad2_sea_correcta() {
        // Write code here that turns the phrase above into concrete actions
        boolean esValido = resultsPage.validarBusqueda(Constans.CIUDAD2);
        Assert.assertTrue(esValido);
    }

    @When("Ingreso la busqueda de Ciudad3")
    public void ingreso_la_busqueda_de_ciudad3() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        resultsPage=landingPage.ingresoBusqueda(Constans.CIUDAD3);
    }

    @Then("Valido que la info de Ciudad3 sea correcta")
    public void valido_que_la_info_de_ciudad3_sea_correcta() {
        // Write code here that turns the phrase above into concrete actions
        boolean esValido = resultsPage.validarBusqueda(Constans.CIUDAD3);
        Assert.assertTrue(esValido);
    }

    @When("Ingreso la busqueda de atracciones turistimas")
    public void ingreso_la_busqueda_de_atracciones_turistimas() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        ingresoEnAtracciones();
    }

    @Then("Valido que la informacion sea correcta")
    public void valido_que_la_informacion_sea_correcta() {
        // Write code here that turns the phrase above into concrete actions
        boolean esValido = validoAtracciones();
        Assert.assertTrue(esValido);
    }





    public void ingresoEnAtracciones() throws InterruptedException {
        WebElement experienciasBtn = driver.findElement(By.linkText("Atracciones turísticas"));
        experienciasBtn.click();
        WebElement inputSearch = driver.findElement(By.xpath("//*[@data-testid='search-input-field']"));
        inputSearch.sendKeys(Constans.CIUDAD);
        Thread.sleep(1000);
        WebElement searchBtn = driver.findElement(By.xpath("//*[@type='submit']"));
        searchBtn.click();
    }

    public boolean validoAtracciones(){
        boolean esValido=false;
        WebElement atracciones = driver.findElement(By.xpath("//*[@data-testid='card']"));
        if(atracciones.getText().contains(Constans.CIUDAD)){
            esValido=true;
        }
        return esValido;
    }

}
