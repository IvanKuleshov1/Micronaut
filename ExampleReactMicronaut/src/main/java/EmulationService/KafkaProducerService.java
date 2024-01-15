package EmulationService;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.annotation.Requires;
@KafkaClient
public interface KafkaProducerService {

    @Topic("emulation-topic") // Замени "emulation-topic" на название твоей темы в Kafka
    void sendPerformanceData(PerformanceData performanceData);

    @Topic("emulation-topic")
    void sendNetworkActivity(NetworkActivity networkActivity);

    @Topic("emulation-topic")
    void sendResourceUsage(ResourceUsage resourceUsage);
    @Topic("emulation-topic")
    void sendAvailabilityData(AvailabilityData availabilityData);
    @Topic("emulation-topic")
    void sendEnergyConsumptionData(EnergyConsumptionData energyConsumptionData);
    @Topic("emulation-topic")
    void sendComplianceData(ComplianceData complianceData);
    @Topic("emulation-topic")
    void sendSecurityData(SecurityData securityData);

    // Добавь методы для остальных типов данных
}
