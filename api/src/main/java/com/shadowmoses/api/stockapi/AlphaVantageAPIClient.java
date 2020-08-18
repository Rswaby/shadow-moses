package com.shadowmoses.api.stockapi;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
public class AlphaVantageAPIClient {
    @Value("${alphvantage.url}")
    private  String ALPHA_VANTAGE_URL;
//    @Autowired
//    WebClient client;
    private static final String TIME_SERIES_MONTHLY_ADJUSTED = "TIME_SERIES_MONTHLY_ADJUSTED";
    private static final String TIME_SERIES_WEEKLY_ADJUSTED = "TIME_SERIES_WEEKLY_ADJUSTED";
    private final String APIKEY = "Demo";
    private static AlphaVantageAPIClient INSTANCE;

    private AlphaVantageAPIClient(){

    }

    private static AlphaVantageAPIClient getInstance(){
        if(INSTANCE == null){
            INSTANCE = new AlphaVantageAPIClient();
        }
        return INSTANCE;
    }

    private void fetch(final String symbol, final String function){
        TcpClient tcpClient = TcpClient
                .create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS));
                    connection.addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS));
                });

        WebClient client = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
                .build();

        String url = "https://www.alphavantage.co/" +
                "query?function=" + function +
                "&" +
                "symbol=" + symbol +
                "&" +
                "apikey=" + APIKEY ;
       log.info("------------fetching----------");
       log.info(url);
       Flux<String> response = client.get()
                .uri(url)
                .retrieve()
                .bodyToFlux(String.class);
       log.info("------------received---------");
       log.info(response.toStream().collect(Collectors.joining()));

    }

    public static void getMonthlyAdjusted(final String sym){
        getInstance().fetch(sym,TIME_SERIES_MONTHLY_ADJUSTED);
    }

    public static void getWeeklyAdjusted(final String sym){
        getInstance().fetch(sym,TIME_SERIES_WEEKLY_ADJUSTED);
    }
}
