package ivan.k.services;

import jakarta.inject.Singleton;
import ivan.k.services.model.Order;

@Singleton
public class OrderHolder {

	private Order currentOrder;

	Order getCurrentOrder() {
		return currentOrder;
	}

	void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}

}
