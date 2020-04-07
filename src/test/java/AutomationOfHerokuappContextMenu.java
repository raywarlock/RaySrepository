import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AutomationOfHerokuappContextMenu {

    WebDriver driver;

    @BeforeSuite
    public void setup() {
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\geckodriver.exe");
    driver = new FirefoxDriver();
    }
    @AfterSuite
    public void quit() {
    driver.quit();
    }
    @Test
    public void testMain() {
    openBrowser(); // run the FireFox and open the certain page
    findTheBox(); // find the box with dashed border and click the right mouse button on it
    waitForMenu(); // WEBdriver waits until the alert message shows up and then goes on to next step
    assertContextMenu(); // find the popup window and compare expected text in the popup window with text in popup window
    }
    private void assertContextMenu() {
    String popup = "You selected a context menu";
    Alert alert = driver.switchTo().alert();
    String alertMessage = driver.switchTo().alert().getText();
    Assert.assertEquals(popup, alertMessage);
    System.out.println("There is a context menu on page " + " : " + popup.equals(alertMessage));
    }
    private void waitForMenu() {
    WebDriverWait wait = new WebDriverWait(driver, 1);
    wait.until(ExpectedConditions.alertIsPresent());
    }
    private void findTheBox() {
    Actions actions = new Actions(driver);
    WebElement elementLocator = driver.findElement(By.id("hot-spot"));
    actions.contextClick(elementLocator).perform();
    }
    private void openBrowser() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
    }
}
