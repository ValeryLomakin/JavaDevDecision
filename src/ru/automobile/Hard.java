package ru.automobile;

import java.util.*;

// Тяжелая техника.
public class Hard extends Car {
	public Hard(int stateNumber, int mileage, int optionalParameter, double fuelConsumption, double costLiterFuel) {
		super(stateNumber, mileage, optionalParameter, fuelConsumption, costLiterFuel);
	}

	// Фильтруем по по типу тяжелая тезника.
	static List<Hard> GetHardsFromCars(List<Car> cars) {
		List<Hard> hards = new ArrayList<>();
		for (Car car : cars) {
			if (car instanceof Hard) {
				Hard hard = (Hard) car;
				hards.add(hard);
			}
		}
		return hards;
	}

	//Переопределение методов
	@Override
	public String TypeToString() {
		return "[Тяжелая техника]";
	}

	@Override
	protected String OptionalParameterToString()
	{
		return "вес поднятых грузов тонн";
	}
}
