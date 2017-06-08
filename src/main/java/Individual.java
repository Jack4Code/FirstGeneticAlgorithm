/**
 * Created by jackg on 6/4/2017.
 */
public class Individual {

    private int chromosomeSize = 64;
    private int[] individual = new int[chromosomeSize];


    public Individual() {
    }

    public int[] getIndividual() {
        return individual;
    }

    public void setIndividual(int[] individual) {
        this.individual = individual;
    }

    public void convertStringToByteArray(String s){
        for(int i=0; i<s.length(); i++){
            String unit = "" + s.charAt(i);
            individual[i] = Integer.valueOf(unit);
        }
    }

    public void printChromosome(){
        for(int i=0; i<individual.length; i++){
            System.out.print(individual[i]);
        }
    }
}
