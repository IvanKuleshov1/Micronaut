package EmulationService;


import java.util.List;

public class ComplianceData {
    private boolean isCompliant;
    private List<String> violations;

    public ComplianceData(boolean isCompliant, List<String> violations) {
        this.isCompliant = isCompliant;
        this.violations = violations;
    }

    // Добавь методы доступа
}
