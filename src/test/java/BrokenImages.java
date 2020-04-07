import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.List;

public class BrokenImages {

    WebDriver driver;
    String path = "https://raystyle.narod.ru/Index.htm";
    //String path = "https://the-internet.herokuapp.com/broken_images";

    @BeforeSuite
    public void Setup() {
    System.setProperty("webdriver.edge.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\msedgedriver.exe");
    }

    @Test
    public void testTest() {
        WebDriver driver = new EdgeDriver();
        driver.get(path);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("img")));
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Q-ty of images is " + images.size());
        for (int i = 0; i<images.size(); i++) {
            var imgHeight = images.get(i).getAttribute("naturalWidth");
            String imgUrl = images.get(i).getAttribute("src");
            if (imgHeight.equals("0")) {
                System.out.println("image " + imgUrl + " is broken");
            }
        }
        driver.quit();
    }
}

