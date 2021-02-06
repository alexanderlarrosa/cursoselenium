package Examen;

import Practico13.FacebookTest;
import org.testng.annotations.Factory;

public class NetflixFactory {

    @Factory
    public Object[] facebookFactoryTest(){
        return new Object[]{
                new prueba_netflix(),
                new prueba_netflix(),
        };
    }
}
