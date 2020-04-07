import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PopUpCrossBrowser {

    WebDriver driver;
    String path = "https://admin:admin@the-internet.herokuapp.com/digest_auth";

    @Test
    public void TestEdge(){ // Edge Browser
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get(path);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        String check = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText();
        if (check.contains("Congratulations! You must have the proper credentials.")) {
            System.out.println("MS Edge test accomplished");
        }
        else {
            System.out.println("MS Edge test failed");
        }
        driver.quit();
    }
    @Test
    public void TestFFox(){ // FireFox Browser
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(path);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        String check = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText();
        if (check.contains("Congratulations!")) {
            System.out.println("FFox test accomplished");
        }
        else {
            System.out.println("FFox test failed");
        }
        driver.quit();
    }
}
