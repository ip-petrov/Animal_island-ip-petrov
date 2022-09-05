package Entity.LivingOrganism.Animals;

import Entity.AnimalIsland.Cell;
import Parameters.OrganismParameters;

public abstract class Animal extends LivingOrganism {
    public Animal(OrganismParameters organismParameters) {
        super(organismParameters);
    }

    public boolean move(Cell currentCell) {
        return false;
    }


    public abstract void reproduction();
}
