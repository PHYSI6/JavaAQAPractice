package helpers;

import com.codeborne.selenide.WebDriverRunner;
import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Cookie {
    private static String filename = "src/test/resources/json/cookie.json";
    public static void SaveCookie(String name) {
        org.openqa.selenium.Cookie cookie = WebDriverRunner.getWebDriver().manage().getCookieNamed(name);
        try (JsonWriter writer = new JsonWriter(new FileWriter(filename))) {
            writer.beginObject();
            writer.name("name").value(cookie.getName());
            writer.name("value").value(cookie.getValue());
            writer.endObject();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void DownloadCookie(){
            Gson gson = new Gson();
            JsonStructure jsonStructure = new JsonStructure();
            try(FileReader reader = new FileReader(filename)) {
                jsonStructure = gson.fromJson(reader, JsonStructure.class);
            }
            catch (Exception e){
                System.out.println("Parsing error: " + e.getMessage());
            }

        WebDriverRunner.getWebDriver()
                .manage().addCookie(new org.openqa.selenium.Cookie(jsonStructure.name, jsonStructure.value));
    }
}
