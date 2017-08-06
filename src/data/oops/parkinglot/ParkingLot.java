package data.oops.parkinglot;

import java.util.ArrayList;
import java.util.List;

/**
 * 'ParkingLot' has 'ParkingSpace'(s)..... full, numberOf_Parkingspaces
 * 'ParkingSpaceTypes' : ['small, medium, 'big']
 * 'Ticket' :
 * 'Vehicle' : --> Two-Wheeler, Car, Bus 
 *
 */
public class ParkingLot {

	List<ParkingSpace> allParkingSpaces;
	public static int ticketCount = 0;
	private int[] prices = {10,40,50};

//	boolean isFull = false;

	public ParkingLot(List<ParkingSpace> spaces) {
		allParkingSpaces = new ArrayList<ParkingSpace>(spaces);
	}

	public Ticket createTicket(Vehicle vehicle) {
		ParkingSpace space = searchSpace(vehicle.getType());
		if (space == null)
			return null;
		Ticket tkt = new Ticket(ticketCount++, space, vehicle);
		space.isVacant = false;
		return tkt;
	}
	
	public boolean isParkingFull(VehicleType type) {
//		if(isFull)
//			return true;
		ParkingSpace space = searchSpace(type);
		return space == null ? false : true;
	}
	
	private ParkingSpace searchSpace(VehicleType type) {
		for(ParkingSpace space : allParkingSpaces) {
			if(space.type == type && space.isVacant) {
				return space;
			}
		}
		return null;
	}
	
	public int charge(Ticket tkt) {
		VehicleType type = tkt.vehicle.getType();
		int charge = 0;
		switch (type) {
		case BIKE:
			charge = prices[0];
			break;
		case CAR:
			charge = prices[1];
			break;
		case BUS:
			charge = prices[2];
			break;
		default:
			break;
		}
		return charge;
	}

}

class ParkingSpace {
	String name; // can be floor + block
	boolean isVacant;
	int distance;
	VehicleType type;

	public ParkingSpace(String name, boolean isVacant, int distance, VehicleType type) {
		super();
		this.name = name;
		this.isVacant = isVacant;
		this.distance = distance;
		this.type = type;
	}
}

class Ticket {
	int id;
	ParkingSpace space;
	Vehicle vehicle;

	public Ticket(int t_id, ParkingSpace space, Vehicle vehicle) {
		super();
		this.id = t_id;
		this.space = space;
		this.vehicle = vehicle;
	}
}

//enum VehicleType
//{
//  SMALL,
//  MEDIUM,
//  LARGE
//}