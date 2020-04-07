import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Refresh {

    WebDriver driver;

@BeforeSuite
public void setup(){
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\geckodriver.exe");
}

@AfterSuite
public void exit(){
    driver.quit();
}


@Test

    public void test001() {
    openBrowser(); // runs FireFox browser
    navigateToPage(); // open Yahoo.com in FireFox browser
    waitForYahooPage(); // wait for the page to be loaded
    typeQuery(); // allocate the search field and type text query
    submitSearch(); // submit entered text
    waitForResultPage(); // wait for the results page to be loaded
    assertResultsPage(); // assert the result page is displayed
    }

    private void assertResultsPage() {
    boolean isResultsStatsDisplayed = driver.findElement(By.className("compPagination")).isDisplayed();
        Assert.assertTrue(isResultsStatsDisplayed);
        System.out.println("Test passed");

    }

    private void waitForResultPage() {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("compPagination")));
    }

    private void submitSearch() {
    WebElement element = driver.findElement(By.xpath("//*[@id=\"header-desktop-search-button\"]"));
    element.click();
    }

    private void typeQuery() {
        WebElement element = driver.findElement(By.id("header-search-input"));
        element.sendKeys("Oil rates");

    }

    private void waitForYahooPage() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header-search-input")));
    }

    private void navigateToPage() {
    driver.get("https://www.yahoo.com/");
    }

    private void openBrowser() {
    driver = new FirefoxDriver();
    }

}
