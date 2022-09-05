package Entity.LivingOrganism.Animals.Herbivores;

import Entity.LivingOrganism.Animals.LivingOrganism;
import Entity.LivingOrganism.Animals.Animal;
import Parameters.OrganismParameters;
import Services.Randomizer;
import java.util.Iterator;
import java.util.Set;

public abstract class Herbivore extends Animal {

    public Herbivore(OrganismParameters organismParameters) {
        super(organismParameters);
    }

    public void eat(Set<LivingOrganism> plants) {
        int randomNum;
        Iterator<LivingOrganism> iterator = plants.iterator();
        while (iterator.hasNext()) {
            LivingOrganism livingOrganism = iterator.next();
            randomNum = Randomizer.get(0,5);
            if (randomNum == 1) {
                iterator.remove();
            }
        }
    }

    public void move() {

    }

    @Override
    public void reproduction() {

    }


    public abstract void eat();
}