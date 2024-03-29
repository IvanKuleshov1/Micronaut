package ivan.k.services;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.messaging.annotation.MessageBody;
import ivan.k.services.integration.Trip;

@KafkaClient
public interface TripClient {

    @Topic("trips")
    void send(@MessageBody Trip trip);

}
