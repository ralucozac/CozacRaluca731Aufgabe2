package rezolvat.src.repository;



import rezolvat.src.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerRepository {
    private List<Customer> listaCustomers = new ArrayList<>();

    // Create
    public void addCustomer(Customer customer) {
        listaCustomers.add(customer);
    }

    // Read
    public Customer getCustomerById(int id) {
        return listaCustomers.stream()
                .filter(customer -> customer.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Customer> getAllCustomers() {
        return listaCustomers;
    }

    // Update
    public void updateCustomer(Customer oldCustomer, Customer newCustomer) {
        int index = listaCustomers.indexOf(oldCustomer);
        if (index != -1) {
            listaCustomers.set(index, newCustomer);
        }
    }

    // Delete
    public void deleteCustomer(Customer customer) {
        listaCustomers.remove(customer);
    }

    // Filter by location
    public List<Customer> getCustomersByLocation(String location) {
        return listaCustomers.stream()
                .filter(c -> c.getLocation().equalsIgnoreCase(location))
                .collect(Collectors.toList());
    }
}