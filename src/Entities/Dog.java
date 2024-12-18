package Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Dog {

    private String name;
    private Person owner;
    private String breed;
    private String color;
    private char gender;
    private LocalDate birthDate;
    private double weight;
    private List<Vaccine> vaccineRecords;

    public Dog(String name, String breed, String color, char gender, LocalDate birthDate) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.gender = gender;
        this.birthDate = birthDate;
        this.weight = 0.0;
        this.vaccineRecords = new ArrayList<>();
    }

    public Dog(String name, String breed, String color, char gender, LocalDate birthDate, double weight) {
        this(name, breed, color, gender, birthDate);
        this.weight = weight;
    }

    public boolean registerVaccine(Vaccine vaccine) {
        if (vaccineRecords.size() >= 30) {
            return false;
        }
        vaccine.applyVaccine(LocalDate.now());
        vaccineRecords.add(vaccine);
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<Vaccine> getVaccineRecords() {
        return vaccineRecords;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(
                "Cachorro: %s\nTutor: %s\nRaça: %s\nCor: %s\nSexo: %c\nData de Nascimento: %s\nPeso: %.2f kg\nVacinas:\n",
                name,
                owner != null ? owner.getName() : "N/A",
                breed,
                color,
                gender,
                birthDate.format(formatter),
                weight
        ));

        for (Vaccine vaccine : vaccineRecords) {
            sb.append(String.format("- %s (Aplicada em: %s)\n",
                    vaccine.getName(),
                    vaccine.getApplicationDate() != null ? vaccine.getApplicationDate().format(formatter) : "N/A"
            ));
        }

        return sb.toString();
    }

}

