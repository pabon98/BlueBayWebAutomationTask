package testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.StudentPage;
import utilities.DriverSetUp;

import java.time.Duration;

public class TestStudentPage extends DriverSetUp {
    StudentPage studentPage = new StudentPage();

    @Test
    public void setupStudentPage(){
        studentPage.LoadStudentPage();
        WebDriverWait student_wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        student_wait.until(ExpectedConditions.textToBePresentInElementLocated(studentPage.student_list_text_locator, "Student List"));
    }
    @Test
    public void addNewStudent(){
        studentPage.clickOneElement(studentPage.add_student_locator);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(studentPage.create_student_account_locator, "Create Student Account"));
    }
}
