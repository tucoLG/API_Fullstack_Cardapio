package com.projeto.cardapio.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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

    public Slice<FoodResponseDTO> FoodList (Pageable pageable){
        Slice<Food> foodSlice = foodRepository.findByActiveTrue(pageable);

        return foodSlice.map(food -> new FoodResponseDTO(
         food.getId_food(),
         food.getImage(), 
         food.getTitle(), 
         food.getPrice())); /*Slice - Faz a busca paginada direta no SQL (LIMIT/OFFSET), trazendo apenas o pedaço necessário (ex: 10 itens). */
    }

    public void cadastrarFoods(List<FoodRequestDTO> foodRequest) {
        List<Food> food = foodRequest.stream().map(Food::new).toList();

        foodRepository.saveAll(food);
        
    }
}
