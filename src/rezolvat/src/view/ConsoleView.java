package rezolvat.src.view;

import rezolvat.src.controller.ShopController;
import rezolvat.src.model.Product;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final ShopController controller;
    private final Scanner scanner;


    public ConsoleView(ShopController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Management System ===");
            System.out.println("1. Product Management");
            System.out.println("2. Customer Management");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    handleProductMenu();
                    break;
                case 2:
                    //handleCustomerMenu();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void handleProductMenu() {
        while (true) {
            System.out.println("\n=== Product Management ===");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewAllProducts();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

//    private void handleCustomerMenu() {
//        while (true) {
//            System.out.println("\n=== Customer Management ===");
//            System.out.println("1. Add Customer");
//            System.out.println("2. View All Customers");
//            System.out.println("3. Update Customer");
//            System.out.println("4. Delete Customer");
//            System.out.println("0. Back to Main Menu");
//            System.out.print("Choose an option: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // consume newline
//
//            switch (choice) {
//                case 1:
//                    addCustomer();
//                    break;
//                case 2:
//                    viewAllCustomers();
//                    break;
//                case 3:
//                    updateCustomer();
//                    break;
//                case 4:
//                    deleteCustomer();
//                    break;
//                case 0:
//                    return;
//                default:
//                    System.out.println("Invalid option!");
//            }
//        }
//    }

    // Product operations
    private void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Enter season: ");
        String season = scanner.nextLine();

        controller.addProduct(name, price, season);
        System.out.println("Product added successfully!");
    }

    private void viewAllProducts() {
        List<Product> listaProducts = controller.getAllProducts();
        if (listaProducts.isEmpty()) {
            System.out.println("No products found!");
            return;
        }
        for (Product product : listaProducts) {
            System.out.println(product.getName() + " " + product.getPrice() + " " + product.getSeason());
        }
    }

    private void updateProduct() {
        System.out.print("Enter product name to update: ");
        String name = scanner.nextLine();
        Product product = controller.getProductByName(name);
        if (product == null) {
            System.out.println("Product not found!");
            return;
        }

        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new price: ");
        double newPrice = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new season: ");
        String newSeason = scanner.nextLine();

        controller.updateProduct(product, newName, newPrice, newSeason);
        System.out.println("Product updated successfully!");
    }

    private void deleteProduct() {
        System.out.print("Enter product name to delete: ");
        String name = scanner.nextLine();
        Product product = controller.getProductByName(name);
        if (product == null) {
            System.out.println("Product not found!");
            return;
        }

        controller.deleteProduct(product);
        System.out.println("Product deleted successfully!");
    }
}
//
//    // Customer operations -- de aici nu mai trebuie sa scrii:
//    private void addCustomer() {
//        System.out.print("Enter customer ID: ");
//        int id = scanner.nextInt();
//        scanner.nextLine(); // consume newline
//        System.out.print("Enter name: ");
//        String name = scanner.nextLine();
//        System.out.print("Enter location: ");
//        String location = scanner.nextLine();
//
//        List<Product> products = selectProducts();
//        controller.addCustomer(id, name, location, products);
//        System.out.println("Customer added successfully!");
//    }
//
//    private void viewAllCustomers() {
//        List<Customer> customers = controller.getAllCustomers();
//        if (customers.isEmpty()) {
//            System.out.println("No customers found!");
//            return;
//        }
//        for (Customer customer : customers) {
//            System.out.println( customer.getId() + " "+ customer.getName() + " " + customer.getLocation());
//
//            System.out.println("Products:");
//            for (Product product : customer.getProducts()) {
//                System.out.println( product.getName() + " " + product.getPrice());
//            }
//        }
//    }
//
//    private void updateCustomer() {
//        System.out.print("Enter customer ID to update: ");
//        int id = scanner.nextInt();
//        scanner.nextLine(); // consume newline
//        Customer customer = controller.getCustomerById(id);
//        if (customer == null) {
//            System.out.println("Customer not found!");
//            return;
//        }
//
//        System.out.print("Enter new ID: ");
//        int newId = scanner.nextInt();
//        scanner.nextLine(); // consume newline
//        System.out.print("Enter new name: ");
//        String newName = scanner.nextLine();
//        System.out.print("Enter new location: ");
//        String newLocation = scanner.nextLine();
//
//        List<Product> newProducts = selectProducts();
//        controller.updateCustomer(customer, newId, newName, newLocation, newProducts);
//        System.out.println("Customer updated successfully!");
//    }
//
//    private void deleteCustomer() {
//        System.out.print("Enter customer ID to delete: ");
//        int id = scanner.nextInt();
//        scanner.nextLine(); // consume newline
//        Customer customer = controller.getCustomerById(id);
//        if (customer == null) {
//            System.out.println("Customer not found!");
//            return;
//        }
//
//        controller.deleteCustomer(customer);
//        System.out.println("Customer deleted successfully!");
//    }
//
//    private List<Product> selectProducts() {
//        List<Product> selectedProducts = new ArrayList<>();
//        List<Product> allProducts = controller.getAllProducts();
//
//        if (allProducts.isEmpty()) {
//            System.out.println("No products available!");
//            return selectedProducts;
//        }
//
//        while (true) {
//            System.out.println("\nAvailable products:");
//            for (int i = 0; i < allProducts.size(); i++) {
//                Product p = allProducts.get(i);
//                System.out.printf("%d. %s (%.2f)%n", i + 1, p.getName(), p.getPrice());
//            }
//            System.out.println("0. Finish selection");
//
//            System.out.print("Select product (enter number): ");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // consume newline
//
//            if (choice == 0) break;
//            if (choice > 0 && choice <= allProducts.size()) {
//                selectedProducts.add(allProducts.get(choice - 1));
//                System.out.println("Product added to selection!");
//            }
//        }
//        return selectedProducts;
//    }
//}
