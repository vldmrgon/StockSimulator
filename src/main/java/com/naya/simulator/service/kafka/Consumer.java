package com.naya.simulator.service.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class Consumer {

    public static void main(String[] args) {
        final Properties prop = new Properties();
        prop.put("bootstrap.servers", "localhost:29092");
        prop.put("session.timeout", 10_000);
        prop.put("group.id", "test");
        prop.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        prop.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        final KafkaConsumer<Object, Object> consumer = new KafkaConsumer<>(prop);
        consumer.subscribe(Arrays.asList("stock-updates"));

        while (true) {
            final ConsumerRecords<Object, Object> records = consumer.poll(100);
            records.forEach(e -> System.out.println(e.offset() + " " + e.value()));
        }
    }
}
