import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop {
    WebDriver driver;
    String path = "https://demoqa.com/droppable/";
    String visibleCheck = "//*[@id=\"content\"]/div[2]";
    String fromID = "draggable";
    String toID = "droppable";

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
    public void test() {
        Actions action = new Actions(driver); // create object of Actions class as we use methods of Actions class
        driver.get(path);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(visibleCheck)));
        WebElement from = driver.findElement(By.id(fromID));
        WebElement to = driver.findElement(By.id(toID));
        action.dragAndDrop(from, to).build().perform(); // drag and drop action
        String toText = to.getText();
        if (toText.equals("Dropped!")) {
            System.out.println("test passed");
        }
        else
            System.out.println("test failed");
    }
}
