package ProcessingService;


import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;

import javax.inject.Singleton;

@Singleton
public class KafkaConsumerInitializer implements ApplicationEventListener<ServerStartupEvent> {

    private final KafkaConsumerService kafkaConsumerService;

    public KafkaConsumerInitializer(KafkaConsumerService kafkaConsumerService) {
        this.kafkaConsumerService = kafkaConsumerService;
    }

    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        kafkaConsumerService.processEmulationData();
    }
}




