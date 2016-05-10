package model;

import java.io.Serializable;

/**
 *  Anthony Bilic
 */
public class Automobile implements Serializable {
    // Properties
    private String auto_name;
    private double auto_cost;
    private OptionSet optionSets[];
    private int set_counter = 0;

    // Constructors
    public Automobile() {
        auto_cost = 0;
        auto_name = "";
    }

    public Automobile(String autoName) {
        auto_cost = 0;
        auto_name = autoName;
    }

    public Automobile(String autoName, double autoCost, int autoCount) {
        auto_cost = autoCost;
        auto_name = autoName;
        optionSets = new OptionSet[autoCount];
    }

    // Get auto
    public String getAuto_name() {
        return auto_name;
    }

    public double getAuto_cost() {
        return auto_cost;
    }

    // Get string set/option
    public String getStringOptionSet(String optionSetName) {
        int indexOfSet = this.findOptionSet(optionSetName);

        return optionSets[indexOfSet].toStringOptionSet();
    }

    public String getStringOptionSets(){
        StringBuilder info = new StringBuilder();

        for (int indexOfSets = 0; indexOfSets < set_counter; indexOfSets++) {
            String optionSet = this.optionSets[indexOfSets].toStringOptionSet();

            info.append(optionSet);
        }

        return info.toString();
    }

    public String getStringOption (String optionSet, String option){
        int setNum = this.findOptionSet(optionSet);
        int optionNum = this.findOption(option, setNum);

        return optionSets[setNum].toStringOption(optionNum);
    }

    public String getStringOptions(String optionSet){
        StringBuilder info = new StringBuilder();

        int indexOfSet = this.findOptionSet(optionSet);
        int setCounter = optionSets[indexOfSet].getCounter();

        for (int indexOfOp = 0; indexOfOp < setCounter; indexOfOp++) {
            info.append(optionSets[indexOfSet].toStringOption(indexOfOp));
        }

        return info.toString();
    }

    // Get set/option
    public OptionSet getOptionSet(int indexOfSet) { return optionSets[indexOfSet];
    }

    public OptionSet.Option getOption(int indexOfSet, int indexOfOp) {
        return optionSets[indexOfSet].getOption(indexOfOp);
    }

    // Set auto
    public void setAuto_name(String autoName) {
        auto_name = autoName;
    }

    public void setAuto_cost(double autoName) {
        auto_cost = autoName;
    }

    // Set set/option
    public void setOptionSet(String setName, String optionName, double optionCost){
        int setNum = this.findOptionSet(setName);

        optionSets[setNum].setSet_name(optionName);
        optionSets[setNum].setSet_cost(optionCost);
    }

    public void setOptionSetName(String setName, String newName){
        int setNum = this.findOptionSet(setName);

        optionSets[setNum].setSet_name(newName);
    }

    public void setOption(String optionSet, String option, String name, double cost){
        int setNum = this.findOptionSet(optionSet);
        int optionNum = this.findOption(option, setNum);

        optionSets[optionNum].setOption_name(name);
        optionSets[optionNum].setSet_cost(cost);
    }

    public void setOptionCost(String optionSet, String option, double cost){
        int setNum = this.findOptionSet(optionSet);
        int optionNum = this.findOption(option, setNum);

        optionSets[setNum].getOption(optionNum).setOption_cost(cost);
    }

    // Add set/option
    public void addOptionSet(String optionName, double optionCost, int optionCount) {
        if (optionSets.length > set_counter) {

            optionSets[set_counter] = new OptionSet(optionName, optionCost, optionCount);
            this.set_counter++;

        } else {
            System.out.print("More space required");
        }
    }

    public void addOption(String optionSetName, double optionCost, String optionName) {
        int indexOfSet = this.findOptionSet(optionSetName);

        optionSets[indexOfSet].addOption(optionName, optionCost);
    }

    // Find set/option
    public int findOptionSet(String optionSetName) {
        for (int indexOfSet = 0; indexOfSet < set_counter; indexOfSet++) {

            String officalSetName = optionSets[indexOfSet].getSet_name();

            if (officalSetName.equals(optionSetName)) {
                return indexOfSet;
            }

        }

        return -1;
    }

    public int findOption(String optionName, int indexOfSet) {
        int i = optionSets.length;
        for (int indextOfOption = 0; indextOfOption < i; indextOfOption++) {

            String officalOptionName = optionSets[indexOfSet].getOption(indextOfOption).getOption_name();

            if (officalOptionName.equals(optionName)) {
                return indextOfOption;
            }

        }

        return -2;
    }

    public void printAutoData() {   // testing method
        int setCount = set_counter;
        int optionCount [] = new int[set_counter];

        System.out.println(auto_name + ", " + auto_cost + ", " + set_counter);
        System.out.println();

        for(int indexOfSet = 0; indexOfSet < set_counter; indexOfSet++) { // each set
            String setName = this.optionSets[indexOfSet].getSet_name();
//            Double setCost = this.optionSets[indexOfSet].getSet_cost();  //useless for now as all are 0.0
            int optionCounter = this.optionSets[indexOfSet].getCounter();

            System.out.println(setName + ", " + optionCounter);

            for(int indexOfOption = 0; indexOfOption < optionCounter; indexOfOption++) { // each option
                String optionName = this.getOption(indexOfSet, indexOfOption).getOption_name();
                Double optionCost = this.getOption(indexOfSet, indexOfOption).getOption_cost();

                System.out.print("[" +optionName + " " + optionCost + "] ");
            } // end of option loop

            System.out.println();
        } // end of set loop

    }

    // delete set/option
    public void deleteOption(String optionName, int indexOfSet) {

        int indexOfOption = this.findOption(optionName, indexOfSet);

        optionSets[indexOfSet].deleteOption(indexOfOption);
    }

    public void deleteOptionSet(int indexOfSet) {

        optionSets[indexOfSet] = null;
    }

}
