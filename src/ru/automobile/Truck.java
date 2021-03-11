package ru.automobile;

import java.util.*;

// Грузовой транспорт.
public class Truck extends Car {
	public Truck(int stateNumber, int mileage, int optionalParameter, double fuelConsumption, double costLiterFuel) {
		super(stateNumber, mileage, optionalParameter, fuelConsumption, costLiterFuel);
	}

	// Фильтруем по по типу грузовой автомобиль.
	static List<Truck> GetTrucksFromCars(List<Car> cars) {
		List<Truck> trucks = new ArrayList<>();
		for (Car car : cars) {
			if (car instanceof Truck) {
				Truck truck = (Truck) car;
				trucks.add(truck);
			}
		}
		return trucks;
	}

	//Переопределение методов
	@Override
	public String TypeToString() {
		return "[Грузовой транспорт]";
	}

	@Override
	protected String OptionalParameterToString()
	{
		return "объем перевезенного груза см. куб";
	}
}
