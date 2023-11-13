package br.com.datawake.datawakeapi.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
public class AppProperties {

    private String corsAllowOrigin;
    private String keyToken;

    public String getCorsAllowOrigin() {
        return corsAllowOrigin;
    }

    public void setCorsAllowOrigin(String corsAllowOrigin) {
        this.corsAllowOrigin = corsAllowOrigin;
    }

    public String getKeyToken() {
        return keyToken;
    }

    public void setKeyToken(String keyToken) {
        this.keyToken = keyToken;
    }

}
