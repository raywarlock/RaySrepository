import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MoveMouse {

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

        Actions action2 = new Actions(driver);
        Action mouseOverList = action2.moveToElement(list).click().build();
        mouseOverList.perform();
    }
}
