package pages;
import org.openqa.selenium.By;

public class ProviderPage extends BasePage{
    public String provider_page_url = "http://test.uapp.uk/providerList";
    public By provider_section_title = By.xpath("//p[@class='section-title']");
    public By add_provider_btn_locator = By.xpath("//button[normalize-space()='Add Provider']");
    public By provider_company_Name_locator = By.xpath("//input[@id='providerName']");
    public By provider_name_title = By.xpath("//div[@class='form-group']//div//input[1]");
    public By provider_firstName_locator = By.xpath("//input[@id='adminFirstName']");
    public By provider_last_name_locator = By.xpath("//input[@id='adminLastName']");
    public By provider_email_locator = By.xpath("//input[@id='email']");
    public By create_provider_locator = By.xpath("//button[normalize-space()='Create Provider']");
    public By error_company_msg = By.xpath("//span[normalize-space()='Company or institution name']");
    public By error_title_msg = By.xpath("//span[normalize-space()='Title is required']");
    public By error_first_name_msg = By.xpath("//span[normalize-space()='First Name is required']");
    public By error_last_name_msg = By.xpath("//span[normalize-space()='Last Name is required']");
    public By error_email_msg = By.xpath("//span[normalize-space()='Last Name is required']");
    public By invalid_email_msg = By.xpath("//span[normalize-space()='Email is not valid']");
    public By go_back_provider_list_locator = By.xpath("//span[@class='text-white']");







}
