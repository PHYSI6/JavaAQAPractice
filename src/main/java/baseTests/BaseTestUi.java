package baseTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import helpers.Attach;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTestUi {
    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    public void tearDown(){
        Attach.screenshotAs("Last screenshot");
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}
