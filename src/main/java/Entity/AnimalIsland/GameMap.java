package Entity.AnimalIsland;

import Constants.Constants;
import Constants.OrganismType;
import Entity.LivingOrganism.Animals.LivingOrganism;
import Factories.LivingOrganismFactory;
import Parameters.GameParameters;
import Services.Randomizer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameMap {

    public static final int rows = Constants.WIDTH_ISLAND;
    public static final int column = Constants.LENGTH_ISLAND;
    public static int dayCount =0;
    public static Cell[][] cells = new Cell[rows][column];

    public void startSimulation() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
        for (Cell[] cell : cells) {
            for (Cell value : cell) {
                OrganismType[] setOfOrganisms = OrganismType.values();
                for (OrganismType organismType :
                        setOfOrganisms) {
                    int count = Randomizer.get(2, GameParameters.getInstance().getParameters().get(organismType).getMaxCount());
                    Set<LivingOrganism> livingOrganismSet = new HashSet<>();
                    for (int k = 0; k < count; k++) {
                        LivingOrganism livingOrganism = LivingOrganismFactory.getInstance().getPrototype(organismType);
                        livingOrganismSet.add(livingOrganism);
                    }
                    value.resident.put(organismType, livingOrganismSet);
                }
            }
        }
    }

    public void printInfo() {

        Map<String, Integer> map = new HashMap<>();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                Map<OrganismType, Set<LivingOrganism>> organism = cell.getOrganisms();
                organism.values()
                        .stream()
                        .filter(s -> s.size() > 0)
                        .forEach(s -> map.put(s.stream().findFirst().get().toString(), s.size()));
                System.out.println("|"+"Локация " + cell.getRow() + "/" + cell.getColumn() + "|\t" + map);
            }
            System.out.println();

        }
        int totalCount = 0;

        for (Cell[] cell : cells) {
            for (Cell item : cell) {
                Map<OrganismType, Set<LivingOrganism>> map1 = item.resident;
                for (Set<LivingOrganism> value : map1.values()) {
                    for (LivingOrganism ignored : value) {
                        totalCount++;
                    }
                }
            }
        }
        dayCount++;
        System.out.println("День - "+dayCount+" Всего живых организмов на острове " + totalCount);
    }

    public void living() {
        for (Cell[] cell : cells) {
            for (Cell value : cell) {
                value.life();
            }
        }
    }
}