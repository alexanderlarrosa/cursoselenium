package EjemploExamen;

import Practico14.DataProviderFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PruebaBooking {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.booking.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void validarTituloTest(){
        String titulo = driver.getTitle();
        Assert.assertEquals(titulo,"Booking.com | Web oficial | Los mejores hoteles y alojamientos");
    }

     @Test
    public void mostarLinksTest(){
        List<WebElement> listaLinks = driver.findElements(By.tagName("a"));
         System.out.println("<---- Listado de links ---->");
        for(WebElement link:listaLinks){
            System.out.println(link.getText());
        }
     }

     @Test
    public void mostarH1sTest(){
        List<WebElement> listaH1s = driver.findElements(By.tagName("H1"));
        if(listaH1s.size()>0){
             System.out.println("<---- Listado de H1s ---->");
             for(WebElement h1: listaH1s){
                 System.out.println(h1.getText());
             }
        }else{
            System.out.println("No se han encontrado elementos H1");
        }

     }

     @Test
    public void buscarGenteViajeraTest(){
        List<WebElement> listaH2s = driver.findElements(By.tagName("H2"));
        boolean encontadoH2 = false;
        for(WebElement h2:listaH2s){
            if(h2.getText().equals("Conecta con gente viajera")){
                encontadoH2=true;
            }
        }
        Assert.assertTrue(encontadoH2);
     }

     @Test
    public void registroUsuarioTests(){
        driver.findElement(By.linkText("Inicia sesión")).click();
        Faker faker = new Faker();
        driver.findElement(By.id("username")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div/div/form/div[3]/button/span")).click();
        driver.findElement(By.name("new_password")).sendKeys(faker.internet().password());
        driver.findElement(By.name("confirmed_password")).sendKeys(faker.internet().password());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div/div/form/button/span")).click();
        List<WebElement> listErrores = driver.findElements(By.className("bui-form__error"));
        Boolean errorPass = false;
        for(WebElement error:listErrores){
            System.out.println("Error es "+error.getText());
            if(error.getText().equals("Las contraseñas no coinciden. Inténtalo de nuevo.")){
                errorPass=true;
            }
        }
        Assert.assertTrue(errorPass);
      }

      @Test
    public void crearCuentaTest() throws InterruptedException {
        driver.findElement(By.linkText("Hazte una cuenta")).click();
        driver.findElement(By.id("username")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        boolean titulo=false;
        Thread.sleep(1000);
        List<WebElement> listah1 = driver.findElements(By.tagName("H1"));
        for(WebElement h1: listah1){
            if(h1.getText().equals("Introduce tu contraseña")){
                titulo=true;
            }
        }
        Assert.assertTrue(titulo);
      }

    @Test (dataProvider = "correos", dataProviderClass = DataProviderBooking.class)
    public void testEmails(String mail){
        driver.findElement(By.linkText("Inicia sesión")).click();
        driver.findElement(By.id("username")).sendKeys(mail);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement errorEmail = driver.findElement(By.id("username-description"));
        Assert.assertEquals(errorEmail.getText(),"Comprueba si el e-mail que has introducido es correcto");



    }

    @AfterMethod
    public void close(){
        driver.close();
    }


}
