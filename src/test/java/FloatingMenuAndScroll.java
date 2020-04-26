import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FloatingMenuAndScroll {

    public WebDriver driver;
    public String path = "https://the-internet.herokuapp.com/floating_menu";
    public String flMenu = "//*[@id=\"content\"]/div/h3";

    @BeforeTest
    public void Setup(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @AfterTest
    public void Quit(){
        driver.quit();
    }

    @Test
    public void Main() {
        browserStart();
        middleScroll();
        bottomScroll();
    }

    private void bottomScroll() {
        WebElement footer = driver.findElement(By.id("page-footer"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", footer);
        WebElement menu = driver.findElement(By.xpath(flMenu));
        if (menu.isDisplayed()){
            System.out.println("window scrolled all way down and menu floats");
        }
        else
            System.out.println("window scrolled all way down and menu doesn't float");
    }

    private void middleScroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        WebElement menu = driver.findElement(By.xpath(flMenu));
        if (menu.isDisplayed()){
            System.out.println("window scrolled down by 1000 pixels and menu floats");
        }
        else
            System.out.println("window scrolled down by 1000 pixels and menu doesn't float");
    }

    private void browserStart() {
        driver.get(path);
        driver.manage().window().maximize();
        WebDriverWait wait1 = new WebDriverWait(driver,5);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(flMenu)));
        }
}

