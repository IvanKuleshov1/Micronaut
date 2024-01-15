package EmulationService;

import javax.inject.Singleton;

//@Singleton
//public class EmulationService {
//
//    @Scheduled(fixedRate = "10s")
//    public void emulateValues() {
//        // Генерация случайных данных и отправка на шину Kafka
//        // Добавь код для генерации данных и отправки их в Kafka
//    }
//}

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Singleton
public class EmulationService  {

    private final KafkaProducerService kafkaProducerService;


    private final Random random = new Random();

    public EmulationService(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    public void emulateDataAndSendToKafka() {
//        kafkaProducerService.sendPerformanceData(generatePerformanceData());
//        kafkaProducerService.sendNetworkActivity(generateNetworkActivity());
//        kafkaProducerService.sendResourceUsage(generateResourceUsage());
        kafkaProducerService.sendSecurityData(generateSecurityData());
//        kafkaProducerService.sendAvailabilityData(generateAvailabilityData());
//        kafkaProducerService.sendEnergyConsumptionData(generateEnergyConsumptionData());
//        kafkaProducerService.sendComplianceData(generateComplianceData());
    }

    public PerformanceData generatePerformanceData() {
        double cpuLoad = random.nextDouble();
        double memoryUsage = random.nextDouble();
        double responseTime = random.nextDouble();

        return new PerformanceData(cpuLoad, memoryUsage, responseTime);
    }

    public NetworkActivity generateNetworkActivity() {
        double bandwidth = random.nextDouble();
        double dataTransmissionDelay = random.nextDouble();

        return new NetworkActivity(bandwidth, dataTransmissionDelay);
    }

    public ResourceUsage generateResourceUsage() {
        int activeSessions = random.nextInt(100);
        long availableDiskSpace = random.nextLong();

        return new ResourceUsage(activeSessions, availableDiskSpace);
    }
    public SecurityData generateSecurityData() {
        // Реализуй логику генерации случайных данных для безопасности (например, статус обнаружения атаки, уровень мониторинга и т.д.)
        boolean attackDetected = random.nextBoolean();
        int monitoringLevel = random.nextInt(3);

        return new SecurityData(attackDetected, monitoringLevel);
    }

    public AvailabilityData generateAvailabilityData() {
        // Реализуй логику генерации случайных данных для доступности (например, статус доступности, время простоя и т.д.)
        boolean isAvailable = random.nextBoolean();
        long downtimeDuration = random.nextLong();

        return new AvailabilityData(isAvailable, downtimeDuration);
    }

    public EnergyConsumptionData generateEnergyConsumptionData() {
        // Реализуй логику генерации случайных данных для потребления энергии (например, уровень энергопотребления, режим энергосбережения и т.д.)
        double energyConsumptionLevel = random.nextDouble();
        boolean powerSavingMode = random.nextBoolean();

        return new EnergyConsumptionData(energyConsumptionLevel, powerSavingMode);
    }

    public ComplianceData generateComplianceData() {
        // Реализуй логику генерации случайных данных для соответствия политикам и нормативам (например, статус соответствия, список нарушений и т.д.)
        boolean isCompliant = random.nextBoolean();
        List<String> violations = Arrays.asList("Violation1", "Violation2"); // Пример списка нарушений

        return new ComplianceData(isCompliant, violations);
    }


    // Добавь аналогичные методы для остальных параметров (Security, Availability, EnergyConsumption, Compliance)


}

