public class AirCondition {
    private final boolean ACIsInstalled;
    private boolean ACIsOn;
    private int temperature;

    public AirCondition(boolean ACIsInstalled) {
        this.ACIsInstalled = ACIsInstalled;
        this.temperature = 21;

    }

    public boolean isInstalled() {
        return ACIsInstalled;
    }

    public boolean isACOn() {
        return ACIsOn;
    }
    public void turnACOn() {
        if (ACIsInstalled) {
            ACIsOn = true;
        }
    }

    public void turnACOff() {
        if (ACIsInstalled) {
            ACIsOn = false;
        }

    }

    public int getTemperature() {
        return temperature;
    }

    public void increaseTemperature() {
        temperature = Math.min(temperature + 1, 30);
    }
    public void decreaseTemperature() {
        temperature = Math.max(temperature - 1, 16);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}