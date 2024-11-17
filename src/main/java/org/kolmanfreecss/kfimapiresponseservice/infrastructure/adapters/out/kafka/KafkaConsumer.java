package org.kolmanfreecss.kfimapiresponseservice.infrastructure.adapters.out.kafka;

import lombok.extern.slf4j.Slf4j;
import org.kolmanfreecss.kfimapiresponseservice.domain.dto.IncidentDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * KafkaConsumer
 * Used to consume messages from Kafka.
 * 
 * @version 1.0
 */
@Slf4j
@Component
public class KafkaConsumer {
    
    public static final String NOTIFICATION_TOPIC = "kf_imapi_notification_channel";
    
    public static final String GROUP_ID = "kf-imapi-response-consumer";

    @KafkaListener(topics = NOTIFICATION_TOPIC, groupId = GROUP_ID)
    public void notificationEventConsumer(final IncidentDto message) {
        log.info("Consumer consume Kafka message -> {}", message);

        // write your handlers and post-processing logic, based on your use case
    }

}