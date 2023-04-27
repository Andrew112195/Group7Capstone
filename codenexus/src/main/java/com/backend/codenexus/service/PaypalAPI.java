package com.backend.codenexus.service;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.paypal.base.rest.OAuthTokenCredential;
import java.util.Map;

import java.util.HashMap;

@Configuration
public class PaypalAPI {
    @Value("AYw1gEKuMelYOSUlhuciDjuskNpZZrGEdS7Amk1v4WHwz04fKF8tT4ok6nE48_Bu9dF2rHo2Z80HmOIm")
    private String clientID;

    @Value("EADKiuGikiLUs2LiTb-QzVVOYw3jmWSQ6POa-V1I4Lgugi_PHFBg-4iwi1baj4ixPB8emz3jS6oztLBx")
    private String clientSecret;

    @Value("${paypal.client.mode}")
    private String clientMode;

    @Bean
    public Map<String, String> apiConfig()
    {
        Map<String, String> config = new HashMap<>();
        config.put("mode", clientMode);
        return config;
    }
    @Bean
    public OAuthTokenCredential sandBoxToken()
    {
        return new OAuthTokenCredential(clientID,clientSecret,apiConfig());
    }
    @Bean
    public APIContext apiInitialize() throws PayPalRESTException {
        APIContext tempInit = new APIContext(sandBoxToken().getAccessToken());
        tempInit.setConfigurationMap(apiConfig());
        return tempInit;
    }
}
