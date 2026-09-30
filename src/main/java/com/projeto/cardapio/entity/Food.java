package com.projeto.cardapio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data 
@Table (name ="food")
@Entity (name = "food")
@Getter 
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id_food")
public class Food {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private Long id_food;

    @Column 
    private String title;

    @Column
    private String image;

    @Column 
    private Integer price;
    
    public Food (FoodRequestDTO foodRequest) {
        this.title = foodRequest.title();
        this.price = foodRequest.price();
        this.image = foodRequest.image();
    }
}
