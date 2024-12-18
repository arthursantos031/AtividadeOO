package Entities;

public class Person {

    private String name;
    private String taxid;
    private String phone;

    public Person(String name, String taxid, String phone) {
        this.name = name;
        this.taxid = taxid;
        this.phone = phone;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return taxid;
    }

    public void setCpf(String taxid) {
        this.taxid = taxid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format(
                "Pessoa: %s\nCPF: %s\nTelefone: %s",
                name, taxid, phone
        );
    }

}