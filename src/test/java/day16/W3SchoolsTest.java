package day16;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

import static junit.framework.TestCase.assertEquals;

public class W3SchoolsTest {
    WebDriver driver = new ChromeDriver();

    @Before
    public void openBrowserPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.w3schools.com/java/");
    }

    @Test
    public void w3SchoolsTest() {
        WebElement nameField = driver.findElement(By.xpath("//span[text()='Tutorial']"));
        String tutorialText = nameField.getText();
        Actions make = new Actions(driver);
        make
                .doubleClick(nameField)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c")
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath("//a[text()='English']")).click();
        driver.findElement(By.xpath("//textarea[@aria-label='Search']")).click();
        make
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v")
                .keyUp(Keys.LEFT_CONTROL)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        List<WebElement> tutorialElementsText = driver.findElements(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
        System.out.println(tutorialElementsText.size());

        boolean containsText = true;
        for (WebElement listElement : tutorialElementsText) {
            System.out.println(listElement.getText());
            String headerText = listElement.getText().toLowerCase();
            if (!headerText.contains(tutorialText.toLowerCase())) {
                containsText = false;
                break;
            }
        }
          assertEquals(String.format("Element not contains text %s", tutorialText), true, containsText);
    }

//h3[@class='LC20lb MBeuO DKV0Md']
//    @After
//    public void closeTestBrowser() {
//        driver.quit();
//    }
}
