import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public class FileDownload {

    WebDriver driver;
    String URL = "https://the-internet.herokuapp.com/download";
    public String link = "some-file.txt";

    @BeforeTest
    public void Setup(){
        //System.setProperty("webdriver.edge.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\msedgedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void Quit(){
        driver.quit();
    }

    @Test
    public void main(String[] args) throws InterruptedException {
        HashMap<String, Object> edgePrefs = new HashMap<String, Object>();
        edgePrefs.put("profile.default_content_settings.popups", 0);
        edgePrefs.put("download.default_directory", System.getProperty("user.dir"));

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", edgePrefs);


        //WebDriver driver = new EdgeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

        //We find the download links
        //List<WebElement> list =driver.findElements(By.cssSelector("div.module>p>a>img"));
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/a")));
        WebElement linkBtn = driver.findElement(By.linkText(link));

        //Click the last one to downaload 5MB file :)
        //WebElement el = list.get(list.size()-1);
        linkBtn.click();

        Thread.sleep(3000);
        //Get the user.dir folder
        File folder = new File(System.getProperty("user.dir"));

        //List the files on that folder
        File[] listOfFiles = folder.listFiles();

        boolean found = false;
        File f = null;

        //Look for the file in the files
        // You should write smart REGEX according to the filename
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches("5MB.zip" )) {
                    f = new File(fileName);
                    found = true;
                }

            }
        }

        Assert.assertTrue(found, "Downloaded document is not found");
        //f.deleteOnExit();
        //driver.close();

    }

    }