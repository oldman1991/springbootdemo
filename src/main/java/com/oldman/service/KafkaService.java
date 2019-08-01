package com.oldman.service;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class KafkaService {

    public void do_post(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        List<String> interceptors = new ArrayList<>();
        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, interceptors);
        interceptors.add("com.oldman.interceptors.AddTimestampInterceptor");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i=0; i<100;i++){
            producer.send(new ProducerRecord<String, String>("test", Integer.toString(i), Integer.toString(i)));
        }
        producer.close();
    }
}
