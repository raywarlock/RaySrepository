import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicControls {
    String path = "https://the-internet.herokuapp.com/dynamic_controls";
    String checkBox = "//*[@id=\"checkbox\"]";
    String removeAddBtn = "//*[@id=\"checkbox-example\"]/button";
    String enableBtn = "//*[@id=\"input-example\"]/button";
    String inputFld = "//*[@id=\"input-example\"]/input";
    WebDriver driver;

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
    public void Test1(){
        BrowserStart();
        RemoveAction();
        Add_action();
        Enable_action();
        Disable_action();

    }
    private void Disable_action() {
        WebElement enable = driver.findElement(By.xpath(enableBtn));
        enable.click();
        WebElement input = driver.findElement(By.xpath(inputFld));
        WebDriverWait wait1 = new WebDriverWait(driver,20);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        try {
            input.sendKeys("TEXT");
            System.out.println("Test 4 Failed.");
            driver.quit();
        }
        catch (Exception e) {
            System.out.println("Test 4 passed. Input field inactive");
        }

    }
    private void Enable_action() {
        WebElement enable = driver.findElement(By.xpath(enableBtn));
        enable.click();
        WebElement input = driver.findElement(By.xpath(inputFld));
        WebDriverWait wait1 = new WebDriverWait(driver,20);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"message\"]")));
        try {
            input.sendKeys("TEXT");
            System.out.println("Test 3 passed. TEXT entered to the field");
        }
        catch (Exception e) {
            System.out.println("Test 3 failed");
            driver.quit();
        }
    }
    private void Add_action() {
        WebElement removeAdd = driver.findElement(By.xpath(removeAddBtn));
        removeAdd.click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        WebElement checkbox = driver.findElement(By.xpath(checkBox));
        try {
            boolean chckbxVsbl = checkbox.isDisplayed();
            if (chckbxVsbl = true){
                System.out.println("CheckBox appeared. Test 2 passed");
            }
        }
        catch (StaleElementReferenceException e){
            System.out.println("Checkbox does not exist. Test 2 failed");
            driver.quit();
        }
    }
    private void RemoveAction() {
        WebDriverWait wait1 = new WebDriverWait(driver,10);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        WebElement checkbox = driver.findElement(By.xpath(checkBox));
        WebElement removeAdd = driver.findElement(By.xpath(removeAddBtn));
        removeAdd.click();
        WebDriverWait wait2 = new WebDriverWait(driver,20);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        try {
            boolean chckbxVsbl = checkbox.isDisplayed();
            if (chckbxVsbl = true){
                System.out.println("CheckBox exists. Test 1 failed.");
                driver.quit();
            }
        }
        catch (StaleElementReferenceException e){
            System.out.println("Checkbox removed. Test 1 passed.");
        }
    }
    private void BrowserStart() {
        driver.get(path);
        driver.manage().window().maximize();
    }
}
