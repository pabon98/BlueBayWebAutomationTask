package testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.DriverSetUp;

import java.time.Duration;

public class TestLoginPage extends DriverSetUp {
    LoginPage loginPage = new LoginPage();

    @BeforeClass
    public void setupClass()  {
        loginPage.navigateToLoginPage();
    }
    @Test
    public void LoginWithValidCredentials(){
    loginPage.writeOneElement(loginPage.email_field_locator, loginPage.user_email);
    loginPage.writeOneElement(loginPage.password_field_locator, loginPage.user_password);
    loginPage.clickOneElement(loginPage.signIn_btn_locator);
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.textToBePresentInElementLocated(loginPage.welcome_user_name_locator, "Hello, Usman Mohammad!"));
//        System.out.println(loginPage.getElement(loginPage.welcome_user_name_locator).getText());
        Assert.assertEquals(loginPage.getElement(loginPage.welcome_user_name_locator).getText(),"Hello, Usman Mohammad!");
    }

}
