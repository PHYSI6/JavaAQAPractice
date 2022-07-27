package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.OnlinerMainPage;

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
               .checkIfPageOpen();
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
}
