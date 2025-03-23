package testcases;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
    public void addNewStudent() throws InterruptedException {
        studentPage.clickOneElement(studentPage.add_student_locator);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(studentPage.create_student_account_locator, "Create Student Account"));
        studentPage.clickOneElement(studentPage.student_consultant_selectBox);

       // select consultant
        Actions selectedActions = new Actions(getDriver());
        selectedActions.sendKeys("Muhammad  Usman").build().perform();
        Thread.sleep(2000);
        selectedActions.sendKeys(Keys.ENTER).build().perform();

        // select preferred country
       studentPage.clickOneElement(studentPage.select_prefer_country_locator);
        Actions selectPreferredCountry = new Actions(getDriver());
        selectPreferredCountry.sendKeys("Canada").build().perform();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        selectPreferredCountry.sendKeys(Keys.ENTER).build().perform();

        // First Name
        studentPage.writeOneElement(studentPage.first_name_locator, "Md. Hasin Anjum");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Last Name
        studentPage.writeOneElement(studentPage.last_name_locator, "pabon");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Email
        studentPage.writeOneElement(studentPage.email_locator, "hpabon12240@mail.com");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Create Student
        studentPage.clickOneElement(studentPage.create_student_Btn_locator);

        WebDriverWait alertWait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        alertWait.until(ExpectedConditions.textToBePresentInElementLocated(studentPage.student_add_alert, "Student added successfully"));
        studentPage.clickOneElement(studentPage.student_complete_profile_locator);

    }

    @Test
    public void DeleteAStudent() throws InterruptedException {
       studentPage.LoadAnWebPage(studentPage.student_page_url);
       studentPage.clickOneElement(studentPage.delete_student_btn_locator);
       // wait until modal show the text
       WebDriverWait confirmDeleteWait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
       confirmDeleteWait.until(ExpectedConditions.textToBePresentInElementLocated(studentPage.confirm_delete_btn_text, "Do You Want To Delete This Student Information ?"));
       studentPage.clickOneElement(studentPage.confirm_delete_student_btn_locator);
       Thread.sleep(3000);
    }

}
