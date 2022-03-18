package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {
    @Test
    public void testDemo(){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://google.com");
        String title = driver.getTitle();
        System.out.println(title);
        driver.quit();

    }

}
