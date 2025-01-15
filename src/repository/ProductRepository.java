package repository;



import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> listaProducts = new ArrayList<>();

    // Create
    public void addProduct(Product product) {
        listaProducts.add(product);
    }

    // Read
    public Product getProductByName(String name) {
        return listaProducts.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Product> getAllProducts() {
        return listaProducts;
    }

    // Update
    public void updateProduct(Product oldProduct, Product newProduct) {
        int index = listaProducts.indexOf(oldProduct);
        if (index != -1) {
            listaProducts.set(index, newProduct);
        }
    }

    // Delete
    public void deleteProduct(Product product) {
        listaProducts.remove(product);
    }
}
