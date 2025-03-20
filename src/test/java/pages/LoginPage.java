package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    public String login_url = "http://test.uapp.uk/";
    public String user_email = "yadiga1784@adosnan.com";
    public String user_password = "Sqa1212";
    public By email_field_locator = By.xpath("//input[@placeholder='Email Address']");
    public By password_field_locator = By.xpath("//input[@placeholder='Password']");
    public By signIn_btn_locator = By.xpath("//button[normalize-space()='Sign In']");
    public By welcome_user_name_locator = By.xpath("//span[@class='std-dashboard-style1']");

   public void navigateToLoginPage(){
     LoadAnWebPage(login_url);
   }
}
