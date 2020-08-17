package com.shadowmoses.api.stockapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
public class AlphaVantageAPIClient {
    @Value("${alphvantage.url}")
    private  String ALPHA_VANTAGE_URL;
    private static AlphaVantageAPIClient INSTANCE;

    private AlphaVantageAPIClient(){

    }

    private static AlphaVantageAPIClient getInstance(){
        if(INSTANCE == null){
            INSTANCE = new AlphaVantageAPIClient();
        }
        return INSTANCE;
    }
    
}
