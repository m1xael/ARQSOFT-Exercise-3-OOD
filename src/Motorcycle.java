public class Motorcycle extends Vehicle {
    private double engineDisplacement;

    public Motorcycle(String plateNumber, String maker, String model, double engineDisplacement) {
        super(plateNumber, maker, model);
        this.engineDisplacement = engineDisplacement;
    }

    public double getEngineDisplacement() {
        return engineDisplacement;
    }

    @Override
    public double calculateTax() {
        return engineDisplacement * 0.10;
    }
}