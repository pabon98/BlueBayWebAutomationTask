package testcases;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.StudentPage;
import utilities.DriverSetUp;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.UUID;

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
        // generate random email
        String randomEmail = "user" + UUID.randomUUID().toString().substring(0,8) +"@mail.com";
        studentPage.writeOneElement(studentPage.email_locator, randomEmail);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Create Student
        studentPage.clickOneElement(studentPage.create_student_Btn_locator);

        WebDriverWait alertWait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        alertWait.until(ExpectedConditions.textToBePresentInElementLocated(studentPage.student_add_alert, "Student added successfully"));
        studentPage.clickOneElement(studentPage.student_complete_profile_locator);

    }



    @Test
    public void EditAStudent() throws InterruptedException {
        studentPage.LoadAnWebPage(studentPage.student_page_url);
        studentPage.clickOneElement(studentPage.edit_student_locator);
        WebDriverWait editWait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        editWait.until(ExpectedConditions.textToBePresentInElementLocated(studentPage.edit_student_locator_title, "Personal Information"));

        // Edit consultant
        studentPage.clickOneElement(studentPage.edit_student_consultant);
        Actions editConsultantAction = new Actions(getDriver());
        editConsultantAction.sendKeys("Talha Arif").build().perform();
        editConsultantAction.sendKeys(Keys.ENTER).build().perform();

        // Edit title
        studentPage.clickOneElement(studentPage.edit_title);
        //Edit firstName
        studentPage.getElement(studentPage.edit_firstname).clear();
        studentPage.writeOneElement(studentPage.edit_firstname, "Md. Habib");
        //Edit lastName
        studentPage.getElement(studentPage.edit_lastName).clear();
        studentPage.writeOneElement(studentPage.edit_lastName, "Hossain Khan");

        //Edit Date Of Birth

        //step 1 Click date input field to open date picker
        studentPage.clickOneElement(studentPage.edit_date_of_birth);
        WebDriverWait datePickerWait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        datePickerWait.until(ExpectedConditions.visibilityOfElementLocated(studentPage.edit_date_picker_body));

        // step 2 click the year selection to open year selection
        WebElement yearSelector = datePickerWait.until(ExpectedConditions.elementToBeClickable(By.className("ant-picker-year-btn")));
        yearSelector.click();

        // Step 3: Navigate Back Until We Reach a Year Before 2010
        while (true) {
            // Get the first  displayed year from the list
            List<WebElement> years = getDriver().findElements(By.xpath("//div[contains(@class,'ant-picker-cell-inner')]"));
            int firstDisplayedYear = Integer.parseInt(years.getFirst().getText());

            // Stop when the first displayed year is before 2010
            if (firstDisplayedYear <= 2000) {
                break;
            }

            // Click the "Previous Decade" button to go back 10 years
            WebElement prevDecadeButton = getDriver().findElement(By.className("ant-picker-super-prev-icon"));
            prevDecadeButton.click();
        }

        // step 5 Select random year
        List<WebElement> years = getDriver().findElements(By.xpath("//div[contains(@class,'ant-picker-cell-inner')]"));
        Random random = new Random();
        WebElement randomYear = years.get(random.nextInt(years.size())); // Pick a random year
        randomYear.click();

        // step 6 select random month

        List<WebElement> months = getDriver().findElements(By.xpath("//div[contains(@class,'ant-picker-cell-inner')]"));
        WebElement randomMonth = months.get(random.nextInt(months.size()));
        randomMonth.click();

        // step 7 select random day from the choose month

        List<WebElement> allDates = getDriver().findElements(By.xpath("//td[contains(@class, 'ant-picker-cell-in-view')]"));
        WebElement randomDate = allDates.get(random.nextInt(allDates.size()));
        Thread.sleep(2000);
        randomDate.click();

        // Edit passport number
        studentPage.writeOneElement(studentPage.edit_passportNumber, "12345abcd");

        // Edit issue date

        studentPage.clickOneElement(studentPage.edit_issue_date);


       // Find all available dates
        List<WebElement> issueDates = getDriver().findElements(By.xpath("//td[contains(@class, 'ant-picker-cell-in-view')]/div"));
        String targetIssueDate = "15";
        for (WebElement dates: issueDates){
//            System.out.println("Issue dates " +dates.getText());
              if (dates.getText().trim().equals(targetIssueDate)){
                  dates.click();
                  break;
              }
        }

        //Edit expire date

        studentPage.clickOneElement(studentPage.edit_expire_date);

        // Find all available dates
        List<WebElement> expireDates = getDriver().findElements(By.xpath("//td[contains(@class, 'ant-picker-cell-in-view')]/div"));
        String targetExpireDate = "30";
        for (WebElement date: expireDates){
//            System.out.println("Expire dates " + date.getText());
            if (date.getText().trim().equals(targetExpireDate)){
                date.click();
                break;
            }
        }


        // Edit gender

        studentPage.clickOneElement(studentPage.edit_gender);
        // Edit marital status

        studentPage.clickOneElement(studentPage.edit_marital_status);
        //Edit phone number
        studentPage.getElement(studentPage.edit_phone_number).clear();
        studentPage.writeOneElement(studentPage.edit_phone_number, "12445908656");
        //Edit Email
        studentPage.writeOneElement(studentPage.edit_email, "admin123@mail.com");

        //Edit country of birth
        studentPage.clickOneElement(studentPage.edit_country_birth);
        Actions editCountryBirthAction = new Actions(getDriver());
        editCountryBirthAction.sendKeys("Bangladesh").build().perform();
        editCountryBirthAction.sendKeys(Keys.ENTER).build().perform();

        //Edit country of residence
        studentPage.clickOneElement(studentPage.edit_residence_country);
        Actions editCountryResidenceAction = new Actions(getDriver());
        editCountryResidenceAction.sendKeys("Bangladesh").build().perform();
        editCountryResidenceAction.sendKeys(Keys.ENTER).build().perform();

        //Edit country of nationality
        studentPage.clickOneElement(studentPage.edit_country_nationality);
        Actions editCountryNationalityAction = new Actions(getDriver());
        editCountryNationalityAction.sendKeys("Bangladesh").build().perform();
//        Thread.sleep(2000);
        editCountryNationalityAction.sendKeys(Keys.ENTER).build().perform();

        // save button
        studentPage.clickOneElement(studentPage.save_and_next);
        Thread.sleep(3000);
//        WebDriverWait successWait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        successWait.until(ExpectedConditions.visibilityOfElementLocated(studentPage.student_info_updated_toast));

        // back page
        studentPage.clickOneElement(studentPage.go_to_stu_page);

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
