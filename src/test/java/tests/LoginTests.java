package tests;

import baseTests.BaseTestUi;
import com.codeborne.selenide.WebDriverRunner;
import config.AppConfig;
import helpers.Cookie;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTestUi {
    LoginPage loginPage = new LoginPage();
    @DisplayName("LogIn test with correct data")
    @Owner("Daniil Borisevich")
    @Test
    public void loginWithCorrectDataTest(){
        loginPage
                .open()
                .verifyLoginPageIsOpen()
                .inputUsername(AppConfig.getProperty("USERNAME"))
                .inputPassword(AppConfig.getProperty("PASSWORD"))
                .clickLoginButton()
                .verifyHomePageIsOpen();

        Cookie.SaveCookie("sessionid");
    }

    @DisplayName("Like all photos in profile")
    @Owner("Daniil Borisevich")
    @Test
    public void likeAllPhotosInProfile() throws InterruptedException {
        loginPage.open();
        Cookie.DownloadCookie();
        WebDriverRunner.getWebDriver().navigate().refresh();
        new HomePage()
                .verifyHomePageIsOpen();
    }


}
