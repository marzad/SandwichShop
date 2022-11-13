package de.neuefische.marzad.sandwichshop.model;

public class Order {

    BookModel giftBook;
    SandwichModel sandwich;

    public Order(SandwichModel sandwich, BookModel book){
        this.sandwich = sandwich;
        this.giftBook = book;
    }
}
