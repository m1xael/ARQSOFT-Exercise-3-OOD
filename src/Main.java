public class Main {
    public static void main(String[] args) {
        TaxSystem taxSystem = new TaxSystem();

        Person person1 = new Person("BC983", "Michael", "Karpov", "Carrer Genova");
        Person person2 = new Person("JU332", "Jordan", "Peterson", "Main Street");
        taxSystem.addPerson(person1);
        taxSystem.addPerson(person2);

        Car car1 = new Car("BCN-MK-7", "Opel", "Astra", Car.CarType.PETROL, 150);
        Car car2 = new Car("NY-JP-76", "Porsche", "911", Car.CarType.DIESEL, 200);
        Motorcycle moto1 = new Motorcycle("FO-PS-1234", "Kawasaki", "Ninja", 600);

        taxSystem.addVehicle(car1);
        taxSystem.addVehicle(car2);
        taxSystem.addVehicle(moto1);

        taxSystem.transferVehicle("BCN-MK-7", "BC983");
        taxSystem.transferVehicle("NY-JP-76", "JU332");
        taxSystem.transferVehicle("FO-PS-1234", "BC983");

        taxSystem.generateAnnualTaxListing();

        taxSystem.transferVehicle("BCN-MK-7", "JU332");
        taxSystem.transferVehicle("FO-PS-1234", "JU332");

        taxSystem.generateAnnualTaxListing();
    }
}