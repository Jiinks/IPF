package IPF_Ex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import IPF_Ex.driver.FireFox;
import IPF_Ex.helpers.TestDataGenerator;
import IPF_Ex.pages.AuthenticationPage;
import IPF_Ex.pages.CreateAnAccountPage;
import IPF_Ex.pages.MyAccountPage;
import IPF_Ex.pages.StartPage;


/**
 * TestSuite1
 */

public class TestSuite1
{
    private static String FirstName;
    private static String LastName;
    private static String UserEmail;
    private static String UserPassword;
    
    @BeforeClass
    public static void BeforeTestSuit(){
        FirstName = TestDataGenerator.GetFirstName();
        LastName = TestDataGenerator.GetLastName();
        UserPassword = TestDataGenerator.GetRandomString();
        UserEmail = TestDataGenerator.GetEmail();
    }

    @BeforeMethod
    public void BeforeTest(){
        FireFox.CreateDriver();                
    }
    
    @Test(groups = "CreateAccount")
    public void CreateNewAccount()
    {
        StartPage.Go();
        StartPage.LoginLink().click();
        
        AuthenticationPage.EmailCreateTextField().enterText(UserEmail);
        AuthenticationPage.CreateAccountLink().click();
        
        CreateAnAccountPage.FirstNameCustomerTextField().enterText(FirstName);
        CreateAnAccountPage.LastNameCustomerTextField().enterText(LastName);
        CreateAnAccountPage.PasswordCustomerTextField().enterText(UserPassword);
        CreateAnAccountPage.AddressLine1TextField().enterText(TestDataGenerator.GetRandomString());
        CreateAnAccountPage.CityTextField().enterText(TestDataGenerator.GetRandomString());
        CreateAnAccountPage.PostCodeTextField().enterText(TestDataGenerator.GetPostCode());
        CreateAnAccountPage.MobilePhoneTextField().enterText(TestDataGenerator.GetMobilePhoneNumber());
        CreateAnAccountPage.AddressAliasTextField().enterText(TestDataGenerator.GetRandomString());
        CreateAnAccountPage.StateSelectList().selectByIndex(1);
        CreateAnAccountPage.Register().click();

        assertEquals(FirstName + " " + LastName, MyAccountPage.AccountLink().getText());
    }

    
    @Test(dependsOnGroups = "CreateAccount")
    public void CreateAccountWithSameData()
    {
        StartPage.Go();
        StartPage.LoginLink().click();
        
        AuthenticationPage.EmailCreateTextField().enterText(UserEmail);
        AuthenticationPage.CreateAccountLink().click();   
        AuthenticationPage.ErrorMsgElement().isDisplayed(); 
        
        assertTrue(AuthenticationPage.ErrorMsgElement().getText().contains("An account using this email address has already been registered"));
    }

    @Test(dependsOnGroups = "CreateAccount")
    public void LogInWithCreatedAccount()
    {
        StartPage.Go();
        StartPage.LoginLink().click();
        
        AuthenticationPage.EmailLoginTextField().enterText(UserEmail);
        AuthenticationPage.PasswordLoginTextField().enterText(UserPassword);
        AuthenticationPage.SignIntLink().click();   

        assertEquals(FirstName + " " + LastName, MyAccountPage.AccountLink().getText());
    }

    @Test(dependsOnGroups = "CreateAccount")
    public void FailingTest()
    {
        StartPage.Go();
        StartPage.LoginLink().click();
        
        AuthenticationPage.EmailCreateTextField().enterText(UserEmail); 
        AuthenticationPage.ErrorMsgElement().isDisplayed(); 
    }

    @AfterMethod
    public void AfterTest(){
        FireFox.DisposeDriver();
    }
}
