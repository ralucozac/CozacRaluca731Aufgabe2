import rezolvat.src.controller.ShopController;
import rezolvat.src.repository.CustomerRepository;
import rezolvat.src.repository.ProductRepository;
import rezolvat.src.view.ConsoleView;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
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
