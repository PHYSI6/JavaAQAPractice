package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;

import java.time.Duration;

public abstract class BasePage {
    public Duration DURATION_OF_WAITING = Duration.ofSeconds(Integer.parseInt(AppConfig.getProperty("DURATION_OF_WAITING")));
    public void checkPageIsOpened(){
       getPageIdentifier().shouldBe(Condition.enabled, DURATION_OF_WAITING);
    }
    protected abstract SelenideElement getPageIdentifier();
}
