package ru.automobile;

import java.text.*;
import java.util.*;

// Базовый .
public class Car {

	//Доп. параметр по умолчанию 0, инициализация полей в конструкторе.
	//Тип автомобиля как соответствие коду автомобиля
	private final int number;
	private final int mileage;
	private final int optional;
	private final double fuel;
	private final double costFuel;

	//Конвертация строк данных в автомобили
	static List<Car> StringsToCars(String[] strings) {
		List<Car> cars = new ArrayList<>();

		//Парсингстрок в автомобили
		for (String string : strings) {
			Car car = StringToCar(string);

			// Сохранение автомобиля.
			cars.add(car);
		}

		return cars;
	}

	//Конвертация строки данных в автомобиль
	private static Car StringToCar(String string) {
		//Коллекция для значений строки
		List<String> values = new ArrayList<>();

		//Разделение строки на части, взято с Интернета
		values.addAll(Arrays.asList(string.split("[-_C]")));

		//И удалим пустые строки
		values.removeIf(value -> value.equals(""));

		// Если данные не повреждены, то первым значением будет код автомобиля.
		// Как преобразовывать строку в число: http://proglang.su/java/numbers-parseint
		//Преобразуем в числовой код автомобиля
		int code = Integer.parseInt(values.get(0));

		// Гос. номер.
		int number = Integer.parseInt(values.get(1));

		// Пробег.
		int mileage = Integer.parseInt(values.get(2));

		//Переменная для дополнительного параметра. Так как его может не быть, то инициализируем его.
		int optional = 0;

		// Проверим есть ли дополнительный параметр.
		if (values.size() == 4)
			optional = Integer.parseInt(values.get(3));

		//Переменная для объекта автомобиль
		Car car;

		//Тип объекта по коду автомобиля
		switch (code) {
			case 100:
				car = new Easy(number, mileage, optional, 12.5, 46.10);
				break;
			case 200:
				car = new Truck(number, mileage, optional, 12.0, 48.90);
				break;
			case 300:
				car = new Passenger(number, mileage, optional, 11.50, 47.50);
				break;
			case 400:
				car = new Hard(number, mileage, optional, 20.0, 48.90);
				break;
			default:
				throw new IllegalArgumentException("Код автомобиля некорректен!");
		}

		return car;
	}

	//Методы для чтения полей
	public int getNumber() {
		return number;
	}

	public int getMileage() {
		return mileage;
	}

	public int getOptional() {
		return optional;
	}

	public double getFuel() {
		return fuel;
	}

	public double getCostFuel() {
		return costFuel;
	}

	// Конструктор автомобиля.
	public Car(int number, int mileage, int optional, double fuel, double costFuel) {
		this.number = number;
		this.mileage = mileage;
		this.optional = optional;
		this.fuel = fuel;
		this.costFuel = costFuel;
	}

	//Расчет расхода по автомобилю
	public double Cost() {
		return (getMileage() / 100.0) * getCostFuel() * getFuel();
	}

	//Тип автомобиля по умолчанию, переопределяется в дочерних классах
	public String TypeToString()
	{
		return "Неизвестно";
	}

	//Доп. параметр по умолчанию, переопределяется в дочерних классах
	protected String OptionalParameterToString()
	{
		return "Неизвестно";
	}

	//Переопределим метод для конвертации данных объекта в строку
	@Override
	public String toString() {
		// Подсмотрел в Интернете
		return MessageFormat.format("{0}: Номер = {1} \n\t Пробег = {2} \n\t {3} = {4} \n\t Расход на 100км = {5} \n\t Стоимость 1 литра = {6} \n\t Расход = {7}",
		                            TypeToString(), number, mileage, OptionalParameterToString(), optional == 0 ? "Параметра нет" :
				                            optional, fuel, costFuel, Cost()
		                           );
	}
}
