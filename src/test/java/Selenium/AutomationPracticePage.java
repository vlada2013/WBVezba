package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutomationPracticePage
{
    protected WebDriver driver;

    public WebElement autocomplete;

    public AutomationPracticePage(WebDriver driver)
    {
        this.driver = driver;
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        autocomplete = driver.findElement(By.id("autocomplete"));
    }

    public void enterText(String text)
    {
        autocomplete.sendKeys(text);
    }

    public void closeWindow()
    {
        driver.quit();
    }

}
