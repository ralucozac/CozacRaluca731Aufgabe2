package rezolvat.src.model;

import java.util.List;

public class Customer {

    private Integer id;
    private String name;
    private String location;

    private List<Product> products;

    public Customer(Integer id, String name, String location, List<Product> products) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
