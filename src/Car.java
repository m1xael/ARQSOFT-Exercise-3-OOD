public class Car extends Vehicle {
    public enum CarType {PETROL, DIESEL, HYBRID}
    private CarType carType;
    private double co2Emissions;

    public Car(String plateNumber, String maker, String model, CarType carType, double co2Emissions) {
        super(plateNumber, maker, model);
        this.carType = carType;
        this.co2Emissions = co2Emissions;
    }

    public CarType getCarType() {
        return carType;
    }

    public double getCo2Emissions() {
        return co2Emissions;
    }

    @Override
    public double calculateTax() {
        switch (carType) {
            case PETROL:
                return co2Emissions * 1.4;
            case DIESEL:
                return co2Emissions * 1.8;
            case HYBRID:
                return co2Emissions * 1.2;
            default:
                return 0;
        }
    }
}