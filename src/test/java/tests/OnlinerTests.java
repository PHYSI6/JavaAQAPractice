package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.OnlinerMainPage;
import pages.OnlinerProductPage;

@DisplayName("Onliner Tests")
public class OnlinerTests extends BaseTest{
   OnlinerMainPage onlinerMainPage = new OnlinerMainPage();

   @DisplayName("Search Test")
   @Owner("Daniil Borisevich")
   @ParameterizedTest
   @ValueSource(strings = {"Iphone XR", "Macbook Pro"})
    public void searchTest(String productName){
        onlinerMainPage
                .open()
                .clickSearchField()
                .inputTextSearchField(productName)
                .checkFirstProductTitle(productName);
    }

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

    @DisplayName("Product navigation test")
    @Owner("Daniil Borisevich")
    @ParameterizedTest
    @ValueSource(strings = {"Macbook Pro", "Apple Watch"})
    public void productNavigationTest(String productName) {
        String productFullName = onlinerMainPage
                .open()
                .clickSearchField()
                .inputTextSearchField(productName).getFirstProductTitle();

        onlinerMainPage.clickFirstProduct().checkIfOpenedCorrectProduct(productFullName);
    }
}
