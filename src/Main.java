import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        addressBook.load("src/contacts.csv");

        while (true) {
            System.out.println("\n1. Listar contactos");
            System.out.println("2. Crear contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Guardar y salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addressBook.list();
                    break;
                case 2:
                    System.out.print("Ingrese el número telefónico: ");
                    String phoneNumber = scanner.next();
                    System.out.print("Ingrese el nombre: ");
                    String name = scanner.next();
                    addressBook.create(phoneNumber, name);
                    break;
                case 3:
                    System.out.print("Ingrese el número telefónico a eliminar: ");
                    phoneNumber = scanner.next();
                    addressBook.delete(phoneNumber);
                    break;
                case 4:
                    addressBook.save("src/contacts.csv");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }
}