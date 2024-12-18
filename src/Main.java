import Entities.Clinic;
import Entities.Dog;
import Entities.Person;
import Entities.Vaccine;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.println("\nMenu de Opções:");
            System.out.println("1. Cadastrar uma vacina");
            System.out.println("2. Cadastrar um cachorro");
            System.out.println("3. Aplicar uma vacina em um cachorro");
            System.out.println("4. Listar vacinas disponíveis");
            System.out.println("5. Listar cachorros cadastrados");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Digite o nome da vacina: ");
                    String vaccineName = scanner.nextLine();
                    System.out.print("Digite o lote da vacina: ");
                    String batch = scanner.nextLine();
                    System.out.print("Digite a data de vencimento (dd/MM/yyyy): ");
                    LocalDate expirationDate = LocalDate.parse(scanner.nextLine(), formatter);

                    Vaccine vaccine = new Vaccine(vaccineName, batch, expirationDate);
                    if (clinic.registerVaccine(vaccine)) {
                        System.out.println("Vacina cadastrada com sucesso!");
                    } else {
                        System.out.println("Erro: Não foi possível cadastrar a vacina. Limite atingido.");
                    }
                    break;

                case 2:
                    System.out.print("Digite o nome do cachorro: ");
                    String dogName = scanner.nextLine();
                    System.out.print("Digite a raça: ");
                    String breed = scanner.nextLine();
                    System.out.print("Digite a cor: ");
                    String color = scanner.nextLine();
                    System.out.print("Digite o sexo (M/F): ");
                    char gender = scanner.nextLine().charAt(0);
                    System.out.print("Digite a data de nascimento (dd/MM/yyyy): ");
                    LocalDate birthDate = LocalDate.parse(scanner.nextLine(), formatter);
                    System.out.print("Digite o peso: ");
                    double weight = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Digite o nome do tutor: ");
                    String ownerName = scanner.nextLine();
                    System.out.print("Digite o CPF do tutor: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Digite o telefone do tutor: ");
                    String phone = scanner.nextLine();

                    Person owner = new Person(ownerName, cpf, phone);
                    Dog dog = new Dog(dogName, breed, color, gender, birthDate, weight);
                    dog.setOwner(owner);

                    if (clinic.registerDog(dog)) {
                        System.out.println("Cachorro cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro: Não foi possível cadastrar o cachorro. Limite atingido.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome do cachorro: ");
                    String searchDogName = scanner.nextLine();
                    System.out.print("Digite o nome do tutor do cachorro: ");
                    String searchOwnerName = scanner.nextLine();

                    Dog foundDog = clinic.searchDog(searchDogName, searchOwnerName);
                    if (foundDog == null) {
                        System.out.println("Cachorro não encontrado.");
                        break;
                    }

                    System.out.print("Digite o nome da vacina a ser aplicada: ");
                    String searchVaccineName = scanner.nextLine();
                    Vaccine foundVaccine = clinic.searchVaccine(searchVaccineName);

                    if (foundVaccine == null) {
                        System.out.println("Vacina não encontrada ou já aplicada.");
                        break;
                    }

                    if (foundDog.registerVaccine(foundVaccine)) {
                        foundVaccine.applyVaccine(LocalDate.now());
                        System.out.println("Vacina aplicada com sucesso!");
                    } else {
                        System.out.println("Erro: Não foi possível registrar a vacina para o cachorro.");
                    }
                    break;

                case 4:
                    System.out.println("\nVacinas disponíveis:");
                    for (Vaccine v : clinic.getAllVaccine()) {
                        if (v.getApplicationDate() == null) {
                            System.out.println(v);
                        }
                    }
                    break;

                case 5:
                    System.out.println("\nCachorros cadastrados:");
                    for (Dog d : clinic.getAllDog()) {
                        System.out.println(d);
                    }
                    break;

                case 6:
                    System.out.println("Saindo do programa. Até mais!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
