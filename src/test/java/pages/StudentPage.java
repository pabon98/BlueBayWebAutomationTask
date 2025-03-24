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
    public By edit_student_locator = By.xpath("//body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[10]/div[1]/button[2]/i[1]");
    public By edit_student_locator_title = By.xpath("//p[@class='section-title']");
    public By edit_student_consultant = By.xpath("//div[@id='consultantId']//div[@class='css-19bb58m']");
    public By edit_title = By.cssSelector("input[value='1'][name='nameTittleId']");
    public By edit_firstname = By.xpath("//input[@id='firstName']");
    public By edit_lastName = By.xpath("//input[@id='lastName']");
    public By edit_date_of_birth = By.xpath("//input[@id='dateOfBirth']");
    public By edit_date_picker_body = By.xpath("//div[@class='ant-picker-body']");
    public By edit_passportNumber = By.xpath("//input[@id='passportNumber']");
    public By edit_issue_date = By.xpath("//input[@id='issueDate']");
    public By edit_expire_date = By.xpath("//input[@id='expiresDate']");
    public By edit_gender = By.cssSelector("input[value='1'][name='genderId']");
    public By edit_marital_status = By.cssSelector("input[value='1'][name='maritalStatusId']");
    public By edit_phone_number = By.xpath("//input[@placeholder='1 (702) 123-4567']");
    public By edit_email = By.xpath("//input[@id='email']");
    public By edit_country_birth = By.xpath("//div[@id='countryOfBirthId']//div[@class='css-19bb58m']");
    public By edit_residence_country = By.cssSelector("div[id='countryOfCitizenship'] div[class='css-19bb58m']");
    public By edit_country_nationality = By.xpath("//div[@id='nationalityId']//div[@class='css-19bb58m']");
    public By save_and_next =By.xpath("//button[normalize-space()='Save and Next']");
    public By student_info_updated_toast = By.xpath("//div[@class='content-wrapper coustom-wrapper']");
    public By go_to_stu_page = By.xpath("//span[@class='text-white']");


    public void LoadStudentPage(){
      LoadAnWebPage(student_page_url);
    }
}
