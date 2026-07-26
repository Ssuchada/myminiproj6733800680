package com.example.myminiproj6733800680.Service;
import com.example.myminiproj6733800680.Model.Coffee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoffeeService {

    private final List<Coffee> coffeeList = new ArrayList<>();

    public CoffeeService() {

        coffeeList.add(new Coffee(1L, "Latte", 55.0));
        coffeeList.add(new Coffee(2L, "Espresso", 45.0));

    }

    // GET ALL
    public List<Coffee> getAllCoffees() {
        return coffeeList;
    }

    // GET BY ID
    public Coffee getCoffeeById(Long id) {
        return coffeeList.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // POST
    public Coffee addCoffee(Coffee coffee) {
        coffeeList.add(coffee);
        return coffee;
    }

    // PUT
    public Coffee updateCoffee(Long id, Coffee newCoffee) {

        Coffee coffee = getCoffeeById(id);

        if (coffee != null) {
            coffee.setName(newCoffee.getName());
            coffee.setPrice(newCoffee.getPrice());
        }

        return coffee;
    }

    // DELETE
    public boolean deleteCoffee(Long id) {

        Coffee coffee = getCoffeeById(id);

        if (coffee != null) {
            coffeeList.remove(coffee);
            return true;
        }

        return false;
    }

}
