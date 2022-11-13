package de.neuefische.marzad.sandwichshop.controller;

import de.neuefische.marzad.sandwichshop.model.BookModel;
import de.neuefische.marzad.sandwichshop.model.SandwichModel;
import de.neuefische.marzad.sandwichshop.repository.BookRepository;
import de.neuefische.marzad.sandwichshop.repository.SandwichRepository;
import de.neuefische.marzad.sandwichshop.service.SandwichShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("api/sandwich")
public class SandwichShopController {

    @Autowired
    private SandwichRepository sandwichRepository = new SandwichRepository();
    @Autowired
    private SandwichShopService shopService = new SandwichShopService(sandwichRepository);

    @GetMapping
    public List<SandwichModel> getAllSandwiches(){
        return shopService.getAllSandwiches();
    }

    @GetMapping("{id}")
    public SandwichModel getSandwichByID(@PathVariable String id){
        return shopService.getSandwichByID(id);

        BookModel book = WebClient
                .builder()
                .baseUrl("https://my-json-server.typicode.com/Flooooooooooorian/BookApi/books")
                .build()
                .method(HttpMethod.GET)
                .uri("/")
                .exchangeToMono(
                        clientResponse -> clientResponse.bodyToMono(BookModel.class)
                ).block();
    }

    @PostMapping
    public SandwichModel saveSandwich(@RequestBody SandwichModel sandwich){
        return shopService.saveSandwich(sandwich);
    }

    @PutMapping("{id}")
    public SandwichModel updateSandwich(@PathVariable String id, @RequestBody SandwichModel newSandwich){
        return shopService.updateSandwich(newSandwich);
    }

    @DeleteMapping("{id}")
    public SandwichModel deleteSandwich(@PathVariable String id){
        return shopService.deleteSandwich(id);
    }




}
