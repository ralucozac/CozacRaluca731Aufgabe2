package modelRezolvat.src;

import modelRezolvat.src.controller.ShopController;
import modelRezolvat.src.repository.CustomerRepository;
import modelRezolvat.src.repository.ProductRepository;
import modelRezolvat.src.view.ConsoleView;


public class Main {
    public static void main(String[] args) {
        // Create repositories
        CustomerRepository customerRepository = new CustomerRepository();
        ProductRepository productRepository = new ProductRepository();

        // Create controller
        ShopController controller = new ShopController(customerRepository, productRepository);

        // Create view
        ConsoleView view = new ConsoleView(controller);

        // Start the application
        view.start();
    }
}