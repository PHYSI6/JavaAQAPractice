package testsUI;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.OnlinerMainPage;

@DisplayName("Onliner other tests")
public class OnlinerOtherTests extends BaseTest{
    OnlinerMainPage onlinerMainPage = new OnlinerMainPage();

    @DisplayName("Cart test")
    @Owner("Daniil Borisevich")
    @Test
    public void cartCheck() {
        onlinerMainPage
                .open()
                .clickCartIcon()
                .checkPageIsOpened();
    }

    @DisplayName("VK link test")
    @Owner("Daniil Borisevich")
    @Test
    public void vkLinkTest() {
        onlinerMainPage
                .open()
                .clickVkIcon()
                .checkIfVkPageOpen();
    }

    @DisplayName("Onliner main icon test")
    @Owner("Daniil Borisevich")
    @Test
    public void mainIconTest() {
        onlinerMainPage
                .open()
                .clickNavigationItem()
                .clickOnlinerIcon()
                .checkPageIsOpened();
    }
}
