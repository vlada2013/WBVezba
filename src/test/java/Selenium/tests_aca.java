package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class tests_aca {
    @Test
    public void testDemo() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String URL = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(URL);

        AutomationPracticePage page = new AutomationPracticePage(driver);

        page.enterText("Sample text");
        page.closeWindow();
    }
}