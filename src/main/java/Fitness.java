/**
 * Created by jackg on 6/7/2017.
 */
public class Fitness {

    private Individual[] strongestMembers = new Individual[5];
    private Individual mostFit;
    private Individual solution;
    private int matchingGenes;

    public Individual getSolution() {
        return solution;
    }

    public void setSolution(Individual solution) {
        this.solution = solution;
    }

    public void fitnessEvaluation(Individual[] individuals){
        matchingGenes = 0;
        for(int i=0; i<individuals.length; i++){
            int matchCount = 0;
            for(int j=0; j<individuals[i].getIndividual().length; j++){
                if(individuals[i].getIndividual()[j] == getSolution().getIndividual()[j]){
                    matchCount++;
                }
            }
            if(matchCount> matchingGenes){
                matchingGenes = matchCount;
                mostFit = individuals[i];
            }
        }
    }

    public String geneStringOf(Individual individual){
        String gene = "";
        for(int i=0; i<individual.getIndividual().length; i++){
            gene = gene + individual.getIndividual()[i];
        }
        return gene;
    }

    public boolean isThereWinner(Individual[] individuals){
        boolean solutionFound = false;
        for(int i=0; i<individuals.length; i++){
            if(geneStringOf(individuals[i]).equalsIgnoreCase(geneStringOf(solution))){
                solutionFound = true;
            }
        }
        return solutionFound;
    }

    public void getWinner(Individual[] individuals){
        Individual winner = new Individual();
        for(int i=0; i<individuals.length; i++){
            if(geneStringOf(individuals[i]).equalsIgnoreCase(geneStringOf(solution))){
                winner = individuals[i];
                winner.printChromosome();
            }
        }
    }


    public Individual getMostFit() {
        return mostFit;
    }

    public Individual[] getStrongestMembers(){
        return strongestMembers;
    }
}
