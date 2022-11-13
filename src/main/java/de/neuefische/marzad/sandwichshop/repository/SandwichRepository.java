package de.neuefische.marzad.sandwichshop.repository;

import de.neuefische.marzad.sandwichshop.model.SandwichModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SandwichRepository {

    private List<SandwichModel> sandwichModelList = new ArrayList<>();

    public SandwichRepository(){}

    public SandwichRepository(List<SandwichModel> list){
        this.sandwichModelList = list;
    }


    public List<SandwichModel> getAllSandwiches() {
        return sandwichModelList;
    }

    public SandwichModel getSandwichByID(String s) {
        for(SandwichModel sandwich: sandwichModelList){
            if(sandwich.getId().equals(s)){
                return sandwich;
            }
        }
        return null;
    }

    public SandwichModel saveSandwich(SandwichModel newSandwich) {
        try{
            sandwichModelList.add(newSandwich);
            return newSandwich;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public SandwichModel updateSandwich(SandwichModel newSandwich) {
        for(SandwichModel sandwich: sandwichModelList) {
            if(sandwich.getId().equals(newSandwich.getId())) {
                try {
                    int id = sandwichModelList.indexOf(sandwich);
                    sandwichModelList.set(id, newSandwich);
                    return newSandwich;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return null;
    }

    public SandwichModel deleteSandwich(String id) {
        try{
            for(SandwichModel sandwich: sandwichModelList){
                if(sandwich.getId().equals(id)){
                    sandwichModelList.remove(sandwich);
                    return sandwich;
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
