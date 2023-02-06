package com.chunhodong.chbook.adapter;

import com.chunhodong.chbook.config.KafkaProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class RentalProducerImpl implements RentalProducer {
    private static final String TOPIC_BOOK = "topic_book";
    private static final String TOPIC_CATALOG = "topic_catalog";
    private static final String TOPIC_POINT = "topic_point";
    private final KafkaProperties kafkaProperties;
    private KafkaProducer<String, String> producer;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void initialize() {
        this.producer = new KafkaProducer<String, String>(kafkaProperties.getProducerProps());
    }

    @Override
    public void updateBookStatus(Long bookId, String bookStatus) {


    }

    @Override
    public void savePoints(Long userId, int pointPerBooks) {

    }

    @Override
    public void updateBookCatalogStatus(Long bookId, String eventType) {

    }
}
