import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class YahooSearchTest_Original {

    WebDriver driver;

    @BeforeSuite
    public void setup () {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\geckodriver.exe");
    }

    @Test
    public void test0001() {
        openBrowser();
        navigateToMainPage();
        waitForYahooPage();
        typeQuery();
        submitSearch();
        waitForResultsPage();
        assertResultsPage();
    }

    private void waitForYahooPage() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header-search-input")));

    }

    private void waitForResultsPage() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result--Stats")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("compPagination")));
    }

    private void assertResultsPage() {
        boolean isResultStatsDisplayed = driver.findElement(By.className("compPagination")).isDisplayed();
        Assert.assertTrue(isResultStatsDisplayed);
    }

    private void submitSearch() {
        String selector = "#header-search-input";
        WebElement element = driver.findElement(By.cssSelector(selector));
        element.submit();
    }

    private void typeQuery() {
        String selector = "#header-search-input";
        WebElement element = driver.findElement(By.cssSelector(selector));
        element.sendKeys("French Bulldog");
    }

    private void navigateToMainPage() {
        driver.get("https://www.yahoo.com/");
    }

    private void openBrowser() {
        driver = new FirefoxDriver();
        // driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


    }
}