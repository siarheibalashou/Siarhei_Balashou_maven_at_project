package pages.demoqa;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DemoQaSelectPage {
    WebDriver driver = Driver.getDriver();

    public void openDemoQaPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/select-menu");
    }

    public void selectColorMenu() {
        WebElement colorDropdown = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
        Select select = new Select(colorDropdown);
        select.selectByIndex(3);
    }

    public void selectOneMenu() {
        WebElement colorDropdown = driver.findElement(By.xpath("//select[@id='selectOne']"));
        Select select = new Select(colorDropdown);
        select.selectByIndex(3);
    }
}
