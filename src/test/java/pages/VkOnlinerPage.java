package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VkOnlinerPage extends BasePage{
    private final SelenideElement pageName = $(".page_name");
    private final SelenideElement loginButton = $(".quick_login_button");

    @Override
    protected WebElement getPageIdentifier() {
        return loginButton;
    }

    @Step("Check if page is opened")
    public VkOnlinerPage checkIfVkPageOpen(){
        Selenide.switchTo().window(1);
        checkPageIsOpened();
        assertEquals("onlíner",pageName.getText());
        return this;
    }
}
