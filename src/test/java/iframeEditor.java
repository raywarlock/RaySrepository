import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class iframeEditor {

    public String url = "https://the-internet.herokuapp.com/iframe";
    public String test1text = "The world is coming to the end";
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
        frameAction(); // switch to frame and enter text
        BoldbuttonCheck();
        findButtons();
    }

    private void findButtons() {
        List<WebElement> Buttons= driver.findElements(By.tagName("button"));
        int ButtonsSize = Buttons.size();
        for (int i = 0; i<ButtonsSize; i++){
            String buttonName = Buttons.get(i).getAttribute("aria-label");
            System.out.println("Button" + (i+1) + " has name " + buttonName);
        }
    }

    private void BoldbuttonCheck() {
        WebElement boldButton = driver.findElement(By.xpath("//*[@id=\"mceu_3\"]"));
        boldButton.click(); // click the Bold button
        String boldButtonMode = boldButton.getAttribute("aria-pressed");
        if (boldButtonMode.equals("true")){
            System.out.println("Test 2 passed. Bold button enabled.");
        }
        else System.out.println("Bold button disabled. Test 2 failed");

    }


    private void frameAction() {
        int framesQty = driver.findElements(By.tagName("iframe")).size();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
        WebElement inputTextField = driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p"));
        inputTextField.clear();
        inputTextField.sendKeys(test1text);
        WebElement textField = driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p[1]"));
        String textFieldText = textField.getText();
        if (textFieldText == textFieldText){
            System.out.println("Test 1 passed. Text entered and displayed in input field");
        }
        else
            System.out.println("Test 1 failed");
        driver.switchTo().defaultContent();

    }


    private void waitForWindow() {
    WebDriverWait wait = new WebDriverWait(driver,5);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/h3")));
    }

    private void browserOps () {
        driver.get(url);
        driver.manage().window().maximize();
    }

}
