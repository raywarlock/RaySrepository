import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class FindByXPathPt1 {
WebDriver driver;
String path1 = "https://the-internet.herokuapp.com/broken_images";

    @BeforeSuite
    public void setup () {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

        @Test
    public void test () {
    absoluteXpath(); // find object by absoluteXpath and assert it's displayed
    relativeXpath(); // find object by relative Xpath and assert it's displayed
    singleAttribute(); // find object by Single Attribute Xpath and assert it's displayed
    multipleAttribute(); // find object by Multiple Attributes Xpath and assert it's displayed
    usingAnd(); // find object by "Two attributes + And operator" Xpath and assert it's displayed
    usingOr(); // find object by "Two attributes + Or operator" Xpath and assert it's displayed
    }

    private void usingOr() {
        driver.get(path1);
        boolean isResultStatsDisplayed5 = driver.findElement(By.xpath("//*[@id='content' or @class='large-12 columns']")).isDisplayed();
        assertTrue(isResultStatsDisplayed5);
        System.out.println("Object 6 found using Two attributes + Or operator Xpath");
        driver.quit();
    }

    private void usingAnd() {
        driver.get(path1);
        boolean isResultStatsDisplayed5 = driver.findElement(By.xpath("//*[@target='_blank' and @href='http://elementalselenium.com/']")).isDisplayed();
        assertTrue(isResultStatsDisplayed5);
        System.out.println("Object 5 found using And Xpath");
    }

    private void multipleAttribute() {
        driver.get(path1);
        boolean isResultStatsDisplayed4 = driver.findElement(By.xpath("//*[@target='_blank'][@href='http://elementalselenium.com/']")).isDisplayed();
        assertTrue(isResultStatsDisplayed4);
        System.out.println("Object 4 found using Multiple Attribute Xpath");
    }

    private void singleAttribute() {
        driver.get(path1);
        boolean isResultStatsDisplayed3 = driver.findElement(By.xpath("//img[@src='img/avatar-blank.jpg']")).isDisplayed();
        assertTrue(isResultStatsDisplayed3);
        System.out.println("Object 3 found using Single Attribute Xpath");
    }

    private void relativeXpath() {
        driver.get(path1);
        boolean isResultStatsDisplayed2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/img[2]")).isDisplayed();
        assertTrue(isResultStatsDisplayed2);
        System.out.println("Object 2 found using Relative Xpath");
    }

    private void absoluteXpath() {
        driver.get(path1);
        boolean isResultStatsDisplayed1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/img[2]")).isDisplayed();
        assertTrue(isResultStatsDisplayed1);
        System.out.println("Object 1 found using Absolute Xpath");}
    }