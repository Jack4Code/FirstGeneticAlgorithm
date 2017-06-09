import java.util.Random;

/**
 * Created by jackg on 6/7/2017.
 */
public class Algorithm {
    private double mutationRate = 0.015;
    private double uniformRate = 0.50;


    public void iterateGenerations(){
        Population population = new Population();
        population.generatePopulationOfRandomIndividuals();
        Individual[] individuals = population.getIndividuals();
        String sol = "1000000000000000000000000000000000000000000000000000000000000001";
        Individual solution = new Individual();
        solution.convertStringToByteArray(sol);

        Fitness fitness = new Fitness();
        fitness.setSolution(solution);
        int generation = 1;
        while(fitness.isThereWinner(individuals) == false){
            fitness.fitnessEvaluation(individuals);
            fitness.getMostFit();
            for(int i=0; i<individuals.length; i++){
                individuals[i] = reproduce(fitness.getMostFit(), individuals[i]);
            }
            System.out.println();
            System.out.println("Generation: " + generation);
            System.out.println();
            fitness.getMostFit().printChromosome();
            generation++;
        }
        System.out.println("Solution Found on Generation " + generation + ".");
        fitness.getWinner(individuals);
    }

    private Individual mutateGenes(Individual offspring) {
        Individual mutatedOffSpring = new Individual();
        for(int i=0; i<offspring.getIndividual().length; i++){
            Random rand = new Random();
            int binary = rand.nextInt(1 + 1 - 0) + 0;
            if(binary==1){
                if(offspring.getIndividual()[i]==1){
                    offspring.getIndividual()[i] = 0;
                }else{
                    offspring.getIndividual()[i] = 1;
                }
            }
        }
        return mutatedOffSpring;
    }

    private Individual reproduce(Individual parent1, Individual parent2){
        Individual offspring = new Individual();
        Random rand = new Random();
        int binary = rand.nextInt(1 + 1 - 0) + 0;

        if(binary==0) {
            for (int i = 0; i < parent1.getIndividual().length; i++) {
                if (i % 1 == 0) {
                    offspring.getIndividual()[i] = parent1.getIndividual()[i];
                } else {
                    offspring.getIndividual()[i] = parent2.getIndividual()[i];
                }
            }
        }else{
            for (int i = 0; i < parent1.getIndividual().length; i++) {
                if (i % 1 == 0) {
                    offspring.getIndividual()[i] = parent2.getIndividual()[i];
                } else {
                    offspring.getIndividual()[i] = parent1.getIndividual()[i];
                }
            }
        }
        Random randP = new Random();
        double randPercent = randP.nextDouble();
        if(randPercent<mutationRate){
            offspring = mutateGenes(offspring);
        }


        return offspring;
    }


}
