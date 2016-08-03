package concepts.basic.serialization;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Flight implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

}

class Aircraft extends Flight implements Serializable {

	private static final long serialVersionUID = 1L;
	private String type;
	private Flight flight;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getName() + " - " + this.getType() + " Flight : " + this.getFlight();
	}

}

public class TestSerializer {

	public static void main(String[] args) {
		Aircraft aircraft = new Aircraft();
		aircraft.setName("SG123");
		aircraft.setType("Q400");

		Flight flight = new Flight();
		flight.setName("SG11");
		aircraft.setFlight(flight);

		System.out.println("Before Serialization : " + aircraft);

		try {
			SerializationUtil.serialize(aircraft, "aircraft.ser");
			System.out.println("After Desrialization : " + SerializationUtil.deserialize("aircraft.ser"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Flight> flList = new ArrayList<Flight>();
		flList.add(flight);
		Flight flight1 = new Flight();
		flight1.setName("SG1");
		flList.add(flight1);
		Flight flight2 = new Flight();
		flight2.setName("SG2");
		flList.add(flight2);

		System.out.println("Before Serialization : " + flList);
		try {
			SerializationUtil.serialize(flList, "flight.ser");
			System.out.println("After Desrialization : " + SerializationUtil.deserialize("flight.ser"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
