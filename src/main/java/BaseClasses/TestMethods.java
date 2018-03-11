package BaseClasses;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.Random;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TestMethods {
    private WebDriver driver;

    private final static char[] chars = "abcdefghijklmnoprstqwuxyz".toCharArray();


    public TestMethods(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement waitForIt(WebElement webElement) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(2, SECONDS)
                .ignoring(NoSuchElementException.class, ElementNotInteractableException.class);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return element;
    }

    public static String generateRandomString(int length) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars[r.nextInt(25)]);
        }
        return sb.toString();
    }


    public static String generateRandomEmail() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r.nextInt(7) + 5; i++) {
            sb.append(chars[r.nextInt(25)]);
        }
        sb.append("@gmail.com");
        return sb.toString();
    }

    public void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




















    public WebDriver browserPicker(String browser) {
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/geckodriver");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                return driver;
        }
        return driver;
    }

}
