import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AutomaticBikeTest {
    AutomaticBike automaticBikeObj = new AutomaticBike(true);

    @Test
    public void testThatCheckAutomaticBike() {
        assertTrue(automaticBikeObj.isAutomaticBike());
    }

    @Test
    public void testThatAutomaticBikeCanBeTurnedOn() {
        automaticBikeObj.turnOn();
        assertTrue(automaticBikeObj.isBikeOn());
    }

    @Test
    public void testThatAutomaticBikeCanBeTurnedOff() {
        automaticBikeObj.turnOn();
        automaticBikeObj.turnOff();
        assertFalse(automaticBikeObj.isBikeOn());
    }

    @Test
    public void testThatAutomaticBikeCanAccelerate() {
        automaticBikeObj.turnOn();
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        assertEquals(2, automaticBikeObj.getSpeed());
    }

    @Test
    public void testThatAutomaticBikeCanAccelerateInIncrementOfOneWhenInGearOne() {
        automaticBikeObj.turnOn();
        automaticBikeObj.changeGear(1);
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();

        assertEquals(2, automaticBikeObj.getSpeed());
    }

    @Test
    public void testThatAutomaticBikeCanAccelerateInIncrementOfTwoWhenInGearTwo() {
        automaticBikeObj.turnOn();
        automaticBikeObj.changeGear(2);
        automaticBikeObj.accelerate();
        assertEquals(2, automaticBikeObj.getSpeed());
    }

    @Test
    public void testThatAutomaticBikeCanAccelerateInIncrementOfThreeWhenInGearThree() {
        automaticBikeObj.turnOn();
        automaticBikeObj.changeGear(3);
        automaticBikeObj.accelerate();
        assertEquals(3, automaticBikeObj.getSpeed());
    }

    @Test
    public void testThatAutomaticBikeCanAccelerateInIncrementOfFourWhenInGearFour() {
        automaticBikeObj.turnOn();
        automaticBikeObj.changeGear(4);
        automaticBikeObj.accelerate();
        assertEquals(4, automaticBikeObj.getSpeed());
    }


    @Test
    public void testThatAutomaticBikeCanDecelerateInDecrementOfOneWhenInGearOne() {
        automaticBikeObj.turnOn();
        automaticBikeObj.changeGear(1);
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.decelerate();
        assertEquals(1, automaticBikeObj.getSpeed());
    }

    @Test
    public void testThatAutomaticBikeCanDecelerateInDecrementOfTwoWhenInGearTwo(){
        automaticBikeObj.turnOn();
        automaticBikeObj.changeGear(2);
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.decelerate();
        assertEquals(2, automaticBikeObj.getSpeed());
    }

    @Test
    public void testThatAutomaticBikeCanDecelerateInDecrementOfThreeWhenInGearThree(){
        automaticBikeObj.turnOn();
        automaticBikeObj.changeGear(3);
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.decelerate();
        assertEquals(3, automaticBikeObj.getSpeed());
    }

    @Test
    public void testThatAutomaticBikeCanDecelerateInDecrementOfFourWhenInGearFour()  {
        automaticBikeObj.turnOn();
        automaticBikeObj.changeGear(4);
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.decelerate();
        assertEquals(4, automaticBikeObj.getSpeed());
    }

    @Test
    public void testThatAutomaticBikeCanChangeGearAutomaticallyWhenExceedLimit() {
        automaticBikeObj.turnOn();
        automaticBikeObj.changeGear(1);
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();
        automaticBikeObj.accelerate();


        assertEquals(21, automaticBikeObj.getSpeed());
        automaticBikeObj.accelerate();
        assertEquals(23, automaticBikeObj.getSpeed());
        automaticBikeObj.changeGear(3);
        automaticBikeObj.accelerate();
        assertEquals(26, automaticBikeObj.getSpeed());

    }

}