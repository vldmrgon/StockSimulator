package com.naya.simulator.service.kafka;

import lombok.SneakyThrows;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
//34.132.121.109:9092
    @SneakyThrows
    public void sendMessageToKafka(String topicName, String topicMessage) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:39092");
        props.put("batch.size", 65536);
        props.put("buffer.memory", 1_000_000);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        final KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        producer.send(new ProducerRecord<>(topicName, topicMessage));
        System.out.println(topicMessage);
        producer.close();
    }
}
