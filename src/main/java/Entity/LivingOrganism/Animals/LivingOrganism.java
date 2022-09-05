package Entity.LivingOrganism.Animals;

import Constants.Constants;
import Constants.OrganismType;
import Entity.AnimalIsland.Cell;
import Entity.AnimalIsland.GameMap;
import Parameters.OrganismParameters;
import Services.Randomizer;

import java.util.concurrent.ThreadLocalRandom;

public abstract class LivingOrganism {
    private final int maxSpeed;

    public LivingOrganism(OrganismParameters organismParameters) {

        this.maxSpeed = organismParameters.getMaxSpeed();
    }

    public boolean move(Cell currentCell) {

        int targetRow = currentCell.getRow() + Randomizer.get(0, this.maxSpeed);
        int targetColumn = currentCell.getColumn() + Randomizer.get(0, this.maxSpeed);
        boolean isMove = ThreadLocalRandom.current().nextBoolean();

        System.out.println("isMove " + isMove);

        if(targetRow<0||targetColumn<0){
            isMove=false;
        }

        if(targetRow> Constants.WIDTH_ISLAND){
            targetRow=(targetColumn%Constants.WIDTH_ISLAND)-1;
        }
        if(targetColumn>Constants.LENGTH_ISLAND){
            targetColumn=(targetColumn%Constants.LENGTH_ISLAND)-1;
        }

        if (isMove) {
            GameMap.cells[targetRow][targetColumn].resident.get(OrganismType.valueOf(this.getClass().getSimpleName().toUpperCase())).add(this);
        }

        return isMove;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
