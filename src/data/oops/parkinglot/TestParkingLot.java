package data.oops.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class TestParkingLot {

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
		System.out.println(b1.park(parkingLot));
		System.out.println(b2.park(parkingLot));
		System.out.println(b3.park(parkingLot));
		
//		System.out.println(parkingLot.);

	}

}
