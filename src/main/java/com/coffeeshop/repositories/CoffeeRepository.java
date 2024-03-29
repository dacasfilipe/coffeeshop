package com.coffeeshop.repositories;

import com.coffeeshop.models.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee,Long> {
}
