package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.MobileConfig;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    
    protected static MobileConfig mobileConfig;
    private static boolean isRemoteRun;

    @BeforeAll
    public static void setUp() {
        String environment = System.getProperty("environment", "local");
        isRemoteRun = "remote".equals(environment);
        
        Properties properties = new Properties();
        properties.putAll(System.getProperties());
        if (isRemoteRun) {
            properties.setProperty("isRemote", "true");
        }
        
        mobileConfig = ConfigFactory.create(MobileConfig.class, properties);
        
        Configuration.baseUrl = mobileConfig.baseUrl();
        Configuration.browserSize = null;
        Configuration.reopenBrowserOnFail = false;
        Configuration.fastSetValue = true;
        Configuration.clickViaJs = false;
        
        if (isRemoteRun || mobileConfig.isRemote()) {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        } else {
            Configuration.browser = LocalMobileDriver.class.getName();
        }
        
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    public void openPage() {
        open("/");
    }

    @AfterEach
    public void tearDown() {
        try {
            Attachments.screenshotAs("Скриншот");
            
            if (isRemoteRun || mobileConfig.isRemote()) {
                String sessionId = Attachments.getSessionId();
                Attachments.addVideo(sessionId);
            }
        } catch (Exception e) {
            System.err.println("Ошибка при добавлении attachments: " + e.getMessage());
        } finally {
            closeWebDriver();
        }
    }
}
