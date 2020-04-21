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

import java.util.Set;

public class Dynamic_Loading_Hidden {
    WebDriver driver;
    String path = "https://the-internet.herokuapp.com/dynamic_loading";
    String openLinkInNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);


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
    public void MainTest(){
        browser_Action1();
        first_link_action(); //work with objects in opened window and close the tab
        browser_Action2(); //open main window; open link 2 in new tab; navigate to new opened tab
        second_link_action(); //work with objects in opened window and close the tab
    }

    private void second_link_action() {
        WebElement btn_start = driver.findElement(By.tagName("button"));
        btn_start.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"finish\"]/h4")));
        WebElement sign = driver.findElement(By.xpath("//*[@id=\"finish\"]/h4"));
        if (sign.isDisplayed()){
            System.out.println("Test 2 passed. Sign 'Hello World! appeared'");
        }
        else
            System.out.println("Test 2 failed");
    }

    private void browser_Action2() {
        WebElement link2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[2]"));
        link2.sendKeys(openLinkInNewTab);
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        Set<String> tab_handles = driver.getWindowHandles();
        int number_of_tabs = tab_handles.size();
        int new_tab_index = number_of_tabs-1;
        driver.switchTo().window(tab_handles.toArray()[new_tab_index].toString());
    }

    private void first_link_action() {
        WebElement btn_start = driver.findElement(By.tagName("button"));
        btn_start.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"finish\"]/h4")));
        WebElement sign = driver.findElement(By.xpath("//*[@id=\"finish\"]/h4"));
        if (sign.isDisplayed()){
            System.out.println("Test 1 passed. Sign 'Hello World! appeared'");
        }
        else
            System.out.println("Test 1 failed");
        Set<String> tab_handles = driver.getWindowHandles();
        int number_of_tabs = tab_handles.size();
        int new_tab_index = number_of_tabs-2;
        driver.switchTo().window(tab_handles.toArray()[new_tab_index].toString());
    }

    private void browser_Action1() {
        driver.get(path);
        driver.manage().window().maximize();
        WebElement link1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[1]"));
        link1.sendKeys(openLinkInNewTab);
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> tab_handles = driver.getWindowHandles();
        int number_of_tabs = tab_handles.size();
        int new_tab_index = number_of_tabs-1;
        driver.switchTo().window(tab_handles.toArray()[new_tab_index].toString());
    }
}
