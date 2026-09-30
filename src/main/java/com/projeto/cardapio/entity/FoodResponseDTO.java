package com.projeto.cardapio.entity;

/**
 * FoodResponseDTO
 */
public record FoodResponseDTO (Long id_food, String title, String image, Integer price) {

    public FoodResponseDTO(Food food) {
        this(food.getId_food(),
         food.getTitle(), 
         food.getImage(), 
         food.getPrice());
    }
}
