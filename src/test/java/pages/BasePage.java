package pages;

import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class BasePage {
    public void checkPageIsOpened(){
       assertTrue(getPageIdentifier().isDisplayed());
    }
    protected abstract WebElement getPageIdentifier();
}
