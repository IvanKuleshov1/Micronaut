package ProcessingService;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaListener(offsetReset = OffsetReset.EARLIEST) // Adjust offsetReset as needed
public class KafkaConsumerService {

    // Existing methods...

    @Topic("emulation-topic")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
        // Add your logic to process the received message
    }

    public void processEmulationData() {
        // Add your logic for processing emulation data
        System.out.println("Kafka consumer service initialized and ready to process emulation data.");
    }
}

