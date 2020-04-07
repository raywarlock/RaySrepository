import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class DropDownListAndMouseMove {

    WebDriver driver;
    String path = "https://the-internet.herokuapp.com/dropdown";

    @BeforeSuite
    public void Setup(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @AfterTest
    public void Quit() {
        driver.quit();
    }

    @Test
    public void Test() {
        dropDownList(); // test1 - action with dropdown list
        mouseMove(); // test3 - actions with mouse movements and verification
    }

    public void mouseMove() {
        WebDriverWait waitNew = new WebDriverWait(driver, 5);
        waitNew.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dropdown\"]")));
        Actions action1 = new Actions(driver);
        String footerPath = "//*[@id=\"page-footer\"]/div/div/a";
        WebElement footer = driver.findElement(By.xpath(footerPath));
        String footerColorBefore = footer.getCssValue("color");
        System.out.println("Font color before mouse moved to the object is " + footerColorBefore);
        Action mouseOverLink = action1.moveToElement(driver.findElement(By.xpath(footerPath))).build();
        mouseOverLink.perform();
        String footerColorAfter = footer.getCssValue("color");
        System.out.println("Font color after mouse moved to the object is " + footerColorAfter);
        if (footerColorBefore != footerColorAfter) {
            System.out.println("Test sucessfully pased. Mouse moved to the object and the color has been changed");
        }
        else
            System.out.println("Test failed");
    }

    public void dropDownList() {
        driver.get(path);
        driver.manage().window().maximize();
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
