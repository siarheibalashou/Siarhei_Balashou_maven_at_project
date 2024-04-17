package objects.w3schools;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class W3SchoolsMainPage {
    WebDriver driver = Driver.getDriver();

    public void openW3SchoolsPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.w3schools.com/java/");
    }

    public WebElement getHeaderElement() {
        return driver.findElement(By.xpath("//span[text()='Tutorial']"));
    }

    public String getHeaderText() {
        return getHeaderElement().getText();
    }


    public void copyHeaderText() {
        Actions make = new Actions(driver);
        make
                .doubleClick(getHeaderElement())
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c")
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
    }

    public void redirectToGoogle() {
        driver.navigate().to("https://google.com");
    }
}
