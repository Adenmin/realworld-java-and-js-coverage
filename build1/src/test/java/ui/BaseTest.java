package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    public static String user = "test";
    public static String email = "test@test.test";
    public static String password = "test123";

    @BeforeAll
    public static void beforeAll() {
        String appHost = System.getProperty("appHost","localhost");
        String remoteHost=System.getProperty("remoteHost","localhost");
        Configuration.baseUrl = String.format("http://%s:8080",appHost);
        Configuration.remote = String.format("http://%s:4444/wd/hub",remoteHost);
        Configuration.browserCapabilities.setCapability("enableVNC", true);
        Configuration.browser = "chrome";
        open(Configuration.baseUrl);
    }

    @AfterAll
    public static void afterAll() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        closeWindow();
    }

    @BeforeEach
    public void openBaseUrl() {
        open(Configuration.baseUrl);
    }
}
