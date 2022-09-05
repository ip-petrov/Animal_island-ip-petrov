package Factories;

import Constants.OrganismType;
import Entity.LivingOrganism.Animals.LivingOrganism;
import Entity.LivingOrganism.Animals.Predator.*;
import Entity.LivingOrganism.Animals.Herbivores.*;
import Entity.LivingOrganism.Plants.Plant;
import Parameters.GameParameters;

import static Constants.OrganismType.*;

public class LivingOrganismFactory {
    static LivingOrganismFactory livingOrganismFactory;

    private LivingOrganismFactory() {
    }

    public static LivingOrganismFactory getInstance() {
        if (livingOrganismFactory == null) {
            livingOrganismFactory = new LivingOrganismFactory();
        }
        return livingOrganismFactory;
    }

    public LivingOrganism getPrototype(OrganismType organismType) {
        return switch (organismType) {
            case BEAR -> new Bear(GameParameters.getInstance().getParameters().get(BEAR));
            case BOA -> new Boa(GameParameters.getInstance().getParameters().get(BOA));
            case EAGLE -> new Eagle(GameParameters.getInstance().getParameters().get(EAGLE));
            case FOX -> new Fox(GameParameters.getInstance().getParameters().get(FOX));
            case WOLF -> new Wolf(GameParameters.getInstance().getParameters().get(WOLF));
            case BOAR -> new Boar(GameParameters.getInstance().getParameters().get(BOAR));
            case BUFFALO -> new Buffalo(GameParameters.getInstance().getParameters().get(BUFFALO));
            case CATERPILLAR -> new Caterpillar(GameParameters.getInstance().getParameters().get(CATERPILLAR));
            case DEER -> new Deer(GameParameters.getInstance().getParameters().get(DEER));
            case DUCK -> new Duck(GameParameters.getInstance().getParameters().get(DUCK));
            case GOAT -> new Goat(GameParameters.getInstance().getParameters().get(GOAT));
            case HORSE -> new Horse(GameParameters.getInstance().getParameters().get(HORSE));
            case MOUSE -> new Mouse(GameParameters.getInstance().getParameters().get(MOUSE));
            case RABBIT -> new Rabbit(GameParameters.getInstance().getParameters().get(RABBIT));
            case SHEEP -> new Sheep(GameParameters.getInstance().getParameters().get(SHEEP));
            case PLANT -> new Plant(GameParameters.getInstance().getParameters().get(PLANT));

        };
    }
}
