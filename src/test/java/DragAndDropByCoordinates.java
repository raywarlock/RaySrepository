import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropByCoordinates {
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

    @Test
    public void test() {
        Actions action = new Actions(driver); // create object of Actions class as we use methods of Actions class
        driver.get(path);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(visibleCheck)));
        WebElement from = driver.findElement(By.id(fromID));
        WebElement to = driver.findElement(By.id(toID));
        int xOffsetFrom = from.getLocation().getX();
        int yOffsetFrom = from.getLocation().getY();
        System.out.println("Initial coordinates of object FROM are " + xOffsetFrom + " is X coordinate " + yOffsetFrom + " is Y coordinate");
        int xOffsetTo = to.getLocation().getX();
        int yOffsetTo = to.getLocation().getY();
        System.out.println("Initial coordinates of object TO are " + xOffsetTo + " is X coordinate " + yOffsetTo + " is Y coordinate");
        int  XXX = Math.abs(xOffsetFrom-xOffsetTo);
        int  YYY = Math.abs(yOffsetFrom-yOffsetTo);
        action.dragAndDropBy(from, XXX, YYY).build().perform(); // drag and drop action action.dragAndDropBy(from, xOffsetTo, yOffsetTo).build().perform();
        int xOffsetFrom1 = from.getLocation().getX();
        int yOffsetFrom1 = from.getLocation().getY();
        System.out.println("Coordinates of object FROM after drag and drop are " + xOffsetFrom1 + " is X coordinate " + yOffsetFrom1 + " is Y coordinate");
        if ((xOffsetFrom != xOffsetFrom1) || (yOffsetFrom !=yOffsetFrom1)) // using && to verify BOTH coordinates. Also OR "||" can be used to verify if one of two coordinates were changed
        {
            System.out.println("Test passed - object moved");
        } else
        System.out.println("Test failed - object didn't move");
    }
}

