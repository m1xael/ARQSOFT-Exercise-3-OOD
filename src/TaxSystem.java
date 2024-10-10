import java.util.*;

public class TaxSystem {
    private Map<String, Vehicle> vehicles;
    private Map<String, Person> persons;

    public TaxSystem() {
        vehicles = new HashMap<>();
        persons = new HashMap<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getPlateNumber(), vehicle);
    }

    public Vehicle getVehicle(String plateNumber) {
        return vehicles.get(plateNumber);
    }

    public void editVehicle(String plateNumber, Vehicle updatedVehicle) {
        vehicles.put(plateNumber, updatedVehicle);
    }

    public void deleteVehicle(String plateNumber) {
        vehicles.remove(plateNumber);
    }

    public void addPerson(Person person) {
        persons.put(person.getLicenseNumber(), person);
    }

    public Person getPerson(String licenseNumber) {
        return persons.get(licenseNumber);
    }

    public void editPerson(String licenseNumber, Person updatedPerson) {
        persons.put(licenseNumber, updatedPerson);
    }

    public void deletePerson(String licenseNumber) {
        persons.remove(licenseNumber);
    }

    public void transferVehicle(String plateNumber, String newOwnerLicenseNumber) {
        Vehicle vehicle = vehicles.get(plateNumber);
        Person newOwner = persons.get(newOwnerLicenseNumber);
        if (vehicle != null && newOwner != null) {
            vehicle.setOwner(newOwner);
        }
    }

    public List<Vehicle> searchVehicles(String query) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : vehicles.values()) {
            if (v.getPlateNumber().contains(query) || v.getMaker().contains(query) || v.getModel().contains(query)) {
                result.add(v);
            }
        }
        return result;
    }

    public List<Person> searchPersons(String query) {
        List<Person> result = new ArrayList<>();
        for (Person p : persons.values()) {
            if (p.getName().contains(query) || p.getSurname().contains(query) || p.getLicenseNumber().contains(query)) {
                result.add(p);
            }
        }
        return result;
    }

    public void generateAnnualTaxListing() {
        Map<Person, List<Vehicle>> ownerVehicles = new HashMap<>();
        for (Vehicle v : vehicles.values()) {
            Person owner = v.getOwner();
            if (owner != null) {
                ownerVehicles.computeIfAbsent(owner, k -> new ArrayList<>()).add(v);
            }
        }

        for (Person owner : ownerVehicles.keySet()) {
            List<Vehicle> ownedVehicles = ownerVehicles.get(owner);
            double totalTax = 0;
            System.out.println("Owner: " + owner.getName() + " " + owner.getSurname());
            for (Vehicle v : ownedVehicles) {
                double tax = v.calculateTax();
                totalTax += tax;
                System.out.println("Vehicle: " + v.getPlateNumber() + ", Tax: " + tax);
            }
            System.out.println("Total Tax for Owner: " + totalTax);
            System.out.println("---------------------------------");
        }
    }
}