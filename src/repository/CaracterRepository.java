package repository;



import model.Caracter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CaracterRepository {

    private List<Caracter> listaCaracters = new ArrayList<>();

    // Create
    public void addCaracter(Caracter caracter) {
        listaCaracters.add(caracter);
    }

    // Read
    public Caracter getCaracterById(int id) {
        return listaCaracters.stream()
                .filter(caracter -> caracter.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Caracter> getAllCaracters() {
        return listaCaracters;
    }

    // Update
    public void updateCaracter(Caracter oldCaracter, Caracter newCaracter) {
        int index = listaCaracters.indexOf(oldCaracter);
        if (index != -1) {
            listaCaracters.set(index, newCaracter);
        }
    }

    // Delete
    public void deleteCaracter(Caracter caracter) {
        listaCaracters.remove(caracter);
    }

    // Filter by origin
    public List<Caracter> getCaractersByOrigin(String origin) {
        return listaCaracters.stream()
                .filter(c -> c.getOrigin().equalsIgnoreCase(origin))
                .collect(Collectors.toList());
    }
}
