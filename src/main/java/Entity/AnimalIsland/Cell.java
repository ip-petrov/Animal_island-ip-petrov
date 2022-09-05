package Entity.AnimalIsland;

import Constants.Constants;
import Constants.OrganismType;
import Entity.LivingOrganism.Animals.LivingOrganism;
import Entity.LivingOrganism.Animals.Predator.Predator;
import Entity.LivingOrganism.Animals.Herbivores.Herbivore;
import Factories.LivingOrganismFactory;
import Parameters.GameParameters;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cell {

    private final int row;
    private final int column;

    public Map<OrganismType, Set<LivingOrganism>> resident = new HashMap<>();

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void life() {
        eat();
        move();
        reproduction();

    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    private void reproduction() {
        for (Map.Entry<OrganismType, Set<LivingOrganism>> pair : resident.entrySet()) {
            OrganismType organismType = pair.getKey();
            Set<LivingOrganism> livingOrganismSet = pair.getValue();
            int newborns = livingOrganismSet.size() / 2;
            if (livingOrganismSet.size() < GameParameters.getInstance().getParameters().get(organismType).getMaxCount() - newborns) {
                for (int i = 0; i < newborns; i++) {
                    LivingOrganism livingOrganism = LivingOrganismFactory.getInstance().getPrototype(organismType);
                    livingOrganismSet.add(livingOrganism);
                }
            } else {
                newborns = GameParameters.getInstance().getParameters().get(organismType).getMaxCount() - livingOrganismSet.size();
                for (int i = 0; i < newborns; i++) {
                    LivingOrganism livingOrganism = LivingOrganismFactory.getInstance().getPrototype(organismType);
                    livingOrganismSet.add(livingOrganism);
                }
            }
        }
    }

    private void move() {
        for (Map.Entry<OrganismType, Set<LivingOrganism>> resident :
                resident.entrySet()) {
            Set<LivingOrganism> livingOrganismSet = resident.getValue();
            Iterator<LivingOrganism> iterator = livingOrganismSet.iterator();
            while (iterator.hasNext()) {
                LivingOrganism livingOrganism = iterator.next();
                boolean isMove = livingOrganism.move(this);
                if (isMove) iterator.remove();
            }
        }
    }

    private void eat() {
        for (Map.Entry<OrganismType, Set<LivingOrganism>> pair :
                resident.entrySet()) {
            Set<LivingOrganism> livingOrganisms = pair.getValue();
            for (LivingOrganism livingOrganism :
                    livingOrganisms) {
                if (livingOrganism instanceof Predator) {
                    OrganismType[] herbivores = Constants.getHerbivores();
                    for (OrganismType herbivore : herbivores) {
                        ((Predator) livingOrganism).eat(resident.get(herbivore));
                    }
                } else if (livingOrganism instanceof Herbivore) {
                    Set<LivingOrganism> plants = resident.get(OrganismType.PLANT);
                    if (plants != null) {
                        ((Herbivore) livingOrganism).eat(plants);
                    }
                }
            }
        }
    }

    public Map<OrganismType, Set<LivingOrganism>> getOrganisms() {
        return resident;
    }

}

