package view;

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
            System.out.println("2. Caracter Management");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    handleProductMenu();
                    break;
                case 2:
                    //handleCaracterMenu();
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

    private void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Enter origin: ");
        String origin = scanner.nextLine();

        controller.addProduct(name, price, origin);
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
        System.out.print("Enter new origin: ");
        String newOrigin = scanner.nextLine();

        controller.updateProduct(product, newName, newPrice, newOrigin);
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

