package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {
    private final SelenideElement profileIcon = $(By.xpath("//img[@crossorigin]"));
    @Override
    protected SelenideElement getPageIdentifier() {
        return profileIcon;
    }

    @Step("Click profile icon")
    public HomePage clickProfileIcon(){
        profileIcon.click();

        return this;
    }
}
