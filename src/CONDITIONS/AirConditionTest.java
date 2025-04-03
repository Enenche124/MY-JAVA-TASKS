import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AirConditionTest {
     AirCondition airCondition = new AirCondition(true);

    @Test
    public void testThatAirConditionIsInstalled() {
        assertTrue(airCondition.isInstalled());
    }

    @Test
    public void testThatAirConditionIsOnWhenITurnedItOn() {
        airCondition.turnACOn();
        assertTrue(airCondition.isACOn());
    }

    @Test
    public void testThatAirConditionIsOffWhenITurnedItOff() {
        airCondition.turnACOn();
        airCondition.turnACOff();
        assertFalse(airCondition.isACOn());
    }

@Test
    public void testThatAirConditionIncreasesInTemperature() {
        airCondition.increaseTemperature();
        airCondition.increaseTemperature();
        assertEquals(23, airCondition.getTemperature());
}
@Test
public void testThatAirConditionDecreasesInTemperature() {
        airCondition.decreaseTemperature();
        airCondition.decreaseTemperature();
        airCondition.decreaseTemperature();
        assertEquals(18, airCondition.getTemperature());
}
    @Test
    public void testIncreaseTemperatureBeyond30() {
        airCondition.setTemperature(30);
        airCondition.increaseTemperature();
        airCondition.increaseTemperature();
        airCondition.increaseTemperature();
        assertEquals(30, airCondition.getTemperature());
    }

    @Test
    public void testDecreaseTemperatureBelow16() {
        airCondition.setTemperature(16);
        airCondition.decreaseTemperature();
        airCondition.decreaseTemperature();
        airCondition.decreaseTemperature();
        assertEquals(16, airCondition.getTemperature());
}
}