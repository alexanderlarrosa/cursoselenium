package Examen;

import EjemploExamen2.Runners.DataProviderBooking;
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

public class prueba_netflix {
    //Variables

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test (priority=6)
    public void validarTituloTest(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Netflix Uruguay: Ve series online, ve películas online");
    }

    @Test (priority=5)
    public void iniciarSesionPageTest(){
        driver.findElement(By.linkText("Iniciar sesión")).click();
        boolean cambioTitulo=true;
        boolean estaH1 = false;
        boolean loginFacebook=false;
        if(driver.getTitle().equals("Netflix Uruguay: Ve series online, ve películas online")){
           cambioTitulo=false;
        }
        Assert.assertTrue(cambioTitulo);
        List<WebElement> listaH1 = driver.findElements(By.tagName("h1"));
        for(WebElement h1:listaH1){
            if(h1.getText().equals("Inicia sesión")){
                estaH1=true;
            }
        }
        Assert.assertTrue(estaH1);
        if(driver.findElement(By.xpath("//span[@class='fbBtnText']")).getText().equals("Iniciar sesión con Facebook")){
            loginFacebook=true;
        }
        Assert.assertTrue(loginFacebook);
    }

    @Test (priority=4)
    public void loginToNetflixErrorTest(){
        boolean errorInput=false;
        driver.findElement(By.linkText("Iniciar sesión")).click();
        driver.findElement(By.id("id_userLoginId")).sendKeys("test@test.com");
        driver.findElement(By.id("id_password")).sendKeys("holamundo");
        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();
        System.out.println(checkBox);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        List<WebElement> listaErrores = driver.findElements(By.className("inputError"));
        for(WebElement error:listaErrores){
            if(error.getText().equals("Contraseña incorrecta")){
                errorInput=true;
            }
        }
        Assert.assertTrue(errorInput);
        Assert.assertTrue(checkBox.isSelected());
    }

    @Test (priority=3)
    public void fakeEmailTest() throws InterruptedException {
        Faker faker = new Faker();
        driver.findElement(By.name("email")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("signup"));
    }

    @Test (dataProvider = "emails", dataProviderClass = DataProviderNetflix.class, priority = 2)
    public void dataProviderEmailTest(String email){
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test (priority=1)
    public void printTagsTest(String tagName){
        List<WebElement> listaTagName = driver.findElements(By.tagName(tagName));
        if(listaTagName.size()>0){
            System.out.println("Se muestra la lista de elementos "+tagName);
            for(WebElement elemento: listaTagName){
                System.out.println(elemento.getText());
            }
        }else{
            System.out.println("No sea han encontrado elementos "+tagName);
        }
    }

    @AfterMethod
    public void close(){
        driver.close();
    }

}
