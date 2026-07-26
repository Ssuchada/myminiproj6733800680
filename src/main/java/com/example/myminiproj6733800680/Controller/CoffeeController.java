package com.example.myminiproj6733800680.Controller;

import com.example.myminiproj6733800680.Model.Coffee;
import com.example.myminiproj6733800680.Service.CoffeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    // GET /coffees
    @GetMapping
    public List<Coffee> getAll() {
        return coffeeService.getAllCoffees();
    }

    // GET /coffees/{id}
    @GetMapping("/{id}")
    public Coffee getById(@PathVariable Long id) {
        return coffeeService.getCoffeeById(id);
    }

    // POST /coffees
    @PostMapping
    public Coffee addCoffee(@RequestBody Coffee coffee) {
        return coffeeService.addCoffee(coffee);
    }

    // PUT /coffees/{id}
    @PutMapping("/{id}")
    public Coffee updateCoffee(@PathVariable Long id,
                               @RequestBody Coffee coffee) {
        return coffeeService.updateCoffee(id, coffee);
    }

    // DELETE /coffees/{id}
    @DeleteMapping("/{id}")
    public String deleteCoffee(@PathVariable Long id) {

        if (coffeeService.deleteCoffee(id)) {
            return "Delete Success";
        }

        return "Coffee Not Found";
    }

}