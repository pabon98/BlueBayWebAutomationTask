package pages;
import org.openqa.selenium.By;

public class StudentPage extends BasePage{
    public String student_page_url = "http://test.uapp.uk/studentList";
    public By student_list_text_locator = By.xpath("//h5[normalize-space()='Student List']");
    public By add_student_locator = By.xpath("//button[@class='btn btn-primary']");
    public By create_student_account_locator = By.xpath("//p[@class='section-title']");
    public By student_consultant_selectBox = By.xpath("//div[@id='consultantId']//div[@class='css-19bb58m']");
    public By select_prefer_country_locator = By.xpath("//div[@id='universityCountryId']//div[@class='css-13cymwt-control']");
    public By first_name_locator = By.xpath("//input[@id='firstName']");
    public By last_name_locator = By.xpath("//input[@id='lastName']");
    public By email_locator = By.xpath("//input[@id='email']");
    public By create_student_Btn_locator = By.xpath("//button[@type='submit']");
    public By student_add_alert = By.xpath("//b[normalize-space()='Student added successfully']");
    public By student_complete_profile_locator = By.xpath("//button[normalize-space()='Complete Profile']");
    public By confirm_delete_btn_text = By.xpath("//b[normalize-space()='Do You Want To Delete This Student Information ?']");
    public By delete_student_btn_locator = By.xpath("//tbody/tr[1]/td[10]/div[1]/button[3]");
    public By confirm_delete_student_btn_locator = By.xpath("//button[@type='submit']");
    public By delete_student_toast_alert = By.xpath("//div[@id='navbar-mobile']");


    public void LoadStudentPage(){
      LoadAnWebPage(student_page_url);
    }
}
