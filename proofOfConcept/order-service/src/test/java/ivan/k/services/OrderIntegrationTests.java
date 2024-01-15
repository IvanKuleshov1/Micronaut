package ivan.k.services;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.junit.jupiter.Testcontainers;
import ivan.k.services.client.OrderClient;
import ivan.k.services.model.Order;
import ivan.k.services.model.OrderType;
import ivan.k.services.repository.OrderInMemoryRepository;

@MicronautTest
@Testcontainers
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderIntegrationTests {


	private static final Logger LOGGER = LoggerFactory.getLogger(OrderKafkaContainerTest.class);

	@Inject
	OrderClient client;
	@Inject
	OrderInMemoryRepository repository;
	@Inject
	DriverHolder driverHolder;

	@Test
	@org.junit.jupiter.api.Order(1)
	public void testWaiting() throws InterruptedException {
		Order order = new Order(OrderType.NEW_TRIP, 1L, 50, 30);
		order = repository.add(order);
		client.send(order);
		Driver driverSent = null;
		for (int i = 0; i < 10; i++) {
			driverSent = driverHolder.getCurrentDriver();
			if (driverSent != null)
				break;
			Thread.sleep(1000);
		}
		driverHolder.setCurrentDriver(null);
		Assertions.assertNull(driverSent);
	}

	@Test
	@org.junit.jupiter.api.Order(1)
	public void testNewTrip() throws InterruptedException {
		Order order = new Order(OrderType.NEW_TRIP, 1L, 50, 30);
		order = repository.add(order);
		client.send(order);
		Driver driverReceived = null;
		for (int i = 0; i < 10; i++) {
			driverReceived = driverHolder.getCurrentDriver();
			if (driverReceived != null)
				break;
			Thread.sleep(1000);
		}
		driverHolder.setCurrentDriver(null);
		Assertions.assertNotNull(driverReceived);
	}

}
