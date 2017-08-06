package data.oops.parkinglot;

public abstract class Vehicle {
	Ticket tkt;

	abstract public VehicleType getType();

	Ticket park(ParkingLot parkingLot) {
		if (parkingLot == null || tkt != null)
			return null;
		Ticket tkt = parkingLot.createTicket(this);
		this.tkt = tkt;
		return tkt;
	}

	Ticket unpark() {
		this.tkt.space.isVacant = true;
		return this.tkt;
	}
}


class Bike extends Vehicle {
	VehicleType vehicleType = VehicleType.BIKE;

	@Override
	public VehicleType getType() {
		return vehicleType;
	}
}

class Car extends Vehicle {
	VehicleType vehicleType = VehicleType.CAR;

	@Override
	public VehicleType getType() {
		return vehicleType;
	}
}

class Bus extends Vehicle {
	VehicleType vehicleType = VehicleType.BUS;

	@Override
	public VehicleType getType() {
		return vehicleType;
	}
}