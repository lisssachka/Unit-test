package test;

import main.Car;
import main.Motorcycle;
import main.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestVehicle {

    private Car car;
    private Motorcycle motorcycle;

    /**
     * Создание экземпляров классов Car и Motorcycle перед каждым тестом
     */

    @BeforeEach
    public void setUp(){
        car = new Car("Dodge", "Ram", 2010);
        motorcycle = new Motorcycle("Honda", "10", 2011);
    }

    /**
     * Проверка, что экземпляр объекта Car также является экземпляром транспортного средства
     */
    @Test
    public void testCarIsInstanceOfVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    /**
     * Проверка, что объект Car создается с 4-мя колесами
     */
    @Test
    public void testCarhasFourWheels(){
        assertTrue(car.getNumWheels() == 4);
    }

    /**
     * Проверка, что объект Motorcycle создается с 2-мя колесами
     */
    @Test
    public void testMotorcycleHasTwoWheels(){
        assertTrue(motorcycle.getNumWheels() == 2);
    }
    /**
     * Проверка, что объект Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive())
     */
    @Test
    public void testCarSpeedInTestDrive(){
        car.testDrive();
        assertTrue(car.getSpeed() == 60);
    }

    /**
     * Проверка, что объект Motorcycle развивает скорость 75 в режиме тестового вождения (используя метод testDrive())
     */
    @Test
    public void testMotorcycleSpeedInTestDrive(){
        motorcycle.testDrive();
        assertTrue(motorcycle.getSpeed() == 75);
    }

    /**
     * Проверка, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта)
     * машина останавливается (speed = 0).
     */
    @Test
    public void testCarSpeedAfterParking(){
        car.testDrive();
        car.park();
        assertTrue(car.getSpeed() == 0);
    }
    /**
     * Проверка, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта)
     * мотоцикл останавливается (speed = 0).
     */
    @Test
    public void testMotorcycleSppedAfterParking(){
        motorcycle.testDrive();
        motorcycle.park();
        assertTrue(motorcycle.getSpeed() == 0);
    }
}
