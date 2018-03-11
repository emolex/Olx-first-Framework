package BaseClasses.LoginTests;

import BaseClasses.TestMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.testng.Assert;

public class LoginPage extends DataElementsForLogin{
    private TestMethods tm;

    public void checkNotify(WebElement element, String actualText) {
        String webText = tm.waitForIt(element).getText().toString();
        Assert.assertEquals(webText, actualText);
    }

    public void loginSucces(String...args) {
        tm.waitForIt(myOlxButton).click();
    tm.waitForIt(loginPageButton).click();
    tm.waitForIt(userEmail).sendKeys(args[0]);
    tm.waitForIt(pass).sendKeys(args[1]);
    tm.waitForIt(LogInButton).click();
    }


    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        tm = new TestMethods(driver);
        PageFactory.initElements(driver, this);
    }
}
