/**
 * Name: Jack Montoro
 * Email: jmontoro@ucsd.edu
 * PID: A17152600
 * File Description: This class implements the Sanctuary Object
 */
import java.util.HashMap;
import java.util.Set;

/**
 * This Object class replicates an animal sanctuary
 * by implementing class Sanctuary with class variables:
 * sanctuary(HashMap<String,Integer>),(ints)maxAnimals and maxSpecies
 */
public class Sanctuary {
    
    HashMap<String, Integer> sanctuary;
    int maxAnimals;
    int maxSpecies;
    final int CAN_RESCUE_ALL = 0;

    /**
     * Constructor that creates a Sanctuary Object
     * @param maxAnimals int assigned to class variable maxAnimals
     * @param maxSpecies int assigned to class variable maxSpecies
     */
    public Sanctuary(int maxAnimals, int maxSpecies) {
        if(maxAnimals<0||maxSpecies<0){
            throw new IllegalArgumentException();
        }

        this.sanctuary = new HashMap<String,Integer>();
        this.maxAnimals = maxAnimals;
        this.maxSpecies = maxSpecies;
    }

    /**
     * gets number of animals from a species in a Sanctuary
     * @return number of animals from a particular species
     */
    public int getNum(String species) {
        if(species == null){
            throw new IllegalArgumentException();
        }

        if(sanctuary.containsKey(species)){
            return sanctuary.get(species);
        }
        return 0;
    }
    
    /**
     * gets total number of animals in a Sanctuary
     * @return number of animals in Sanctuary
     */
    public int getTotalAnimals() {
        int sum = 0;
        for (int x : sanctuary.values()){
            sum += x;
        }
        
        return sum;
    }
    
    /**
     * gets total number of species in a Sanctuary
     * @return number of species in Sanctuary
     */
    public int getTotalSpecies() {
        return sanctuary.size();
    }

    /**
     * adds num amount of animals to species in Sanctuary
     * @param species species to be rescued
     * @param num number of animals to be rescued
     * @return animals that cannot be rescued if capacity exceeded
     */
    public int rescue(String species, int num) {
        if(num <= 0||species == null){
            throw new IllegalArgumentException();
        }

        if(num + this.getTotalAnimals() <= this.maxAnimals){
            if(this.sanctuary.containsKey(species)){
                int val = this.sanctuary.get(species);
                this.sanctuary.put(species, val+num);
                return CAN_RESCUE_ALL;
            } else{
                this.sanctuary.put(species,num);
                return CAN_RESCUE_ALL;
            }
        } else{
            int canRescue = this.maxAnimals - this.getTotalAnimals();
            int cannotRescue = num - canRescue;
            if(this.sanctuary.containsKey(species)){
                int val = this.sanctuary.get(species);
                this.sanctuary.put(species, val+canRescue);
                return cannotRescue;
            } else{
                this.sanctuary.put(species,canRescue);
                return cannotRescue;
            }
        }
    }

    /**
     * subtracts num amount of animals to species in Sanctuary
     * @param species species to be released
     * @param num number of animals to be released
     */
    public void release(String species, int num) {
        if(species == null||!this.sanctuary.containsKey(species)){
            throw new IllegalArgumentException();
        }
        if(num > this.sanctuary.get(species)||num <= 0){
            throw new IllegalArgumentException();
        }
        if(num == this.sanctuary.get(species)){
            this.sanctuary.remove(species);
        }
        else{
            int dif = this.sanctuary.get(species) - num;
            this.sanctuary.put(species,dif);
        }
    }
}
