package de.neuefische.marzad.sandwichshop.model;

import lombok.Data;

@Data
public class Order extends SandwichModel{

    private BookModel giftBook;

    public Order(SandwichModel sandwich, BookModel book){
        this.setId(sandwich.getId());
        this.setName(sandwich.getName());
        this.setIngredients(sandwich.getIngredients());
        this.setNumberOfCheeseLayer(sandwich.getNumberOfCheeseLayer());
        this.setBunIsGrilled(sandwich.isBunIsGrilled());
        this.giftBook = book;
    }

}
