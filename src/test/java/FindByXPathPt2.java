import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FindByXPathPt2 {
    WebDriver driver;
    String path = "https://www.yahoo.com";
    String path1 = "https://www.ebay.com";

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void XpathContains() {
        navigateToPage_enterQuery_Submit(); // Navigate to certain page, find object using Xpath "Contains"
        assertResult(); // Assert found result
    }
    private void assertResult() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("compPagination")));
        boolean displayed = driver.findElement(By.className("compPagination")).isDisplayed();
        assertTrue(displayed);
        System.out.println("Object1 found using Xpath Contains");
        driver.quit();
    }
    private void navigateToPage_enterQuery_Submit() {
        driver.get(path);
        WebElement element = driver.findElement(By.xpath("//*[contains(@id,'-input')]"));
        element.sendKeys("Pitbull");
        element.submit();
    }

    @Test
    public void XpathStartsWith() {
        navigateToPageFindObject(); // Navigate to certain page, find object using Xpath "Starts with"; Enter text query and submit; Assert result
        waitPageToBeDisplayed();
        assertQueryResult();
    }
    private void assertQueryResult() {
        boolean visibleObject = driver.findElement(By.xpath("//*[starts-with(@class,'srp-')]")).isDisplayed();
        assertTrue(visibleObject);
        System.out.println("Object2 found using Xpath Starts-with");
        driver.quit();
    }
    private void waitPageToBeDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[starts-with(@class,'srp-')]")));
    }
    private void navigateToPageFindObject() {
        driver = new FirefoxDriver();
        driver.get(path1);
        WebElement element = driver.findElement(By.xpath("//input[starts-with(@type,'tex')]"));
        element.sendKeys("Honda");
        element.submit();
    }


    @Test
    public void XpathText() {
        goToPage_findObject(); // Navigate to certain page, find object using Xpath "text = "; Act on the object with mouse click;
        assertTheResult(); // Wait for the object to be displayed; Assert the result;
    }
    private void assertTheResult() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Collectibles & art']")));
        boolean objctDspld = driver.findElement(By.xpath("//*[text()='All Categories']")).isDisplayed();
        assertTrue(objctDspld);
        System.out.println("Object3 found using Xpath Text");
        driver.quit();
    }
    private void goToPage_findObject() {
        driver = new FirefoxDriver();
        driver.get(path1);
        WebElement element = driver.findElement(By.xpath("//*[text()='Shop by category']"));
        element.click();
    }
}
