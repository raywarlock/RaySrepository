import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ResumeBuilderTest2Resume {

    WebDriver driver;
    // String loginText = "ray_warlock";
    // String passwordText = "Nl21_nov16";
    String url = "http://yeroshchenko.pythonanywhere.com/";


    @BeforeTest
    public void Setup() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @AfterTest
    public void Quit(){
        driver.quit();
    }



    @Parameters({"LoginParameter", "PasswordParameter"})
    @Test
    public void Test1(String LoginParameter, String PasswordParameter){
        String loginText = LoginParameter;
        String passwordText = PasswordParameter;
        startAndOpenPage();
        loginProcess(loginText, passwordText);
        checkTheLoginResult();
    }

    private void checkTheLoginResult() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement menu = driver.findElement(By.xpath("/html/body/div/header/div/div/div[2]"));   ///html/body/div/header/div/div/div[2]/li[1]
        wait.until(ExpectedConditions.visibilityOf(menu));
        //String verifyText = menu.getText();
        //WebElement loginErrorSign = driver.findElement(By.xpath("/html/body/div/section/div[1]/div/h1"));
        try {
            WebElement loginErrorSign = driver.findElement(By.xpath("/html/body/div/section/div[1]/div/h1"));

        }
        catch(Exception e) {
            System.out.println("Test completed. Login process successful.");
        }
        WebElement loginErrorSign = driver.findElement(By.xpath("/html/body/div/section/div[1]/div/h1"));
        Boolean check = loginErrorSign.isDisplayed();
        if (check = true){

            System.out.println("Test failed.");
        }
        else
            System.out.println("Test completed. Login process successful.");
    }

    private void loginProcess(String loginText, String passwordText) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement loginButtonSmall = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        wait.until(ExpectedConditions.visibilityOf(loginButtonSmall));
        WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        username.sendKeys(loginText);
        password.sendKeys(passwordText);
        loginButtonSmall.click();
    }

    private void startAndOpenPage() {
        driver.manage().window().maximize();
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement loginButtonMenu = driver.findElement(By.xpath("/html/body/div/header/div/div/div[2]/li[1]/a"));
        wait.until(ExpectedConditions.visibilityOf(loginButtonMenu));
        loginButtonMenu.click();
    }

}