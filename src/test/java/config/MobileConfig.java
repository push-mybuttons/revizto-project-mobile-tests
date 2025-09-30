package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:remote.properties", 
        "classpath:local.properties"   
})
public interface MobileConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://revizto.com")
    String baseUrl();

    @Key("workSpaceUrl")
    @DefaultValue("https://ws.revizto.com/")
    String workSpaceUrl();

    @Key("browserName")
    @DefaultValue("chrome")
    String browserName();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("390x844")
    String browserSize();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();
}
