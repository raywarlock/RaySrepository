import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.List;

public class CheckBoxes {
    WebDriver driver;
    String path = "https://the-internet.herokuapp.com/checkboxes";

    @BeforeSuite
    public void Setup() {
    System.setProperty("webdriver.edge.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\msedgedriver.exe");
    }

    @Test
    public void Test() {
        WebDriver driver = new EdgeDriver();
        driver.get(path);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("input")));
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        System.out.println("Q-ty of checkboxes on the page is " + checkboxes.size());
        for (int i = 0; i < checkboxes.size(); i++) {
            String checkBxAttr = checkboxes.get(i).getAttribute("checked");
            if (checkBxAttr==null) {
                System.out.println("Check Box " + ((i)+1) + " is initially unchecked");
            }
            else System.out.println("Check Box " + ((i)+1) + " is initially checked");
        }
        System.out.println("Implementing CLICK operation on each check box and see if their attribute will be changed");
        for (int i = 0; i < checkboxes.size(); i++) {
            checkboxes.get(i).click();
            String checkBxAttr = checkboxes.get(i).getAttribute("checked");
            if (checkBxAttr==null) {
                System.out.println("Check Box " + ((i)+1) + " is unchecked after click");
            }
            else System.out.println("Check Box " + ((i)+1) + " is checked after click");
        }
    driver.quit();
    }

}
