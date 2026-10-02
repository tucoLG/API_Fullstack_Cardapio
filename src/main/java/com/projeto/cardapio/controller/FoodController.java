package com.projeto.cardapio.controller;


import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.cardapio.entity.FoodRequestDTO;
import com.projeto.cardapio.entity.FoodResponseDTO;
import com.projeto.cardapio.service.FoodService;

@RestController
@RequestMapping ("food")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    } 
    
    @CrossOrigin (origins = "*", allowedHeaders = "*") /*Conecta Frontend e Backend: Permite que o aplicativo web acesse a API sem ser bloqueado pelo navegador. */
    @GetMapping
    public ResponseEntity<Slice<FoodResponseDTO>> ListarFoods(@RequestParam (defaultValue = "0") int page, 
    @RequestParam (defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("title").ascending());
        return ResponseEntity.ok(foodService.FoodList(pageable));
    }

    @CrossOrigin (origins = "*", allowedHeaders = "*")
    @PostMapping ("/cadastrar")
    public ResponseEntity<Void> cadastrarFoods(@RequestBody List<FoodRequestDTO> foodRequest) /*ajustando para que o método aceite uma lista de foods*/ {
        
        foodService.cadastrarFoods(foodRequest);
        return ResponseEntity.ok().build();
    }
}
