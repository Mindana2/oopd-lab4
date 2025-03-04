import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class VehicleTest {

    Saab95 carTest = new Saab95(false);
    Saab95 saab95 = new Saab95(false);
    Workshop<Car> carworkshop = new Workshop<>(10, 0,0, Car.class);
    CarTransport carTransport = new CarTransport(false, 5);
    Scania scania = new Scania(0);


    @Test
    void startEngine() {
        carTest.startEngine();
        assertEquals(0.1d, carTest.getCurrentSpeed());
    }

    @Test
    void stopEngine() {
        carTest.startEngine();
        carTest.stopEngine();
        assertEquals(0, carTest.getCurrentSpeed());
    }


    @Test
    void move() {
        carTest.move();
        assertEquals(0.0d, carTest.getyPos());
        carTest.startEngine();
        carTest.move();
        assertEquals(0.1d, carTest.getyPos());
    }

    @Test
    void turnLeft() {
        assertEquals("up", carTest.getDirection());
        carTest.turnLeft();
        assertEquals("left", carTest.getDirection());
    }

    @Test
    void turnRight() {
        assertEquals("up", carTest.getDirection());
        carTest.turnRight();
        assertEquals("right", carTest.getDirection());
    }

    @Test
    void gasInRange() {
        saab95.gas(0);
        saab95.gas(1);
        saab95.gas(2);
        saab95.gas(-1);

    }
    @Test
    void currentSpeedInRange() {
        saab95.incrementSpeed(200);
        assertEquals(saab95.getEnginePower(), saab95.getCurrentSpeed());
        saab95.decrementSpeed(300);
        assertEquals(0, saab95.getCurrentSpeed());
    }

    @Test
    void gasMakesBigger() {
        double before = saab95.getCurrentSpeed();
        saab95.gas(1);
        double after = saab95.getCurrentSpeed();
        assertTrue(before < after);
    }

    @Test
    void breakMakesSmaller() {
        saab95.gas(1);
        double before = saab95.getCurrentSpeed();
        saab95.brake(1);
        double after = saab95.getCurrentSpeed();
        assertTrue(before > after);
    }


    @Test
    void unloadCarTransportDifferentPos(){

        carTransport.adjustTipper(70);
        carTransport.loadCar(saab95);
        carTransport.adjustTipper(0);
        carTransport.startEngine();
        carTransport.gas(1);
        carTransport.move();
        carTransport.stopEngine();
        carTransport.adjustTipper(70);
        carTransport.unloadCar();
        assertEquals(saab95.getyPos(), carTransport.getyPos()-1);
    }

    @Test
    void adjustTipper(){

        carTransport.adjustTipper(70);
        assertTrue(carTransport.getTipperState());

        scania.adjustTipper(30);
        assertEquals(30, scania.getTipperAngle());


        scania.adjustTipper(100);
        assertEquals(70, scania.getTipperAngle());

    }

    @Test
    void rampWhileMoving(){

        carTransport.startEngine();

        carTransport.adjustTipper(70);

        assertNotEquals(true, carTransport.getTipperState());


    }

    @Test
    void unloadWorkshop() {

        ArrayList before = (ArrayList) carworkshop.getSlotList();

        carworkshop.loadCar(saab95);
        carworkshop.unloadCar(saab95);

        ArrayList after = (ArrayList) carworkshop.getSlotList();

        assertEquals(before, after);
    }


}