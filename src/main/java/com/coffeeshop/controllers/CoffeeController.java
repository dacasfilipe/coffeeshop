package com.coffeeshop.controllers;

import com.coffeeshop.models.Coffee;
import com.coffeeshop.repositories.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {
    @Autowired
    CoffeeRepository coffeeRepository;
    @GetMapping(value ="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Coffee> getAllCoffee(){
        return coffeeRepository.findAll();
    }
    //metodo para salvar
    @PostMapping(value="/createCoffee", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Coffee createNewCoffee(@RequestBody Coffee coffee){
        Coffee createCoffee = new Coffee();
        createCoffee.setName(coffee.getName());
        createCoffee.setPrice(coffee.getPrice());
        return coffeeRepository.save(createCoffee);
    }
    @PutMapping(value="/updatedCoffee",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Coffee updatedCoffee(@RequestBody Coffee coffee){
        Coffee getCoffee = coffeeRepository.findById(coffee.getId()).orElseThrow();
        getCoffee.setId(coffee.getId());
        getCoffee.setName(coffee.getName());
        getCoffee.setPrice(coffee.getPrice());
        return coffeeRepository.save(getCoffee);
    }
    @DeleteMapping(value="/deleteCoffee/{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Coffee deleteCoffee(@PathVariable Long id){
        Coffee getCoffee = coffeeRepository.findById(id).orElseThrow();
        coffeeRepository.delete(getCoffee);
        return getCoffee;
    }
}
