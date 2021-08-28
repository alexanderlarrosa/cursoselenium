package ExamenCursoIntermedio.Steps;

import ExamenCursoIntermedio.Helpers.Constants;
import ExamenCursoIntermedio.PageObject.SpotifyAgreementPage;
import ExamenCursoIntermedio.PageObject.SpotifyLandingPage;
import ExamenCursoIntermedio.PageObject.SpotifyLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SpotifySteps {

    //Variables

    public WebDriver driver;
    public SpotifyLandingPage landingPage;
    public SpotifyLoginPage loginPage;
    public SpotifyAgreementPage agreementPage;

    @Given("Estoy en el sitio de Spotify")
    public void estoy_en_el_sitio_de_spotify() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        landingPage=new SpotifyLandingPage(driver);
        landingPage.initSpotifyPage();
    }

    @When("Ingreso en la seccion premium")
    public void ingreso_en_la_seccion_premium() {
        // Write code here that turns the phrase above into concrete actions
        landingPage.ingresoEnPremium();
    }

    @Then("Veo el plan premium Individual")
    public void veo_el_plan_premium_individual() {
        // Write code here that turns the phrase above into concrete actions
        boolean esValido = landingPage.validadPlan("Individual");
        Assert.assertTrue(esValido);

    }

    @Then("Veo el plan premium Duo")
    public void veo_el_plan_premium_duo() {
        // Write code here that turns the phrase above into concrete actions
        boolean esValido = landingPage.validadPlan("Duo");
        Assert.assertTrue(esValido);
    }

    @Then("Veo el plan premium Familiar")
    public void veo_el_plan_premium_familiar() {
        // Write code here that turns the phrase above into concrete actions
        boolean esValido = landingPage.validadPlan("Familiar");
        Assert.assertTrue(esValido);
    }

    @Given("Ingreso en Login Page")
    public void ingreso_en_login_page() {
        // Write code here that turns the phrase above into concrete actions
        loginPage = landingPage.ingresoEnLoginPage();
    }


    @Then("Ingreso el email InvalidEmail1 y valido error")
    public void ingreso_el_email_invalid_email1_y_valido_error() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        loginPage.completoFurmularioRegistro(Constants.EMAIL1);
        boolean esValido=loginPage.validoErrorEmail(Constants.ERROR1);
        Assert.assertTrue(esValido);
    }

    @Then("Ingreso el email InvalidEmail2 y valido error")
    public void ingreso_el_email_invalid_email2_y_valido_error() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        loginPage.completoFurmularioRegistro(Constants.EMAIL2);
        boolean esValido=loginPage.validoErrorEmail(Constants.ERROR2);
        Assert.assertTrue(esValido);
    }

    @Then("Ingreso el email InvalidEmail3 y valido error")
    public void ingreso_el_email_invalid_email3_y_valido_error() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        loginPage.completoFurmularioRegistro(Constants.EMAIL3);
        boolean esValido=loginPage.validoErrorEmail(Constants.ERROR3);
        Assert.assertTrue(esValido);
    }

    @When("Ingreso en user agreement page")
    public void ingreso_en_user_agreement_page() {
        // Write code here that turns the phrase above into concrete actions
        agreementPage=landingPage.ingresoEnAgreementPage();
    }

    @Then("Valido el link Link1")
    public void valido_el_link_link1() {
        // Write code here that turns the phrase above into concrete actions
        boolean esValido=agreementPage.validoLink(Constants.LINK1);
        Assert.assertTrue(esValido);
    }

    @Then("Valido el link Link2")
    public void valido_el_link_link2() {
        // Write code here that turns the phrase above into concrete actions
        boolean esValido=agreementPage.validoLink(Constants.LINK2);
        Assert.assertTrue(esValido);
    }

    @Then("Valido el link Link3")
    public void valido_el_link_link3() {
        // Write code here that turns the phrase above into concrete actions
        boolean esValido=agreementPage.validoLink(Constants.LINK2);
        Assert.assertTrue(esValido);
    }





}
