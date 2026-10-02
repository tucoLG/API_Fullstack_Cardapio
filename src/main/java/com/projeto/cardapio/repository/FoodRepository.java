package com.projeto.cardapio.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.cardapio.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{

    Slice<Food> findByActiveTrue (Pageable pageable); 
}
