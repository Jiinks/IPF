package IPF_Ex.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * FireFoxDriverCreator
 */
public class FireFox {
    private static WebDriver driver;
    private final static int TimeOut = 10;
    
    public static void CreateDriver(){        
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\java\\IPF_Ex\\dependencies\\geckodriver.exe"); 
        driver =  new FirefoxDriver();  
        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);	
    }  
    
    public static WebDriver GetDriver(){
        return driver;
    } 

    public static void DisposeDriver(){
        driver.close();
    }
}