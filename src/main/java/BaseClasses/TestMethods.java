package BaseClasses;

import BaseClasses.jsonData.UserData;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import java.util.ArrayList;

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

    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open();");        //otwiera nowa karte przez js
        ArrayList tabs = new ArrayList(driver.getWindowHandles());              //oblicza ilosc aktywnych kart
        driver.switchTo().window((String) tabs.get(1));                          //przechodzi do drugiej karty
    }

    /**Scroluje widok do podanego WebElementu*/
    public void ScroolToTheSomePoint(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }
}
