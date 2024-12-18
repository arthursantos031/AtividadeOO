package Entities;
import java.util.ArrayList;
import java.util.List;

public class Clinic {

    private List<Dog> dogRegistry;
    private List<Vaccine> vaccineRegistry;
    private static final int MAX_RECORDS = 1000;

    public Clinic() {
        this.dogRegistry = new ArrayList<>();
        this.vaccineRegistry = new ArrayList<>();
    }

    public boolean registerDog(Dog dog) {
        if (dogRegistry.size() >= MAX_RECORDS) {
            return false;
        }
        dogRegistry.add(dog);
        return true;
    }

    public boolean registerVaccine(Vaccine vaccine) {
        if (vaccineRegistry.size() >= MAX_RECORDS) {
            return false;
        }
        vaccineRegistry.add(vaccine);
        return true;
    }

    public Dog searchDog(String dogName, String ownerName) {
        for (Dog dog : dogRegistry) {
            if (dog.getName().equalsIgnoreCase(dogName) &&
                    dog.getOwner() != null &&
                    dog.getOwner().getName().equalsIgnoreCase(ownerName)) {
                return dog;
            }
        }
        return null;
    }

    public Vaccine searchVaccine(String vaccineName) {
        for (Vaccine vaccine : vaccineRegistry) {
            if (vaccine.getName().equalsIgnoreCase(vaccineName) &&
                    vaccine.getApplicationDate() == null) {
                return vaccine;
            }
        }
        return null;
    }

    public Person searchTutor(String cpf) {
        for (Dog dog : dogRegistry) {
            if (dog.getOwner() != null && dog.getOwner().getCpf().equals(cpf)) {
                return dog.getOwner();
            }
        }
        return null;
    }

    public List<Dog> getAllDog() {
        return new ArrayList<>(dogRegistry);
    }

    // Get all registered vaccines
    public List<Vaccine> getAllVaccine() {
        return new ArrayList<>(vaccineRegistry);
    }

}
