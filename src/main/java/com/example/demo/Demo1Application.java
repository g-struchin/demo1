package com.example.demo;

import com.example.demo.openweathermap.DateList;
import com.example.demo.openweathermap.RequestQuoteOWM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@SpringBootApplication
public class Demo1Application {
    private static final Logger log = LoggerFactory.getLogger(Demo1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            RequestQuoteOWM requestQuoteOWM = restTemplate.getForObject( "https://api.openweathermap.org/data/2.5/forecast/daily?q=Moscow&appid=34e1aea99c1fdd26f9a980501f000ce5", RequestQuoteOWM.class);
            log.info(requestQuoteOWM.getCity().getName());
            ArrayList<DateList> list = requestQuoteOWM.getList();
            if (requestQuoteOWM.getList().isEmpty())
                log.info("list.size()"+" = empty");
            else {
                log.info(String.valueOf(requestQuoteOWM.getList().size()));
            }
            for (int i = 0; i < requestQuoteOWM.getList().size(); i++)
                log.info(i+" - "+requestQuoteOWM.getList().get(i).getTemp().getDay());
        };
    }
}
