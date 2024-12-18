package Entities;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vaccine {

    private String name;
    private String batch;
    private LocalDate expirationDate;
    private LocalDate applicationDate;

    public Vaccine(String name, String batch, LocalDate expirationDate) {
        this.name = name;
        this.batch = batch;
        this.expirationDate = expirationDate;
        this.applicationDate = null;
    }

    public void applyVaccine(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getName() {
        return name;
    }

    public String getBatch() {
        return batch;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedExpiration = expirationDate.format(formatter);
        String formattedApplication = (applicationDate != null) ? applicationDate.format(formatter) : "N/A";

        return String.format(
                "Vacina: %s\nLote: %s\nData de Vencimento: %s\nData de Aplicação: %s",
                name, batch, formattedExpiration, formattedApplication
        );
    }
}
