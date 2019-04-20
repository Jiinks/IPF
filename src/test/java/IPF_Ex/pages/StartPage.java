package IPF_Ex.pages;

import org.openqa.selenium.By;
import IPF_Ex.driver.FireFox;
import IPF_Ex.helpers.WebElementH;

/**
 * StartPage
 */
public class StartPage {

    private final static String pageUrl = "http://automationpractice.com/index.php";

    public static void Go(){
        FireFox.GetDriver().get(pageUrl);
    }
    
    public static WebElementH LoginLink(){
        return new WebElementH(By.cssSelector(".login"));
    }
}