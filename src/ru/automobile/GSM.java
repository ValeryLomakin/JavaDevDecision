package ru.automobile;

import javafx.util.*;

import java.util.*;

public class GSM {
	//Вывод полной суммы расходов по всем
	static void InfoTotalCosts(List<Car> cars) {
		System.out.println("Сумма всех расходов = " + TotalCost(cars));
	}

	//Вывод суммарных расходов по группам
	static void InfoTotalCostsByTypeOfCar(List<Easy> easies, List<Truck> trucks, List<Passenger> passengers, List<Hard> hards) {
		// Расходы на легковые автомобили
		double totalCostEasies = TotalCost(easies);
		System.out.println("Расходы на легковые автомобили = " + totalCostEasies);

		// Расходы на грузовые автомобили
		double totalCostTrucks = TotalCost(trucks);
		System.out.println("Расходы на грузовые автомобили = " + totalCostTrucks);

		// Расходы на пассажирские автомобили
		double totalCostPassengers = TotalCost(passengers);
		System.out.println("Расходы на пассажирские автомобили = " + totalCostPassengers);

		// Расходы на тяжелую технику
		double totalCostHards = TotalCost(hards);
		System.out.println("Расходы на тяжелую технику = " + totalCostHards);
		System.out.println();

		// Свяжем типы автомобилей и расходы в пары:
		List<Pair<List<? extends Car>, Double>> carsAndCost = new ArrayList<>();
		carsAndCost.add(new Pair<>(easies, totalCostEasies));
		carsAndCost.add(new Pair<>(trucks, totalCostTrucks));
		carsAndCost.add(new Pair<>(passengers, totalCostPassengers));
		carsAndCost.add(new Pair<>(hards, totalCostHards));

		// Отсортируем массив по убыванию расходов, по возрастанию:
		carsAndCost.sort(Comparator.comparing(Pair::getValue));

		// В начале списка будет набор автомобилей с самым маленьким расходом.
		List<? extends Car> carsWitLowCost = carsAndCost.get(0).getKey();

		// А в конце списка будет с самым большим расходом.
		List<? extends Car> carsWithHighCost = carsAndCost.get(carsAndCost.size() - 1).getKey();

		// Автомобиль из группы автомобилей, имеющих наименьшую стоимость расходов.
		Car carWitLowCost = carsWitLowCost.get(0);
		System.out.println("Тип авто с наименьшим расходом = " + carWitLowCost.TypeToString());
		System.out.println();

		// Автомобиль из группы автомобилей, имеющих наибольшую стоимость расходов.
		Car carWithHighCost = carsWithHighCost.get(0);
		System.out.println("Тип авто с наибольшим расходом = " + carWithHighCost.TypeToString());
		System.out.println();
	}

	//Информация по всем типам по группам
	static void InforAllTypesOfCars(List<Easy> easies, List<Truck> trucks, List<Passenger> passengers, List<Hard> hards) {
		// Сортируем автомобили по пробегу для каждого типа
		easies.sort(Comparator.comparing(easy1 -> easy1.getMileage()));

		// Вывод информации о всех автомобилях из категории легковые.
		for (Easy easy : easies)
			System.out.println(easy);
		System.out.println();

		trucks.sort(Comparator.comparing(truck1 -> truck1.getMileage()));
		// Вывод информации о всех автомобилях из категории грузовые.
		for (Truck truck : trucks)
			System.out.println(truck);
		System.out.println();

		passengers.sort(Comparator.comparing(passenger1 -> passenger1.getMileage()));
		// Вывод информации о всех автомобилях из категории пассажирские.
		for (Passenger passenger : passengers)
			System.out.println(passenger);
		System.out.println();

		hards.sort(Comparator.comparing(hard1 -> hard1.getMileage()));
		// Вывод информации о всех автомобилях из категории тяжелая техника.
		for (Hard hard : hards)
			System.out.println(hard);
		System.out.println();

	}

	//Рассчитаем общую сумму расходов
	private static double TotalCost(List<? extends Car> cars) {
		//Тут обходим каждый автомобиль и складываем расходы
		return cars.stream().mapToDouble(Car::Cost).sum();
	}
}
