import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class iframes {

    public String leftFrame = "/html/frameset/frame[1]";
    public String middleFrame = "/html/frameset/frame[2]";
    public String rightFrame = "/html/frameset/frame[3]";
    public String bottomFrame = "/html/frameset/frame[2]";
    public String url = "https://the-internet.herokuapp.com/nested_frames";
    public WebDriver driver;

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
    public void Main() {
        browserOps();
        waitForWindow();
        framesAction();
    }

    private void framesAction() {
        //int framesQty = driver.findElements(By.tagName("iframe")).size();
        driver.switchTo().defaultContent();
        //driver.switchTo().frame(driver.findElement(By.tagName("frameset")).findElements(By.tagName("frame")).get(2));
        WebElement leftFrameElement = driver.findElement(By.xpath(leftFrame));
        driver.switchTo().frame(leftFrameElement);
        WebElement leftFrameText = driver.findElement(By.xpath("/html/body"));
        String leftText = leftFrameText.getText();
    }


    private void waitForWindow() {
        long startTime = System.currentTimeMillis();
        long currentTime = startTime;
        while (currentTime < startTime + 5000) {
            //Do something here
            //System.out.println("Time is" + System.currentTimeMillis());
            currentTime = System.currentTimeMillis();
        }
    }

        private void browserOps () {
            driver.get(url);
            driver.manage().window().maximize();
        }
}
