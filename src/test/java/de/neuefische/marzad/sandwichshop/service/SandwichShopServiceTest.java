package de.neuefische.marzad.sandwichshop.service;

import de.neuefische.marzad.sandwichshop.model.SandwichModel;
import de.neuefische.marzad.sandwichshop.repository.SandwichRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

class SandwichShopServiceTest {

    SandwichRepository sandwichRepository = mock(SandwichRepository.class);
    SandwichShopService sandwichShopService = new SandwichShopService(sandwichRepository);

    @Test
    public void test_getAllSandwiches_whenListIsEmpty(){
        List<SandwichModel> result = new ArrayList<>();
         when(SandwichShopService.getAllSandwiches()).thenReturn(result);

         List<SandwichModel> expected = sandwichShopService.getAllSandwiches();

         assertEquals(expected, result);
    }

/*    private String id;
    private String name;
    private String[] ingredients;
    private int numberOfCheeseLayer;
    private boolean bunIsGrilled;*/


    @Test
    public void test_getSandwichByID(){

        SandwichModel newSandwich = new SandwichModel("1", "", null, 0,false);
         when(SandwichShopService.getSandwichByID("1")).thenReturn(newSandwich);

         SandwichModel expected = sandwichShopService.getSandwichByID("1");

         assertEquals(expected, newSandwich);
    }

    @Test
    public void test_saveSandwich(){

        SandwichModel newSandwich = new SandwichModel("1", "", null, 0,false);
         when(SandwichShopService.saveSandwich(newSandwich)).thenReturn(newSandwich);

         SandwichModel expected = sandwichShopService.saveSandwich(newSandwich);

         assertEquals(expected, newSandwich);
    }
    @Test
    public void test_updateSandwich(){

        SandwichModel newSandwich = new SandwichModel("1", "", null, 0,false);
         when(SandwichShopService.updateSandwich(newSandwich)).thenReturn(newSandwich);

         SandwichModel expected = sandwichShopService.updateSandwich(newSandwich);

         assertEquals(expected, newSandwich);
    }

    @Test
    public void test_deleteSandwich(){

        SandwichModel newSandwich = new SandwichModel("1", "", null, 0,false);
         when(SandwichShopService.deleteSandwich("1")).thenReturn(newSandwich);

         SandwichModel expected = sandwichShopService.deleteSandwich("1");

         assertEquals(expected, newSandwich);
    }









}