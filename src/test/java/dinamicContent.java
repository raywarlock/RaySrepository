import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.List;

public class dinamicContent {
    WebDriver driver;
    String path = "https://the-internet.herokuapp.com/dynamic_content";
    int imgListSizeBeforeRfrsh, txtListSizeBeforeRfrsh, imgListSizeAfterRfrsh, txtListSizeAfterRfrsh;
    int i, j, k, l;
    String[] imgAttrbtsBeforeRfrsh;
    String[] imgAttrbtsAfterRfrsh;
    String[] txtAttrbtsBeforeRfrsh;
    String[] txtAttrbtsAfterRfrsh;

    @BeforeSuite
    public void Setup() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @AfterTest
    public void Quit() {
        driver.quit();
    }

    @Test
    public void Test() {
        imgsAndTextInitially();
        imgsAndTextRfrshd();
        compareImgs();
    }

    public void compareImgs() {

    }

    public void imgsAndTextRfrshd() {
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("img")));
        List<WebElement> imgListAfterRfrsh = driver.findElements(By.tagName("img"));
        List<WebElement> txtListAfterRfrsh = driver.findElements(By.className("large-10"));
        imgListSizeAfterRfrsh = imgListAfterRfrsh.size();
        txtListSizeAfterRfrsh = txtListAfterRfrsh.size();
        String[] imgAttrbtsAfterRfrsh = new String[imgListSizeAfterRfrsh];
        for (k = 1; k < imgListSizeAfterRfrsh; k++) {
            imgAttrbtsAfterRfrsh[k] = imgListAfterRfrsh.get(k).getAttribute("src");
            System.out.println(imgAttrbtsAfterRfrsh[k]);
        }
        String[] txtAttrbtsAfterRfrsh = new String[txtListSizeAfterRfrsh];
        for (l = 1; l < txtListSizeAfterRfrsh; l++) {
            txtAttrbtsAfterRfrsh[l] = txtListAfterRfrsh.get(l).getText();
            System.out.println(txtAttrbtsAfterRfrsh[l]);
        }
    }

    public void imgsAndTextInitially() {
        driver.get(path);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("img")));
        List<WebElement> imgListBeforeRfrsh = driver.findElements(By.tagName("img"));
        List<WebElement> txtListBeforeRfrsh = driver.findElements(By.className("large-10"));
        imgListSizeBeforeRfrsh = imgListBeforeRfrsh.size();
        txtListSizeBeforeRfrsh = txtListBeforeRfrsh.size();
        String[] imgAttrbtsBeforeRfrsh = new String[imgListSizeBeforeRfrsh];
        for (i = 1; i < imgListSizeBeforeRfrsh; i++) {
            imgAttrbtsBeforeRfrsh[i] = imgListBeforeRfrsh.get(i).getAttribute("src");
            System.out.println(imgAttrbtsBeforeRfrsh[i]);
            }
        String[] txtAttrbtsBeforeRfrsh = new String[txtListSizeBeforeRfrsh];
        for (j = 1; j < txtListSizeBeforeRfrsh; j++) {
            txtAttrbtsBeforeRfrsh[j] = txtListBeforeRfrsh.get(j).getText();
            System.out.println(txtAttrbtsBeforeRfrsh[j]);
        }
    }

}
