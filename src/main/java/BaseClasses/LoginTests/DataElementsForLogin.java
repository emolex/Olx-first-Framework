package BaseClasses.LoginTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataElementsForLogin {
    protected WebDriver driver;


    @FindBy(className = "user-box__photo")
    public WebElement myOlxButton;

    @FindBy(id = "login_tab")
    protected WebElement loginPageButton;

    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(id = "userPass")
    public  WebElement pass;

    @FindBy(id = "se_userLogin")
    public static WebElement LogInButton;

    @FindBy(xpath = "//*[@class='fright button cfff br3 x-large']")
    public static WebElement payBalance;

    @FindBy(xpath = "//*[@for='checkbox_user-remember']")
    public  WebElement remeberMeCheckbox;

    @FindBy(xpath = "//*[@class='login-form__othermethods']")
    public  WebElement otherLoginMethodButton;

    @FindBy(xpath = "//*[@class = 'xxx-large lheight24' or @class='error']")
    public static WebElement notify_login;

    @FindBy(xpath = "//*[@class='user-box__photo']")
    public static WebElement userBox;

    @FindBy (id = "login-box-logout")
    protected WebElement logOut;





    DataElementsForLogin(WebDriver driver)  {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
