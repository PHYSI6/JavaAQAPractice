package tests;

import config.AppConfig;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginTests {
    LoginPage loginPage = new LoginPage();

    @DisplayName("LogIn test with correct data")
    @Owner("Daniil Borisevich")
    @Test
    public void loginWithCorrectDataTest() throws InterruptedException {
        loginPage
                .open()
                .verifyLoginPageIsOpen()
                .inputUsername(AppConfig.getProperty("USERNAME"))
                .inputPassword(AppConfig.getProperty("PASSWORD"))
                .clickLoginButton()
                .verifyHomePageIsOpen();

        Thread.sleep(4000);
    }
}
