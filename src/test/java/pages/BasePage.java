package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.DriverSetUp;

public class BasePage extends DriverSetUp {

    public void LoadAnWebPage(String url){
        getDriver().get(url);
    }
    public WebElement getElement(By Locator){
        return getDriver().findElement(Locator);
    }
    public void clickOneElement(By Locator){
        getElement(Locator).click();
    }
    public void writeOneElement(By Locator, String text){
     getElement(Locator).sendKeys(text);
    }
}
