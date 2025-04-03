public class AutomaticBike {
    private final boolean automaticBike;
    private boolean isOn;
    private int gear;
    private int currentSpeed;

    public AutomaticBike(boolean automatedBike) {
        this.automaticBike = automatedBike;
        this.currentSpeed = 0;
        this.gear = 1;
    }

    public boolean isAutomaticBike() {
        return automaticBike;
    }

    public boolean isBikeOn() {
        return isOn;
    }

    public void turnOn() {
        if (automaticBike) {
            isOn = true;
        }
    }

    public void turnOff() {
        isOn = false;
    }

    public int getSpeed() {
        return currentSpeed;
    }

    public void changeGear(int gear) {
        if(!isOn) return;
        if (gear >= 1 && gear <= 4) {
            this.gear = gear;
        }
    }

    public int getGear() {
        return gear;
    }

    public void accelerate() {
        if (!isOn) return;
        if (gear == 1) {
            if(currentSpeed >= 0 && currentSpeed <= 20) {
                currentSpeed += 1;
            }else {currentSpeed = 0;}
        }else if (gear == 2) {

            currentSpeed += 2;
        }else if (gear == 3) {
            currentSpeed += 3;
        }else if (gear == 4) {
            currentSpeed += 4;
        }


        if(currentSpeed > 40) {
            gear = 4;
        }else if(currentSpeed > 30 && currentSpeed < 40) {
            gear = 3;
        }else if(currentSpeed > 20 && currentSpeed < 30) {
            gear = 2;
        }else if(currentSpeed < 20 && currentSpeed >= 0) {
            gear = 1;
        }
    }


    public void decelerate() {
        if (!isOn) return;
        if (gear == 1) {
            currentSpeed -= 1;
        }else if (gear == 2) {
            currentSpeed -= 2;
        }else if (gear == 3) {
            currentSpeed -= 3;
        }else if (gear == 4) {
            currentSpeed -= 4;
        }

        if(currentSpeed <= 20 && currentSpeed >= 0) {
            gear = 1;
        }else if(currentSpeed >= 21 && currentSpeed <= 30) {
            gear = 2;
        }else if(currentSpeed >= 31 && currentSpeed <= 40) {
            gear = 3;
        }else if(currentSpeed >= 41) {
            gear = 4;

        }
    }

    public static void main(String[] args) {
        AutomaticBike automaticBike = new AutomaticBike(true);
        automaticBike.turnOn();
        automaticBike.changeGear(1);
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.accelerate();
        automaticBike.decelerate();
        automaticBike.decelerate();
        automaticBike.decelerate();
        automaticBike.decelerate();
        automaticBike.decelerate();
        automaticBike.decelerate();
        System.out.println("current gear " + automaticBike.getGear());
        System.out.println("current speed: " + automaticBike.getSpeed());
    }
}
