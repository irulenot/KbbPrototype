package model;

import java.io.Serializable;

/**
 *  Anthony Bilic
 */
 class OptionSet implements Serializable {
    // Properties
    private double set_cost;
    private String set_name;
    private Option[] options;
    private int option_counter = 0;

    // Constructor
    protected OptionSet(String setName, double setCost, int optionCount) {
        set_cost = setCost;
        set_name = setName;
        options = new Option[optionCount];
    }

    // Get set
    protected double getSet_cost(){return set_cost;}

    protected String getSet_name(){return set_name;}

    protected int getCounter(){return option_counter;}

    // Get option
    protected Option getOption(int indexOfOption) {return options[indexOfOption];}

    // Set set
    protected void setSet_cost(double setCost){set_cost = setCost;}

    protected void setSet_name(String setName){set_name = setName;}

    protected void setCounter(int optionCounter){ option_counter = optionCounter;}

    // Set option
    protected void setOption_cost(double optionCost){this.setOption_cost(optionCost);}

    protected void setOption_name(String optionName){this.setOption_name(optionName);}

    // Add option
    protected void addOption(String optionName, double optionCost) {

        if (options.length > option_counter){

            options[option_counter] = new Option(optionName, optionCost);
            option_counter++;

        }else{
            System.out.print("More space required");
        }
    }

    // toString set/option
    protected String toStringOptionSet() {
        StringBuilder info = new StringBuilder();

        info.append(set_name);
        info.append("[");
        info.append(set_cost);
        info.append("] ");

        return info.toString();
    }

    protected String toStringOption(int indexOfOption) {
        StringBuilder info = new StringBuilder();

        String optionName = this.getOption(indexOfOption).option_name;
        Double optionCost = this.getOption(indexOfOption).option_cost;

        info.append(optionName);
        info.append("[");
        info.append(optionCost);
        info.append("] ");

        return info.toString();
    }

    // Delete option
    protected void deleteOption(int indexOfOption) {
        this.options[indexOfOption] = null;
    }

    // Inner class
    protected class Option implements Serializable {
        // Properties
        private double option_cost;
        private String option_name;

        // Constructor
        protected Option(String optionName, double optionCost) {
            option_cost = optionCost;
            option_name = optionName;
        }

        // Get
        protected double getOption_cost(){return option_cost;}

        protected String getOption_name(){return option_name;}

        // Set
        protected void setOption_cost(double optionCost){option_cost = optionCost;}

        protected void setOption_name(String optionName){option_name = optionName;}
    }

}
