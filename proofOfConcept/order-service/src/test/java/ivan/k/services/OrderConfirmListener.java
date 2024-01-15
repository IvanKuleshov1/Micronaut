package ivan.k.services;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.messaging.annotation.MessageBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ivan.k.services.listener.OrderListener;
import ivan.k.services.model.Order;

@KafkaListener(groupId = "orderTest")
public class OrderConfirmListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderListener.class);

	OrderHolder orderHolder;

	public OrderConfirmListener(OrderHolder orderHolder) {
		this.orderHolder = orderHolder;
	}

	@Topic("orders")
	public void receive(@MessageBody Order order) {
		LOGGER.info("Confirmed: {}", order);
		orderHolder.setCurrentOrder(order);
	}

}
