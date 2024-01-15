package EmulationService;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.TypeHint;

import java.io.Serializable;

@Introspected
public class PerformanceData implements Serializable {
    private double cpuLoad;
    private double memoryUsage;
    private double responseTime;

    public PerformanceData(double cpuLoad, double memoryUsage, double responseTime) {
        this.cpuLoad = cpuLoad;
        this.memoryUsage = memoryUsage;
        this.responseTime = responseTime;
    }

    // Добавь методы доступа
}
