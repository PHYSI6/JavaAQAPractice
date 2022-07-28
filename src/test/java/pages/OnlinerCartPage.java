package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnlinerCartPage extends BasePage {
    private final SelenideElement title = $(".cart-form__title");
    private final String END_POINT = "/";

    @Step("Open page by url: " + AppConfig.cartUrl + END_POINT)
    public OnlinerCartPage open(){
        Selenide.open(AppConfig.cartUrl + END_POINT);
        checkPageIsOpened();

        return this;
    }
    @Override
    protected WebElement getPageIdentifier() {
        return title;
    }
}
