package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {
    private final SelenideElement profileIcon = $(By.xpath("//span[@role='link']"));
    private final SelenideElement profileButton = $(By.xpath("(//a/div[@aria-labelledby])[1]"));

    @Override
    protected SelenideElement getPageIdentifier() {
        return profileIcon;
    }
    @Step("Verify Home page is open")
    public HomePage verifyHomePageIsOpen(){
        checkPageIsOpened();

        return this;
    }

    @Step("Click profile icon")
    public HomePage clickProfileIcon(){
        profileIcon.click();

        return this;
    }

    @Step("Click profile button")
    public ProfilePage clickProfileButton(){
        profileButton.click();

        return new ProfilePage();
    }
}
