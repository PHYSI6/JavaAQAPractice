package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class OnlinerCatalogPage extends BasePage{
    private final SelenideElement catalogNavigationTitle = $(".catalog-navigation > .catalog-navigation__title");
    private final SelenideElement onlinerLogo = $(".b-top-logo");
    @Override
    protected WebElement getPageIdentifier() {
        return catalogNavigationTitle;
    }

    @Step("Click main onliner icon")
    public OnlinerMainPage clickOnlinerIcon(){
        onlinerLogo.click();

        return new OnlinerMainPage();
    }
}
