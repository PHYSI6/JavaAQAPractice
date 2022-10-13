package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage extends BasePage{
    private final SelenideElement profileName = $(By.tagName("h1"));
    @Override
    protected SelenideElement getPageIdentifier() {
        return profileName;
    }

    @Step("Verify Profile page is open")
    public ProfilePage verifyProfilePageIsOpen(){
        checkPageIsOpened();

        return this;
    }
}
