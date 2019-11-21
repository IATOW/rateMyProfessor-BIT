package edu.bitcs.rate_my_professor;

import edu.bitcs.rate_my_professor.services.IdHelper;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.h2.H2ConsoleProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RateMyProfessorApplication {

    private final static String LOCALHOST = "localhost";
    private final static int PORT = 9200;

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(RateMyProfessorApplication.class, args);

        RestHighLevelClient restHighLevelClient = applicationContext.getBean(RestHighLevelClient.class);

    }
}
