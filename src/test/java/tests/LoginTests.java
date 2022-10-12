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
                .inputUsername(AppConfig.getProperty("USERNAME"))
                .inputPassword(AppConfig.getProperty("PASSWORD"))
                .clickLoginButton()
                .clickProfileIcon();

        Thread.sleep(4000);
    }
}
