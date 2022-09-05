package Entity.LivingOrganism.Animals.Predator;

import Constants.OrganismType;
import Entity.LivingOrganism.Animals.LivingOrganism;
import Entity.LivingOrganism.Animals.Animal;
import Parameters.GameParameters;
import Parameters.OrganismParameters;
import Services.Randomizer;
import java.util.Iterator;
import java.util.Set;

public abstract class Predator extends Animal {

    public Predator(OrganismParameters organismParameters) {
        super(organismParameters);
    }

    public void eat(Set<LivingOrganism> herbivores){
        int randomNum;
        Iterator<LivingOrganism> iterator= herbivores.iterator();
        while (iterator.hasNext()){
            LivingOrganism livingOrganism = iterator.next();
            randomNum= Randomizer.get(0,100);
            int currentChanceToEat = GameParameters
                    .getInstance()
                    .getChanceToEat()[OrganismType
                    .valueOf(this.getClass()
                            .getSimpleName()
                            .toUpperCase())
                    .ordinal()][OrganismType.valueOf(livingOrganism.getClass().getSimpleName().toUpperCase()).ordinal()];
            if(randomNum<currentChanceToEat){
                iterator.remove();
            }
        }
    }

    public void move() {

    }

    public abstract void eat();

    @Override
    public void reproduction() {

    }

}
