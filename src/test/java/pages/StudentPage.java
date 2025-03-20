package pages;

import org.openqa.selenium.By;

public class StudentPage extends BasePage{
    public String student_page_url = "http://test.uapp.uk/studentList";
    public By student_list_text_locator = By.xpath("//h5[normalize-space()='Student List']");
    public By add_student_locator = By.xpath("//button[@class='btn btn-primary']");
    public By create_student_account_locator = By.xpath("//p[@class='section-title']");

    public void LoadStudentPage(){
      LoadAnWebPage(student_page_url);
    }
}
