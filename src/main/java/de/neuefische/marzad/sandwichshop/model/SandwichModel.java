package de.neuefische.marzad.sandwichshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SandwichModel {

    private String id;
    private String name;
    private String[] ingredients;
    private int numberOfCheeseLayer;
    private boolean bunIsGrilled;

}
