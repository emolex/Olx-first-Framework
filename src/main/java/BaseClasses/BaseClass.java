package BaseClasses;


import BaseClasses.LoginTests.LoginPage;
import BaseClasses.RegisterTests.RegistryPage;
import BaseClasses.jsonData.JsonParser;

import static BaseClasses.BaseMethods.*;
import static BaseClasses.RegisterTests.DataElementsForRegister.*;
import static BaseClasses.LoginTests.DataElementsForLogin.*;
import BaseClasses.jsonData.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.*;

public class BaseClass {

    public WebDriver driver;
    protected TestMethods testMethods;
    public RegistryPage register;
    public BaseMethods baseMethods;
    public LoginPage login;

    BaseClass() {
        PageFactory.initElements(driver, this);
    }

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        JsonParser.parseJson();
        testMethods = new TestMethods(driver);
        driver = testMethods.browserPicker();
        register = new RegistryPage(driver);
        login = new LoginPage(driver);
        baseMethods = new BaseMethods();
    }

    @BeforeMethod(alwaysRun = true)
    public void getUrl(){
        driver.get("https://www.olx.pl/");
    }

    @Test(groups = {"register", "success"})
    public void RegisterSucces() {
        register.registryUniversalMethod(generateRandomEmail(),generateRandomString(6)+"A!");
        register.acceptTerms();
        register.submitButton();
        register.checkNotify(notify, "Teraz musisz aktywować swoje konto!");
    }

    @Test(groups = "register")
    public void RegisterWithoutEmail() {
        register.registryUniversalMethod(generateRandomString(0),generateRandomString(8));
        register.acceptTerms();
        register.submitButton();
        register.checkNotify(notify, "To pole jest wymagane");
    }

    @Test(groups = "register")
    public void RegisterWithoutPass() {
        register.registryUniversalMethod(generateRandomEmail(),generateRandomString(0));
        register.acceptTerms();
        register.submitButton();
        register.checkNotify(notify, "To pole jest wymagane");
    }


    @Test(groups = "register")
    public void RegisterWithoutAcceptTerms() {
        register.registryUniversalMethod(generateRandomEmail(),generateRandomString(8));
        register.submitButton();
        register.checkNotify(notify, "Musisz najpierw zaakceptować regulamin");
    }

    @Test(groups = "register")
    public void RegisterWithWrongEmailFormat() {
        register.registryUniversalMethod(generateRandomString(5),generateRandomString(8));
        register.acceptTerms();
        register.submitButton();
        register.checkNotify(notify, "Niepoprawny format e-mail");
    }

    @Test(groups = "register", priority = 1)
    public void RegisterWithWrongPass() {
        register.registryUniversalMethod(generateRandomEmail(),generateRandomString(5));
        register.acceptTerms();
        register.submitButton();
        register.checkNotify(notify, "Proszę wpisać co najmniej 6 znaków.");
    }

    @Test(groups = "register", priority = 1)  //po wywolaniu testu RegisterSucces() strona czasem przekierowuje na strone z komunikatem o błędzie.
    public void RegisterWithNewsLetter() {
        register.registryUniversalMethod(generateRandomEmail(),generateRandomString(6)+"A!");
        register.acceptTerms();
        register.acceptNewsLetter();
        register.submitButton();
        register.checkNotify(notify, "Teraz musisz aktywować swoje konto!");
    }

    @Test (groups = {"resetPassword", "success"})
    public void ResetPassword() {
        register.PasswordReset(generateRandomEmail(),generateRandomString(6)+"A!");
        register.submitButton();
        register.checkNotify(notify, "Teraz musisz aktywować swoje nowe hasło!");
    }

    @Test (groups = "resetPassword")
    public void ResetPasswordWithoutEmail() {
        register.PasswordReset(generateRandomString(0),generateRandomString(6)+"A!");
        register.submitButton();
        register.checkNotify(notify, "To pole jest wymagane");
    }

    @Test (groups = "resetPassword")
    public void ResetPasswordWithouNewPass() {
        register.PasswordReset(generateRandomEmail(),generateRandomString(0));
        register.submitButton();
        register.checkNotify(notify, "To pole jest wymagane");
    }

    @Test (groups = "resetPassword")
    public void ResetPasswordWithShortPAss() {
        register.PasswordReset(generateRandomEmail(),generateRandomString(4));
        register.submitButton();
        register.checkNotify(notify, "Nie może być krótsze niż 6 znaków");
    }


    @Test (groups = {"login", "success"})
    public void LoginSuccess () {
        login.loginSucces(UserData.email, UserData.pass);
    }

    @Test (groups = {"login"})
    public void LoginWithoutEmail() {
        login.loginSucces("", UserData.pass);
        login.checkNotify(notify_login, "To pole jest wymagane");
    }

    @Test (groups = {"login"})
    public void LoginWithoutPass() {
        login.loginSucces(UserData.email, generateRandomString(0));
        login.checkNotify(notify_login, "To pole jest wymagane");
    }

    @Test (groups = {"login"})
    public void LoginWithWrongEmail() {
        login.loginSucces(generateRandomEmail(), UserData.pass);
        login.checkNotify(notify_login, "nieprawidłowy login lub hasło");
    }

    @Test (groups = {"login"})
    public void LoginWithWrongPass() {
        login.loginSucces(UserData.email,generateRandomString(8));
        login.checkNotify(notify_login, "nieprawidłowy login lub hasło");
    }

    @Test
    public void RegisterAlreadyExistedUser() {
        register.registryUniversalMethod(UserData.email,generateRandomString(6)+"A!");
        register.acceptTerms();
        register.submitButton();
        register.checkNotify(notify, "Teraz musisz aktywować swoje konto!");
    }

    @Test (dependsOnMethods = "LoginSuccess")
    public void LogOutTest() {
        login.LogOut();
        testMethods.sleep(5000);
    }

    @AfterMethod
    public void closeTestCase(){
//        driver.manage().deleteAllCookies();
    }

    @AfterTest (alwaysRun = true)
    public void tearDown() {
        testMethods.sleep(2000);
        driver.close();

    }

}

