package Entity.LivingOrganism.Plants;


import Entity.AnimalIsland.Cell;
import Parameters.OrganismParameters;

public class Plant extends Plants {
    public Plant(OrganismParameters organismParameters) {
        super(organismParameters);
    }





    @Override
    public boolean move(Cell curentCell) {
        return false;
    }
}
