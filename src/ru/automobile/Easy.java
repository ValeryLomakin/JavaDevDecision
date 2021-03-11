package ru.automobile;

import java.util.*;

// Класс легкового автомобиля.
public class Easy extends Car {
	public Easy(int stateNumber, int mileage, int optionalParameter, double fuelConsumption, double costLiterFuel) {
		super(stateNumber, mileage, optionalParameter, fuelConsumption, costLiterFuel);
	}

	//Фильтруем по по типу легковой
	static List<Easy> GetEasiesFromCars(List<Car> cars) {
		List<Easy> easies = new ArrayList<>();
		for (Car car : cars) {
			if (car instanceof Easy) {
				Easy easy = (Easy) car;
				easies.add(easy);
			}
		}
		return easies;
	}

	//Переопределение методов
	@Override
	public String TypeToString() {
		return "[Легковой]";
	}

	@Override
	protected String OptionalParameterToString()
	{
		return "[Параметр]";
	}
}
