package BaseClasses;

import BaseClasses.jsonData.UserData;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import static java.util.concurrent.TimeUnit.SECONDS;

public class TestMethods {
    private WebDriver driver;

    public TestMethods(WebDriver driver) {
        this.driver = driver;

    }

    public WebDriver browserPicker() {
        if (UserData.browser.contains("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/geckodriver");
            driver = new FirefoxDriver();
        }
        else{
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
            driver = new ChromeDriver();}
        driver.manage().window().maximize();
        return driver;
    }

    public WebElement waitForIt(WebElement webElement) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(2, SECONDS)
                .ignoring(NoSuchElementException.class, ElementNotInteractableException.class);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return element;

    }


    public void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**jakis komentarz*/
}
