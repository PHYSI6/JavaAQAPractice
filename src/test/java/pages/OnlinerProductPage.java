package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlinerProductPage extends BasePage{
    private final SelenideElement productTitle = $(".catalog-masthead__title");
    @Override
    protected WebElement getPageIdentifier() {
        return productTitle;
    }

    @Step("Check if opened correct product")
    public OnlinerProductPage checkIfOpenedCorrectProduct(String expectedProductTitle){
        assertEquals(expectedProductTitle, productTitle.getText(), "Was opened wrong product!");

        return this;
    }
}
