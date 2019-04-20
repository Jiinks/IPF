package IPF_Ex.pages;

import org.openqa.selenium.By;

import IPF_Ex.helpers.WebElementH;

/**
 * MyAccountPage
 */
public class MyAccountPage {
    
    public static WebElementH AccountLink(){
        return new WebElementH(By.cssSelector(".account"));
    }
    
}