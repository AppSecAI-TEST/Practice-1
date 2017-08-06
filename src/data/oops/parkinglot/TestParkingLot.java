package data.oops.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class TestParkingLot {
	/**
	 * Parking or unparking returns a TICKET.
	 * We can calculate charges based on this ticket.
	 */

	public static void main(String[] args) {
		List<ParkingSpace> allParkingSpaces = new ArrayList<>();
		ParkingSpace space;
		String[] names = { "1A", "2A", "3B", "1C", "3c" };
		VehicleType[] types = { VehicleType.BIKE, VehicleType.CAR, VehicleType.BUS };
		
		for (int i = 0; i < 5; i++) {
			VehicleType type = types[i % 3];
			space = new ParkingSpace(names[i], true, i + 1, type);
			allParkingSpaces.add(space);
		}
		ParkingLot parkingLot = new ParkingLot(allParkingSpaces);
		Vehicle b1 = new Bike();
		Vehicle b2 = new Bike();
		Vehicle b3 = new Bike();
		Ticket park_b1 = b1.park(parkingLot);
		System.out.println("Ticket id = "+park_b1.id + " , space = "+park_b1.space);
		Ticket park_b2 = b2.park(parkingLot);
		System.out.println("Ticket id = "+park_b2.id + " , space = "+park_b2.space);
		Ticket park_b3 = b3.park(parkingLot);
		System.out.println("wont be able to park b3. Ticket ="+park_b3);
		Ticket unpark = b2.unpark();
		System.out.println("UNPARK ==> Ticket id = "+park_b1.id + " , space = "+park_b1.space+ " , charge = "+unpark.charge()); // returns the ticket
		park_b3 = b3.park(parkingLot);
		System.out.println("Ticket id = "+park_b3.id + " , space = "+park_b3.space);// can park now
		
		
//		System.out.println(parkingLot.);

	}

}
