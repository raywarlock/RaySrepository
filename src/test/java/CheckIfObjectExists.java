import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CheckIfObjectExists {

    WebDriver driver;
    String path = "https://the-internet.herokuapp.com/disappearing_elements";

    @BeforeSuite
    public void Setup(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\msedgedriver.exe");
        driver = new EdgeDriver();
    }
    @AfterTest
    public void Quit(){
        driver.quit();
    }

    @Test
    public void Test(){
        driver.get(path);
        WebDriverWait wait1 = new WebDriverWait(driver,3);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
        WebElement home = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/a"));
        home.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean present;
        try {
            driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/a"));
            present = true;
            System.out.println("Button HOME exists");
        } catch (NoSuchElementException e) {
            present = false;
            System.out.println("Button HOME doesn't exist");
        }
    }
}
