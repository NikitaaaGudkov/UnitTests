package seminars.second.hw;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class VehicleTest {

    static Car car;
    static Motorcycle motorcycle;

    @BeforeAll
    static void CreateVehicles() {
        car = new Car("BMW", "X5", 2020);
        motorcycle = new Motorcycle("YAMAHA", "VMAX", 2022);
    }

    @Test
    void carIsVehicle() {
        assertThat(car).isInstanceOf(Vehicle.class);
    }

    @Test
    void numberWheelsCar() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    void numberWheelsMotorcycle() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    @Test
    void checkSpeedCarOnTestDrive() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    void checkSpeedMotorcycleOnTestDrive() {
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    @Test
    void checkingCarParkingMode() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    void checkingMotorcycleParkingMode() {
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}