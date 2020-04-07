import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AutomationOfHerokuappAddRemoveFFox {

    WebDriver driver;
    @BeforeSuite
    public void Setup() {
    System.setProperty("webdriver.edge.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\geckodriver.exe");
    driver = new FirefoxDriver();
    }
    @Test
    public void TestMain() {
    openBrowser(); // run FireFox and navigate to the certain page
    button1Act(); // click on button "Add element" to see if Button "Delete" will appear
    waitForButton2(); // wait for Button "Delete" to appear
    button2Act(); // click on Button "Delete" to make it disappear
    }
    private void button2Act() {
    Actions action2 = new Actions(driver);
    WebElement elementLocator2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/button"));
    action2.click(elementLocator2).perform();
    }
    private void waitForButton2() {
    WebDriverWait wait = new WebDriverWait(driver, 1);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("added-manually")));
    }
    private void button1Act() {
    Actions actions = new Actions(driver);
    WebElement elementLocator = driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
    actions.click(elementLocator).perform();
    }
    private void openBrowser() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }
}
