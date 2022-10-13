package pages;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
public class LoginPage extends BasePage{

    private final SelenideElement usernameField = $(By.xpath("//input[@name='username']"));
    private final SelenideElement passwordField = $(By.xpath("//input[@name='password']"));
    private final SelenideElement logInButton = $(By.xpath("//button[@type='submit']"));
    private final String END_POINT = "/";

    @Override
    protected SelenideElement getPageIdentifier() {
        return passwordField;
    }

    @Step("Open LogIn page")
    public LoginPage open(){
        Selenide.open(AppConfig.getProperty("BASE_URL") + END_POINT);

        return this;
    }
    @Step("Verify LogIn page is open")
    public LoginPage verifyLoginPageIsOpen(){
        checkPageIsOpened();

        return this;
    }

    @Step("Input {0} into username field")
    public LoginPage inputUsername(String username){
        usernameField.sendKeys(username);

        return this;
    }

    @Step("Input {0} into password field")
    public LoginPage inputPassword(String password){
        passwordField.sendKeys(password);

        return this;
    }

    @Step("Click LogIn button")
    public HomePage clickLoginButton(){
        logInButton.click();

        return new HomePage();
    }
}
