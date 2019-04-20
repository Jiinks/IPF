package IPF_Ex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import IPF_Ex.helpers.WebElementH;

/**
 * CreateAnAccountPage
 */
public class CreateAnAccountPage {
    
    public static WebElementH FirstNameCustomerTextField(){
        return new WebElementH(By.cssSelector("#customer_firstname"));
    }

    public static WebElementH LastNameCustomerTextField(){
        return new WebElementH(By.cssSelector("#customer_lastname"));
    }

    public static WebElementH EmailCustomerTextField(){
        return new WebElementH(By.cssSelector("#email"));
    }

    public static WebElementH PasswordCustomerTextField(){
        return new WebElementH(By.cssSelector("#passwd"));
    }

    public static WebElementH FirstNameTextField(){
        return new WebElementH(By.cssSelector("#firstname"));
    }

    public static WebElementH LastNameTextField(){
        return new WebElementH(By.cssSelector("#lastname"));
    }

    public static WebElementH AddressLine1TextField(){
        return new WebElementH(By.cssSelector("#address1"));
    }

    public static WebElementH CompanyTextField(){
        return new WebElementH(By.cssSelector("#company"));
    }

    public static WebElementH CityTextField(){
        return new WebElementH(By.cssSelector("#city"));
    }

    public static WebElementH PostCodeTextField(){
        return new WebElementH(By.cssSelector("#postcode"));
    }

    public static WebElementH AdditionalInformation(){
        return new WebElementH(By.cssSelector("#other"));
    }

    public static WebElementH HomePhoneTextField(){
        return new WebElementH(By.cssSelector("#phone"));
    } 
    
    public static WebElementH MobilePhoneTextField(){
        return new WebElementH(By.cssSelector("#phone_mobile"));
    }

    public static WebElementH AddressAliasTextField(){
        return new WebElementH(By.cssSelector("#alias"));
    } 

    public static Select StateSelectList(){
        return new Select(new WebElementH(By.cssSelector("#id_state")));
    } 

    public static WebElementH Register(){
        return new WebElementH(By.cssSelector("#submitAccount"));
    }
    
    
}