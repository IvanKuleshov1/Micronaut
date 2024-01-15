package EmulationService;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import jakarta.inject.Singleton;

@Singleton
public class EmulationServiceInitializer implements ApplicationEventListener<StartupEvent> {

    private final EmulationService emulationService;

    public EmulationServiceInitializer(EmulationService emulationService) {
        this.emulationService = emulationService;
    }

    @Override
    public void onApplicationEvent(StartupEvent event) {
        emulationService.emulateDataAndSendToKafka();
    }
}
