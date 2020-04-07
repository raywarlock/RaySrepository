import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class QtyOfObjects {
    WebDriver driver;
    String path = "https://the-internet.herokuapp.com/disappearing_elements";

    @BeforeSuite
    public void Setup(){

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        //System.setProperty("webdriver.edge.driver", "C:\\Users\\Owner\\IdeaProjects\\untitled3\\src\\test\\resources\\msedgedriver.exe");
        //driver = new EdgeDriver();
    }

    @Test
    public void Test(){
        initialCheck();

    }

    public void refresh2Check(int RfrshSz, int intlSz) {
        driver.navigate().refresh();
        WebDriverWait wait2 = new WebDriverWait(driver, 5);
        wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("li")));
        ArrayList buttonsRfrsh2 = (ArrayList) driver.findElements(By.tagName("li"));
        int Rfrsh2Sz = buttonsRfrsh2.size();
        System.out.println("After 2nd refresh q-ty of buttons is " + Rfrsh2Sz);
        if (Rfrsh2Sz == RfrshSz) {
            System.out.println("Nothing is changed. Still " + Rfrsh2Sz + " buttons");
        }
        else {
            if (Rfrsh2Sz == intlSz) {
                System.out.println("Q-ty of buttons equals initial condition " + intlSz + " buttons");
                driver.quit();
            }
        }
    }

        public void refresh1Check(int intlSz){
        driver.navigate().refresh();
        WebDriverWait wait1 = new WebDriverWait(driver, 5);
        wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("li")));
        ArrayList buttonsRfrsh = (ArrayList) driver.findElements(By.tagName("li"));
        int RfrshSz = buttonsRfrsh.size();
        System.out.println("After refresh q-ty of buttons is " + RfrshSz);
        if (intlSz == RfrshSz){
            System.out.println("all buttons are present");
        }
        else
            System.out.println((intlSz-RfrshSz) + " button(s) missing");
        refresh2Check(RfrshSz, intlSz);

    }

    public void initialCheck() {
        driver.get(path);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("li")));
        ArrayList buttonsIntl = (ArrayList) driver.findElements(By.tagName("li"));
        int intlSz = buttonsIntl.size();
        System.out.println("Initial q-ty of buttons is " + intlSz);
        refresh1Check(intlSz);
    }


}