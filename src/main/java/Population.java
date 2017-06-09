/**
 * Created by jackg on 6/7/2017.
 */
public class Population {

    private int populationSize = 5000;
    private Individual[] individuals = new Individual[populationSize];

    public Individual[] getIndividuals() {
        return individuals;
    }

    public void setIndividuals(Individual[] individuals) {
        this.individuals = individuals;
    }

    public void generatePopulationOfRandomIndividuals(){
        for(int i=0; i<populationSize; i++){
            Individual individual = new Individual();
            individual.createRandomIndividual();
            individuals[i] = individual;
        }
    }
}
