package controller;

import model.Caracter;
import model.Product;
import repository.CaracterRepository;
import repository.ProductRepository;


import java.util.List;

public class ShopController {
    private final CaracterRepository caracterRepository;
    private final ProductRepository productRepository;

    public ShopController(CaracterRepository caracterRepository, ProductRepository productRepository) {
        this.caracterRepository = caracterRepository;
        this.productRepository = productRepository;
    }

    // Product CRUD operations
    public void addProduct(String name, double price, String origin) {
        Product product = new Product(name, price, origin);
        productRepository.addProduct(product);
    }

    public Product getProductByName(String name) {
        return productRepository.getProductByName(name);
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void updateProduct(Product oldProduct, String newName, double newPrice, String newOrigin) {
        Product newProduct = new Product(newName, newPrice, newOrigin);
        productRepository.updateProduct(oldProduct, newProduct);
    }

    public void deleteProduct(Product product) {
        productRepository.deleteProduct(product);
    }

    // Caracter CRUD operations
//    public void addCaracter(Integer id, String name, String origin, List<Product> products) {
//        Caracter caracter = new Caracter(id, name, origin, products);
//        caracterRepository.addCaracter(caracter);
//    }

    public Caracter getCaracterById(int id) {
        return caracterRepository.getCaracterById(id);
    }

    public List<Caracter> getAllCaracters() {
        return caracterRepository.getAllCaracters();
    }

//    public void updateCaracter(Caracter oldCaracter, Integer newId, String newName, String newOrigin, List<Product> newProducts) {
//        Caracter newCaracter = new Caracter(newId, newName, newOrigin, newProducts);
//        caracterRepository.updateCaracter(oldCaracter, newCaracter);
//    }

    public void deleteCaracter(Caracter caracter) {
        caracterRepository.deleteCaracter(caracter);
    }

    public List<Caracter> getCaractersByOrigin(String origin) {
        return caracterRepository.getCaractersByOrigin(origin);
    }
}
