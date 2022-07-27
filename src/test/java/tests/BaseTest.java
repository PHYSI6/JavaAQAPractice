package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    public void tearDown(){
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }

}
