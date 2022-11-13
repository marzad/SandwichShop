package de.neuefische.marzad.sandwichshop.service;

import de.neuefische.marzad.sandwichshop.model.SandwichModel;
import de.neuefische.marzad.sandwichshop.repository.SandwichRepository;

import java.util.List;

public class SandwichShopService {
    private static SandwichRepository sandwichRepository;

    public SandwichShopService(SandwichRepository sandwichRepository){
        this.sandwichRepository = sandwichRepository;
    }


    public static List<SandwichModel> getAllSandwiches() {
        return sandwichRepository.getAllSandwiches();
    }

    public static SandwichModel getSandwichByID(String s) {
        return sandwichRepository.getSandwichByID(s);
    }

    public static SandwichModel saveSandwich(SandwichModel newSandwich) {
        return sandwichRepository.saveSandwich(newSandwich);
    }

    public static SandwichModel updateSandwich(SandwichModel newSandwich) {
        return sandwichRepository.updateSandwich(newSandwich);
    }

    public static SandwichModel deleteSandwich(String id) {
        return sandwichRepository.deleteSandwich(id);
    }
}
