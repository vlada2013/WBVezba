package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class Google {
    @Test
    public void testDemo() throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String URL = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(URL);
        String title = driver.getTitle();
        System.out.println("Title is: "+title);


        //radio buttons
        WebElement radioButton = driver.findElement(By.xpath("//input[@value='radio2']"));
        radioButton.click();
        Assert.assertEquals(true, radioButton.isSelected());


        //autocomplete
        driver.findElement(By.id("autocomplete")).sendKeys("Mac");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> listOfElements =driver.findElements(By.className("ui-menu-item-wrapper"));

        for(int i=0;i<listOfElements.size();i++)
        {
            var s = Integer.toString(i);
            System.out.println(s+" " +"List of countries: " + listOfElements.get(i).getText());

        }
        System.out.println("Selected country: " + listOfElements.get(1).getText());
        driver.findElement(By.id("ui-id-1")).click();



        //dropdown
        Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
        dropdown.selectByVisibleText("Option2");
        String text = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(text, "Option2");



        //checkbox
       WebElement checkBox =  driver.findElement(By.id("checkBoxOption3"));
       checkBox.click();
       Assert.assertEquals(true, checkBox.isSelected());

       driver.quit();
    }
}



