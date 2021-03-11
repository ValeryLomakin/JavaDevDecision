package ru.automobile;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		//Входные данные определены в параметрах запуска приложения Main, Bild and Run.
		//"C100_1-100"
		//"C200_1-120-1200"
		//"C300_1-120-30"
		//"C400_1-80-20"
		//"C100_2-50"
		//"C200_2-40-1000"
		//"C300_2-200-45"
		//"C400_2-10-20"
		//"C100_3-10"
		//"C200_3-170-1100"
		//"C300_3-150-29"
		//"C400_3-100-28"
		//"C100_1-300"
		//"C200_1-100-750"
		//"C300_1-32-15"

		//Типы авто
		// 100 - легковой авто.
		// 200 - грузовой авто - объем перевезенного груза см. куб.
		// 300 - пассажирский транспорт - число перевезенных пассажиров.
		// 400 - тяжелая техника(краны) - вес поднятых грузов тонн.

		// Коллекция автомобилей (создадим).
		List<Car> cars = Car.StringsToCars(args);


		// Легковые :
		List<Easy> easies = Easy.GetEasiesFromCars(cars);

		// Грузовые :
		List<Truck> trucks = Truck.GetTrucksFromCars(cars);

		// Пассажирские :
		List<Passenger> passengers = Passenger.GetPassengersFromCars(cars);

		// Тяжелая техника :
		List<Hard> hards = Hard.GetHardsFromCars(cars);

		//Вывод аналитической информации по автомобилям
		GSM.InforAllTypesOfCars(easies, trucks, passengers, hards);

		GSM.InfoTotalCostsByTypeOfCar(easies, trucks, passengers, hards);

		GSM.InfoTotalCosts(cars);
	}


}
