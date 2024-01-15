package ivan.k.services.service;

import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ivan.k.services.client.DriverClient;
import ivan.k.services.client.OrderClient;
import ivan.k.services.integration.Order;
import ivan.k.services.integration.OrderType;
import ivan.k.services.integration.Trip;
import ivan.k.services.model.Driver;
import ivan.k.services.model.DriverStatus;
import ivan.k.services.repository.DriverInMemoryRepository;

import java.util.Optional;

@Singleton
public class DriverService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverService.class);

    private DriverClient client;
    private OrderClient orderClient;
    private DriverInMemoryRepository repository;

    public DriverService(DriverClient client, OrderClient orderClient, DriverInMemoryRepository repository) {
        this.client = client;
        this.orderClient = orderClient;
        this.repository = repository;
    }

    public void processNewTripOrder(Order order) {
        LOGGER.info("Processing: {}", order);
        Optional<Driver> driver = repository.findNearestDriver(order.getCurrentLocationX(), order.getCurrentLocationY());
        if (driver.isPresent()) {
            Driver driverLocal = driver.get();
            driverLocal.setStatus(DriverStatus.UNAVAILABLE);
            repository.updateDriver(driverLocal);
            client.send(driverLocal, String.valueOf(order.getId()));
            LOGGER.info("Message sent: {}", driverLocal);
        }
    }

    public void processTripRejected(Trip trip) {
        LOGGER.info("Processing: {}", trip);
        Optional<Driver> driver = repository.findById(trip.getDriverId());
        driver.ifPresent(driverLocal -> {
            driverLocal.setStatus(DriverStatus.AVAILABLE);
            repository.updateDriver(driverLocal);
        });
    }

    public void processTripFinished(Trip trip) {
        LOGGER.info("Processing: {}", trip);
        Optional<Driver> driver = repository.findById(trip.getDriverId());
        if (driver.isPresent()) {
            Driver driverLocal = driver.get();
            driverLocal.setBalance(driverLocal.getBalance() + trip.getPrice());
            repository.updateDriver(driverLocal);
            Order order = new Order(OrderType.PAYMENT_PROCESSED, driverLocal.getId(), trip.getId());
            orderClient.send(order);
            LOGGER.info("Message sent: {}", order);
        }
    }
}
