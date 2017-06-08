/**
 * Created by jackg on 6/4/2017.
 */
public class Main {
    public static void main(String[] args) {

        String in1 = "1001000110011111111111011001000110010001100100011001000110010001";
        Individual individual1 = new Individual();
        individual1.convertStringToByteArray(in1);

        String in2 = "1000000110000001100000011000000110000001100000011000000110000001";
        Individual individual2 = new Individual();
        individual2.convertStringToByteArray(in2);

        String sol = "1000000000000000000000000000000000000000000000000000000000000001";
        Individual solution = new Individual();
        solution.convertStringToByteArray(sol);

        Individual[] individuals = {individual1, individual2};

        Fitness fitness = new Fitness();
        fitness.setSolution(solution);
        fitness.fitnessEvaluation(individuals);
        fitness.getMostFit().printChromosome();


    }
}
