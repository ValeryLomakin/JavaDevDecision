package ru.automobile;

import java.util.*;

// Пассажирский транспорт.
public class Passenger extends Car {
	public Passenger(int stateNumber, int mileage, int optionalParameter, double fuelConsumption, double costLiterFuel) {
		super(stateNumber, mileage, optionalParameter, fuelConsumption, costLiterFuel);
	}

	// Фильтруем по по типу пассажирский транспорт.
	static List<Passenger> GetPassengersFromCars(List<Car> cars) {
		List<Passenger> passengers = new ArrayList<>();
		for (Car car : cars) {
			if (car instanceof Passenger) {
				Passenger passenger = (Passenger) car;
				passengers.add(passenger);
			}
		}
		return passengers;
	}

	//Переопределение методов
	@Override
	public String TypeToString() {
		return "[Пассажирский]";
	}

	@Override
	protected String OptionalParameterToString()
	{
		return "число перевезенных пассажиров";
	}
}
