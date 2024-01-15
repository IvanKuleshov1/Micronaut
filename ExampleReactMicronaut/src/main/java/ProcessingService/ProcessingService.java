package ProcessingService;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaListener(groupId = "processing-group", offsetReset = OffsetReset.EARLIEST)
public class ProcessingService {

    @Topic("emulation-topic")
    public void processEmulationData(String data) {
        System.out.println("Received message: " + data);
        // Обработка данных в соответствии с бизнес-логикой
        // Передача данных во frontend
    }
}