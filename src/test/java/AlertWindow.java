import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AlertWindow {


    WebDriver driver;
    //String path = "https://the-internet.herokuapp.com/digest_auth";
    String path = "http://demo.guru99.com/test/delete_customer.php";

    @BeforeSuite
    public void Setup() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @Test
    public void Test(){
        driver.get(path);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("cusid")));
        driver.findElement(By.name("cusid")).sendKeys("666");
        driver.findElement(By.name("submit")).click();
        WebDriverWait waitAlert1 = new WebDriverWait(driver, 5);
        waitAlert1.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        WebDriverWait waitAlert2 = new WebDriverWait(driver, 5);
        waitAlert2.until(ExpectedConditions.alertIsPresent());
        String CheckWindowAlertText = driver.switchTo().alert().getText();
        if (CheckWindowAlertText.contains("Successfully")) {
            System.out.println("Test accomplished");
        }
        else {
            System.out.println("Test failed");
        }
        driver.quit();
    }
}
