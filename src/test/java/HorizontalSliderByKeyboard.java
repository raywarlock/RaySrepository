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

public class HorizontalSliderByKeyboard {

    public WebDriver driver;
    public String url = "https://the-internet.herokuapp.com/horizontal_slider";
    public String sliderPath = "//*[@id=\"content\"]/div/div/input";
    public int rangeCounterInt;


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
        openPage();
        actOnSlider1(); //Test1 - Move slider from 0 to 5 pressing Arrow Key – Right button.
        actOnSlider2(); //Test2 - Move slider from 5 to 0 pressing Arrow Key – Left button.
    }

    private void actOnSlider2() {
        WebElement slider = driver.findElement(By.xpath(sliderPath));
        WebElement range = driver.findElement(By.xpath("//*[@id=\"range\"]"));
        System.out.println("<Test 2. Move slider to the left (From 5 to 0) by pressing Arrow Key – Left button.>");
        System.out.println("Value of slider is 5");
        for (int i = 0; i < 10; i++){
            slider.sendKeys(Keys.ARROW_LEFT);
            String rangeValue = range.getText();
            try {rangeCounterInt = Integer.parseInt(rangeValue);
                System.out.println("Arrow Key – Left pressed. Value of slider is "+ rangeCounterInt);
            }
            catch (NumberFormatException e)
            {float rangeCounterFloat = Float.parseFloat(rangeValue);
                System.out.println("Arrow Key – Left pressed. Value of slider is "+ rangeCounterFloat);}
            if(rangeCounterInt == 0){
                System.out.println("<Test 2 successfully passed. Slider is in the most-left position.>");
            }
        }
    }

    private void actOnSlider1() {
        WebElement slider = driver.findElement(By.xpath(sliderPath));
        WebElement range = driver.findElement(By.xpath("//*[@id=\"range\"]"));
        System.out.println("<Test 1. Move slider to the right (From 0 to 5) by pressing Arrow Key – Right button.>");
        System.out.println("Value of slider is 0");
        for (int i = 0; i < 10; i++){
            slider.sendKeys(Keys.ARROW_UP);
            String rangeValue = range.getText();
            try {rangeCounterInt = Integer.parseInt(rangeValue);
                System.out.println("Arrow Key – Right pressed. Value of slider is "+ rangeCounterInt);
            }
            catch (NumberFormatException e)
            {float rangeCounterFloat = Float.parseFloat(rangeValue);
                System.out.println("Arrow Key – Right pressed. Value of slider is "+ rangeCounterFloat);}
            if(rangeCounterInt == 5){
                System.out.println("<Test 1 successfully passed. Slider is in the most-right position.>");
            }
        }
    }

    private void openPage() {
        driver.get(url);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sliderPath)));
    }
}