package IPF_Ex.pages;

import org.openqa.selenium.By;
import IPF_Ex.helpers.WebElementH;

/**
 * AuthenticationPage
 */
public class AuthenticationPage {

    public static WebElementH EmailCreateTextField(){
        return new WebElementH(By.cssSelector("#email_create"));
    }
    
    public static WebElementH CreateAccountLink(){
        return new WebElementH(By.cssSelector("#SubmitCreate"));
    }
    
    public static WebElementH EmailLoginTextField(){
        return new WebElementH(By.cssSelector("#email"));
    }

    public static WebElementH PasswordLoginTextField(){
        return new WebElementH(By.cssSelector("#passwd"));
    }
    
    public static WebElementH SignIntLink(){
        return new WebElementH(By.cssSelector("#SubmitLogin"));
    }

    public static WebElementH ErrorMsgElement(){
        return new WebElementH(By.cssSelector("#create_account_error ol"));
    }    
}