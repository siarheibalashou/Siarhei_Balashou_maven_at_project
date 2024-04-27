package pages.google;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class GoogleMainPage {
    WebDriver driver = Driver.getDriver();
    Actions make = new Actions(driver);

    public void switchLanguage() {
        driver.findElement(By.xpath("//a[text()='English']")).click();
    }

    public void pasteTextAndSearch() {
        driver.findElement(By.xpath("//textarea[@aria-label='Search']")).click();
        make
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v")
                .keyUp(Keys.LEFT_CONTROL)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
    }
}
