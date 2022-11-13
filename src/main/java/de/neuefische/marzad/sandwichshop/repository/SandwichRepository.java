package de.neuefische.marzad.sandwichshop.repository;

import de.neuefische.marzad.sandwichshop.model.SandwichModel;

import java.util.List;

public class SandwichRepository {

    private List<SandwichModel> sandwichModelList;

    public SandwichRepository(){}

    public SandwichRepository(List<SandwichModel> list){
        this.sandwichModelList = list;
    }


}
