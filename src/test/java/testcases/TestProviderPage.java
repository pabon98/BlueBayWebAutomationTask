package testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProviderPage;
import utilities.DriverSetUp;
import java.time.Duration;

public class TestProviderPage extends DriverSetUp {
    ProviderPage providerPage = new ProviderPage();
   @Test
    public void GotoAddProviderPage(){
     providerPage.LoadAnWebPage(providerPage.provider_page_url);
     providerPage.clickOneElement(providerPage.add_provider_btn_locator);
     WebDriverWait providerWait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
       providerWait.until(ExpectedConditions.textToBePresentInElementLocated(providerPage.provider_section_title, "Provider Informations"));

   }
   @Test
    public void CreateProviderWithEmptyData(){
       providerPage.writeOneElement(providerPage.provider_company_Name_locator, "");
       providerPage.clickOneElement(providerPage.provider_name_title);
       providerPage.writeOneElement(providerPage.provider_firstName_locator, "");
       providerPage.writeOneElement(providerPage.provider_last_name_locator, "");
       providerPage.writeOneElement(providerPage.provider_email_locator, "");

       providerPage.clickOneElement(providerPage.create_provider_locator);


       Assert.assertTrue(providerPage.getElement(providerPage.error_company_msg).isDisplayed());
       Assert.assertTrue(providerPage.getElement(providerPage.error_title_msg).isDisplayed());
       Assert.assertTrue(providerPage.getElement(providerPage.error_first_name_msg).isDisplayed());
       Assert.assertTrue(providerPage.getElement(providerPage.error_last_name_msg).isDisplayed());
       Assert.assertTrue(providerPage.getElement(providerPage.error_email_msg).isDisplayed());


   }
   @Test
    public void CreateProviderWithInvalidEmail(){
       providerPage.writeOneElement(providerPage.provider_company_Name_locator, "ABC");
       providerPage.clickOneElement(providerPage.provider_name_title);
       providerPage.writeOneElement(providerPage.provider_firstName_locator, "123");
       providerPage.writeOneElement(providerPage.provider_last_name_locator, "456");
       providerPage.writeOneElement(providerPage.provider_email_locator, "1--+1231@mail.com");
       providerPage.clickOneElement(providerPage.create_provider_locator);

       Assert.assertTrue(providerPage.getElement(providerPage.invalid_email_msg).isDisplayed(), "Email is not valid");

   }
    @Test
    public void createProviderWithValidData(){
        providerPage.writeOneElement(providerPage.provider_company_Name_locator, "Basundhara Group");
        providerPage.clickOneElement(providerPage.provider_name_title);
        providerPage.writeOneElement(providerPage.provider_firstName_locator, "Mohammad");
        providerPage.writeOneElement(providerPage.provider_last_name_locator, "Rasel Hossain");
        providerPage.writeOneElement(providerPage.provider_email_locator, "rasel123@mail.com");
        providerPage.clickOneElement(providerPage.create_provider_locator);
//        providerPage.clickOneElement(providerPage.go_back_provider_list_locator);

    }
}


