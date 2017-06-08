/**
 * Created by jackg on 6/7/2017.
 */
public class Population {

    private int populationSize = 50;
    private Individual[] individuals = new Individual[populationSize];

    public Individual[] getIndividuals() {
        return individuals;
    }

    public void setIndividuals(Individual[] individuals) {
        this.individuals = individuals;
    }

    public Individual[] generatePopulationOfRandomIndividuals(){
        //make them random


        return individuals;
    }
}
