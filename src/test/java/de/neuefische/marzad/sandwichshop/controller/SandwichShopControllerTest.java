package de.neuefische.marzad.sandwichshop.controller;

import de.neuefische.marzad.sandwichshop.model.SandwichModel;
import de.neuefische.marzad.sandwichshop.repository.SandwichRepository;
import de.neuefische.marzad.sandwichshop.service.SandwichShopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@SpringBootTest
@AutoConfigureMockMvc
class SandwichShopControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    SandwichRepository sandwichRepository;
    SandwichShopService shopService = new SandwichShopService(sandwichRepository);

    @Test
    void test_getAllSandwiches() throws Exception {

        mockMvc.perform(get("/api/sandwich"))
                .andExpect(status().isOk());
 //               .andExpect(content().json(""));
    }

    @Test
    void test_addSandwich() throws Exception {
        SandwichModel newSandwich = new SandwichModel("1", null, null, 0, false);
        sandwichRepository.saveSandwich(newSandwich);
        mockMvc.perform(post("/api/sandwich").contentType(MediaType.APPLICATION_JSON).content("""
{"id" : "1","name": null,"ingredients" : null,"numberOfCheeseLayer" : 0,"bunIsGrilled": false}
"""))
                .andExpect(status().isOk())
               .andExpect(content().json("""
{"id" : "1","name": null,"ingredients" : null,"numberOfCheeseLayer" : 0,"bunIsGrilled": false}
"""));
    }

    @Test
    void test_getSandwichesByID() throws Exception {
        SandwichModel newSandwich = new SandwichModel("1", null, null, 0, false);
        sandwichRepository.saveSandwich(newSandwich);

        mockMvc.perform(get("/api/sandwich/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
{"id" : "1","name": null,"ingredients" : null,"numberOfCheeseLayer" : 0,"bunIsGrilled": false}
"""));
    }

    @Test
    void test_updateSandwich() throws Exception {
        SandwichModel newSandwich = new SandwichModel("1", null, null, 0, false);
        sandwichRepository.saveSandwich(newSandwich);

        mockMvc.perform(put("/api/sandwich/1").contentType(MediaType.APPLICATION_JSON).content("""
{"id" : "1","name": null,"ingredients" : null,"numberOfCheeseLayer" : 1,"bunIsGrilled": false}
"""))
                .andExpect(status().isOk())
                .andExpect(content().json("""
{"id" : "1","name": null,"ingredients" : null,"numberOfCheeseLayer" : 1,"bunIsGrilled": false}
"""));
    }

    @Test
    void test_deleteSandwich() throws Exception {
        SandwichModel newSandwich = new SandwichModel("1", null, null, 0, false);
        sandwichRepository.saveSandwich(newSandwich);

        mockMvc.perform(get("/api/sandwich/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
{"id" : "1","name": null,"ingredients" : null,"numberOfCheeseLayer" : 0,"bunIsGrilled": false}
"""));
    }



}