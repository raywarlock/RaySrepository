import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class DropDownList {

    WebDriver driver;
    String path = "https://the-internet.herokuapp.com/dropdown";

    @BeforeTest
    public void Setup(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\msedgedriver.exe");
    }

    @Test
    public void Test(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(path);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dropdown\"]")));
        WebElement list = driver.findElement(By.id("dropdown"));
        list.click();
        ArrayList options = (ArrayList) driver.findElements(By.tagName("option"));
        int optionsSize = options.size();
        System.out.println("Quantity of options displayed is " + (optionsSize-1));
        WebElement option1 = (WebElement) options.get(1);
        option1.click();
        WebElement sign = driver.findElement(By.tagName("h3"));
        sign.click();
        if (driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[2]")).isDisplayed()){
            System.out.println("Option 1 selected");
        }
        WebElement option2 = (WebElement) options.get(2);
        option2.click();
        sign.click();
        if (driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]")).isDisplayed()){
            System.out.println("Option 2 selected");
        }
    }

}
