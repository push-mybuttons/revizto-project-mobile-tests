package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("browserstack.user")
    String userName();

    @Key("browserstack.key")
    String accessKey();

    @Key("browserstack.url")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String remoteUrl();

    @Key("browserstack.device")
    @DefaultValue("iPhone 13")
    String device();

    @Key("browserstack.osVersion")
    @DefaultValue("15")
    String osVersion();

    @Key("browserstack.projectName")
    @DefaultValue("Revizto Mobile Tests")
    String projectName();

    @Key("browserstack.buildName")
    @DefaultValue("Mobile Tests Build")
    String buildName();

    @Key("browserstack.sessionName")
    @DefaultValue("Mobile Test Session")
    String sessionName();
}
