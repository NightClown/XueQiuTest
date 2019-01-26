package driver;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

class GlobalConfigTest {

    @Test
    void load(){
        GlobalConfig config = GlobalConfig.load("/data/global.yaml");
        assertThat(config, not(equalTo(null)));
        System.out.println(config);
        System.out.println(config.appiumConfig.url);
        System.out.println(config.appiumConfig.capabilities);
        System.out.println(config.appiumConfig.capabilities.get("appPackage"));
    }

}