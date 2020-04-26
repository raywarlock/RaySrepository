import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginToSecureArea {

public String login = "tomsmith";
public String password = "SuperSecretPassword!";
public String url = "https://the-internet.herokuapp.com/login";
public WebDriver driver;

@BeforeTest
    public void Setup(){
    System.setProperty("webdriver.edge.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\msedgedriver.exe");
    driver = new EdgeDriver();
}

@AfterTest
    public void Quit(){
    driver.quit();
}

@Test
    public void Main(){
    browserOps();
    positiveTest(); // correct credentials
    negativeUsernameTest(); //wrong username, correct password
    negativePasswordTest(); //correct username, wrong password
}

    private void negativePasswordTest() {
        WebElement userNameInput = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        userNameInput.sendKeys(login);
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordInput.sendKeys("password");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flash\"]")));
        System.out.println("Negative test passed. User didn't Log In with wrong password");
    }


    private void negativeUsernameTest() {
        WebElement userNameInput = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        userNameInput.sendKeys("username");
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordInput.sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flash\"]")));
        System.out.println("Negative test passed. User didn't Log In with wrong username");
            }

    private void positiveTest() {
        WebElement userNameInput = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        userNameInput.sendKeys(login);
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordInput.sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flash\"]")));
        System.out.println("Positive test passed. User Logged In with correct credentials");
        WebElement logOutButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a/i"));
        logOutButton.click();
}

    private void browserOps() {
    driver.get(url);
    driver.manage().window().maximize();
    WebDriverWait wait = new WebDriverWait(driver,5);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("example")));
}
}
