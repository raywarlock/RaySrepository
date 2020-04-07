import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AuthAdminAdmin {

    WebDriver driver;
    String path = "https://admin:admin@the-internet.herokuapp.com/digest_auth";

    @BeforeSuite
    public void Setup() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @Test
    public void Test(){
        driver.get(path);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        String check = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText();
        if (check.contains("Congratulations! You must have the proper credentials.")) {
            System.out.println("Test accomplished");
        }
        else {
            System.out.println("Test failed");
        }
        driver.quit();
    }
}
