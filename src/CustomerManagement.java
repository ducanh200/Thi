import java.util.*;

public class CustomerManagement {

    private static Map<String, Customer> customers = new HashMap<String, Customer>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCustomer Management :");
            System.out.println("1. Add new customer");
            System.out.println("2. Find by name");
            System.out.println("3. Display all");
            System.out.println("4. Exit");
            System.out.print("Enter your choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewCustomer(scanner);
                    break;
                case 2:
                    findByName(scanner);
                    break;
                case 3:
                    displayAllCustomers();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void addNewCustomer(Scanner scanner) {
        System.out.println("\nEnter customer information:");
        System.out.print("Name : ");
        String name = scanner.nextLine();
        System.out.print("Email : ");
        String email = scanner.nextLine();
        System.out.print("Phone : ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(name, email, phone);
        customers.put(name, customer);
        System.out.println("Customer added successfully.");
    }

    private static void findByName(Scanner scanner) {
        System.out.print("\nEnter name to search: ");
        String name = scanner.nextLine();

        if (customers.containsKey(name)) {
            Customer customer = customers.get(name);
            System.out.println("\nName : " + customer.getName());
            System.out.println("Email : " + customer.getEmail());
            System.out.println("Phone : " + customer.getPhonenumber());
        } else {
            System.out.println("Not found.");
        }
    }

    private static void displayAllCustomers() {
        System.out.println("\nAll customers :");
        for (Map.Entry<String, Customer> entry : customers.entrySet()) {
            Customer customer = entry.getValue();
            System.out.println("\nName : " + customer.getName());
            System.out.println("Email : " + customer.getEmail());
            System.out.println("Phone : " + customer.getPhonenumber());
        }
    }
}

