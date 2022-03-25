package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class Objects_Ivana {

        WebDriver driver;
        WebElement radioButton;
        WebElement autocomplete;
        Select dropdown;
        WebElement checkBox;
        WebElement mouseHover;


    public Objects_Ivana(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String URL = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(URL);
        radioButton = driver.findElement(By.xpath("//input[@value='radio2']"));
        autocomplete = driver.findElement(By.id("autocomplete"));
        dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
        checkBox = driver.findElement(By.id("checkBoxOption3"));
        mouseHover = driver.findElement(By.id("mousehover"));
    }

    public void titleTextCheck(){
        String title = driver.getTitle();
        Assert.assertEquals(title, "Practice Page");
    }

    public void radioButtonAction() {
        radioButton.click();
        Assert.assertEquals(true, radioButton.isSelected());
    }

    public void autocompleteAction() {
        autocomplete.sendKeys("Mac");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> listOfElements = driver.findElements(By.className("ui-menu-item-wrapper"));

        for (int i = 0; i < listOfElements.size(); i++) {
            var s = Integer.toString(i);
            System.out.println(s + " " + "List of countries: " + listOfElements.get(i).getText());
        }
        Assert.assertEquals(listOfElements.get(0).getText(), "Macau");
        Assert.assertEquals(listOfElements.get(1).getText(), "Macedonia, The Former Yugoslav Republic of");
        System.out.println("Selected country: " + listOfElements.get(1).getText());
        driver.findElement(By.id("ui-id-1")).click();
    }

    public void dropdownAction() {
        dropdown.selectByVisibleText("Option2");
        String text = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(text, "Option2");
    }

    public void checkboxAction() {
        checkBox.click();
        Assert.assertEquals(true, checkBox.isSelected());
    }

    public void mouseHoverAction() {
        driver.manage().window().maximize();
        Actions action = new Actions(driver); action.moveToElement(mouseHover).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement mouseHoverElement = driver.findElement(By.className("mouse-hover-content"));
        String text = mouseHoverElement.getText();
        if(driver.getPageSource().contains("Top"))
        {
            System.out.println("Visible");
            System.out.println(mouseHoverElement.getText());
            assertThat(text, containsString("Top"));
            assertThat(text, containsString("Reload"));
        }
        else
        {
            System.out.println("Not Visible");
        }
    }

    public void closeWindow() {
            driver.quit();
    }

}

