import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Entry_Ad {
    WebDriver driver;
    String path = "https://the-internet.herokuapp.com/entry_ad";

    @BeforeTest
    public void Setup() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @AfterTest
    public void Quit() {
        driver.quit();
    }

    @Test
    public void Main_Test(){
        browserAction();
    }


    private void browserAction() {
        driver.get(path);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal\"]/div[2]/div[1]/h3")));
        WebElement adWindow = driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/div[1]/h3"));
        WebElement closeBtn = driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/div[3]/p"));
        closeBtn.click();
        boolean check = adWindow.isDisplayed();
        if (check == true){
            System.out.println("Test Failed");
            driver.quit();
        }
        else
            System.out.println("Test Passed");
    }


}
