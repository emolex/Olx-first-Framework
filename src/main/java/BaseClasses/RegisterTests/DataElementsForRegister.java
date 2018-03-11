package BaseClasses.RegisterTests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public  class DataElementsForRegister {
    protected WebDriver driver;

    @FindBy(className = "user-box__photo")
    public WebElement myOlxButton;

    @FindBy(id = "register_tab")
    public WebElement registerPageButton;

    @FindBy(id = "userEmailRegister")
    public WebElement emailInput;

    @FindBy(id = "userPassRegister")
    public WebElement pass;

    @FindBy(xpath = "//*[@for='checkbox_accept-terms']")
    public WebElement acceptTerms;

    @FindBy(xpath = "//*[@for='checkbox_accept-newsletter']")
    public WebElement acceptNewsLetter;

    @FindBy(xpath = "//*[@id='button_register' or @id='se_userSignIn']")
    public WebElement sumbit;

    @FindBy(xpath = "//*[@class = 'xxx-large lheight24' or @class='error']")
    public static WebElement notify;

    @FindBy(xpath = "//*[@class = 'login-form__lostpassword']")
    public WebElement remindPassword;

    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(id = "userPass")
    public WebElement newPassword;



     DataElementsForRegister(WebDriver driver)  {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
