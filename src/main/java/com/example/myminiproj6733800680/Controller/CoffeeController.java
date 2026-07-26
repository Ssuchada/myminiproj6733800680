package com.example.myminiproj6733800680.Controller;

import com.example.myminiproj6733800680.Model.Coffee;
import com.example.myminiproj6733800680.Service.CoffeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Coffee> addCoffee(@RequestBody Coffee coffee) {

    Coffee newCoffee = coffeeService.addCoffee(coffee);

    return ResponseEntity.status(HttpStatus.CREATED)
            .body(newCoffee);
}

    // PUT /coffees/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Coffee> updateCoffee(
        @PathVariable Long id,
        @RequestBody Coffee coffee) {

    Coffee updated = coffeeService.updateCoffee(id, coffee);

    if (updated == null)
        return ResponseEntity.notFound().build();

    return ResponseEntity.ok(updated);
}

    // DELETE /coffees/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoffee(@PathVariable Long id) {

    if (coffeeService.deleteCoffee(id))
        return ResponseEntity.ok().build();

    return ResponseEntity.notFound().build();
}

}