package com.projeto.cardapio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.projeto.cardapio.entity.Food;
import com.projeto.cardapio.entity.FoodRequestDTO;
import com.projeto.cardapio.entity.FoodResponseDTO;
import com.projeto.cardapio.repository.FoodRepository;

@Service 
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<FoodResponseDTO> FoodList (){
        return foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();
    }

    public void cadastrarFoods(List<FoodRequestDTO> foodRequest) {
        List<Food> food = foodRequest.stream()
        .map(Food::new)/*.map(Food::new): Transforma cada objeto FoodRequestDTO da lista em uma instância de Food. É a fase de mapeamento/conversão. */ 
        .collect(Collectors.toList());/*.collect(Collectors.toList()): Agrupa os novos objetos Food transformados e constrói a lista final (List<Food>). É a fase de materialização.*/ 
        foodRepository.saveAll(food);
        
    }
}
