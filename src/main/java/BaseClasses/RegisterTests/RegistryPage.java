package BaseClasses.RegisterTests;


import BaseClasses.TestMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.testng.Assert;

public class RegistryPage extends DataElementsForRegister {

    private TestMethods tm;

    public void checkNotify(WebElement element, String actualText) {
        String webText = tm.waitForIt(element).getText().toString();
        Assert.assertEquals(webText, actualText);
    }


    public void submitButton () {
        tm.waitForIt(sumbit).submit();
    }

    public void acceptTerms() {
        tm.waitForIt(acceptTerms).click();
    }

    public void acceptNewsLetter(){
        tm.waitForIt(acceptNewsLetter).click();
    }

    public void registryUniversalMethod(String...args) {
        tm.waitForIt(myOlxButton).click();
        tm.waitForIt(registerPageButton).click();
        tm.waitForIt(emailInput).sendKeys(args[0]);
        tm.waitForIt(pass).sendKeys(args[1]);
    }

    public void PasswordReset (String... args) {
        tm.waitForIt(myOlxButton).click();
        tm.waitForIt(remindPassword).click();
        tm.waitForIt(userEmail).sendKeys(args[0]);
        tm.waitForIt(newPassword).sendKeys(args[1]);
    }


    public RegistryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        tm = new TestMethods(driver);
        PageFactory.initElements(driver, this);
    }
}
