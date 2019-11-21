package edu.bitcs.rate_my_professor;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchRestClient {
    private static String ipPort = "127.0.0.1:9200";

    @Bean
    public RestClientBuilder restClientBuilder(){
        return RestClient.builder(makeHttpHost(ipPort));
    }

    @Bean
    public RestHighLevelClient restHighLevelClient(@Autowired RestClientBuilder restClientBuilder){
        return new RestHighLevelClient(restClientBuilder);
    }

    private HttpHost makeHttpHost(String s){
        String [] strings = s.split(":") ;

        String ip = strings[0];
        int port = Integer.parseInt(strings[1]);

        return new HttpHost(ip,port,"http");
    }

}
