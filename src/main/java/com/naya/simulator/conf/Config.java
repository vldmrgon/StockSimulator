package com.naya.simulator.conf;

import org.apache.spark.sql.SparkSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public SparkSession ss() {
        return SparkSession.builder()
                .master("local[*]")
                .appName("simulator")
                .getOrCreate();
    }
}
