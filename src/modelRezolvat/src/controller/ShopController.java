package modelRezolvat.src.controller;



import modelRezolvat.src.model.Customer;
import modelRezolvat.src.model.Product;
import modelRezolvat.src.repository.CustomerRepository;
import modelRezolvat.src.repository.ProductRepository;

import java.util.List;

public class ShopController {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public ShopController(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    // Product CRUD operations
    public void addProduct(String name, double price, String season) {
        Product product = new Product(name, price, season);
        productRepository.addProduct(product);
    }

    public Product getProductByName(String name) {
        return productRepository.getProductByName(name);
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void updateProduct(Product oldProduct, String newName, double newPrice, String newSeason) {
        Product newProduct = new Product(newName, newPrice, newSeason);
        productRepository.updateProduct(oldProduct, newProduct);
    }

    public void deleteProduct(Product product) {
        productRepository.deleteProduct(product);
    }

    // Customer CRUD operations
    public void addCustomer(Integer id, String name, String location, List<Product> products) {
        Customer customer = new Customer(id, name, location, products);
        customerRepository.addCustomer(customer);
    }

    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    public void updateCustomer(Customer oldCustomer, Integer newId, String newName, String newLocation, List<Product> newProducts) {
        Customer newCustomer = new Customer(newId, newName, newLocation, newProducts);
        customerRepository.updateCustomer(oldCustomer, newCustomer);
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.deleteCustomer(customer);
    }

    public List<Customer> getCustomersByLocation(String location) {
        return customerRepository.getCustomersByLocation(location);
    }
}
