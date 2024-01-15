package ivan.k.services;

import jakarta.inject.Singleton;
import ivan.k.services.model.Driver;

@Singleton
public class DriverHolder {

	private Driver currentDriver;

	public Driver getCurrentDriver() {
		return currentDriver;
	}

	public void setCurrentDriver(Driver currentDriver) {
		this.currentDriver = currentDriver;
	}

}
