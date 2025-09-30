package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@ParametersAreNonnullByDefault
public class BrowserstackMobileDriver implements WebDriverProvider {

    private static final BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @CheckReturnValue
    @Nonnull
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();
        
        caps.setCapability("browserName", "chrome");
        
        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", browserstackConfig.userName());
        bstackOptions.put("accessKey", browserstackConfig.accessKey());
        bstackOptions.put("deviceName", browserstackConfig.device());
        bstackOptions.put("osVersion", browserstackConfig.osVersion());
        bstackOptions.put("projectName", browserstackConfig.projectName());
        bstackOptions.put("buildName", browserstackConfig.buildName());
        bstackOptions.put("sessionName", browserstackConfig.sessionName());
        bstackOptions.put("debug", true);
        bstackOptions.put("consoleLogs", "info");
        bstackOptions.put("networkLogs", true);
        
        caps.setCapability("bstack:options", bstackOptions);
        
        try {
            return new RemoteWebDriver(new URL(browserstackConfig.remoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Неверный URL для Browserstack: " + browserstackConfig.remoteUrl(), e);
        }
    }
}
