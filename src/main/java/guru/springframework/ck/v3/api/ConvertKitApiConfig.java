package guru.springframework.ck.v3.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 11/16/16.
 */
@ConfigurationProperties(prefix = "guru.springframework")
public class ConvertKitApiConfig {

    private String ckApiKey;
    private String ckApiSecret;

    public String getCkApiKey() {
        return ckApiKey;
    }

    public void setCkApiKey(String ckApiKey) {
        this.ckApiKey = ckApiKey;
    }

    public String getCkApiSecret() {
        return ckApiSecret;
    }

    public void setCkApiSecret(String ckApiSecret) {
        this.ckApiSecret = ckApiSecret;
    }
}
