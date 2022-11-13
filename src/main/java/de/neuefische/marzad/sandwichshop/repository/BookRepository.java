package de.neuefische.marzad.sandwichshop.repository;

import de.neuefische.marzad.sandwichshop.model.BookModel;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    List<BookModel> books = new ArrayList<>();

    public BookRepository(List<BookModel> books){
        this.books = books;
    }
}
