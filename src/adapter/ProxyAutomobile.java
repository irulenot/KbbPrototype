package adapter;

import exception.AutoException;
import model.Automobile;
import util.FileIO;

/**
 *  Anthony Bilic
 */
public abstract class ProxyAutomobile {
    private static Automobile a1;
    private AutoException handler = new AutoException();

    //Given a text file name a method called BuildAuto can be written to build an instance of
    //Automobile. This method does not have to return the Auto instance.
    public void buildAuto(String fileName){
        FileIO builder = new FileIO();
        String fileID = fileName;

        a1 = new Automobile();
        a1 = (builder.processText(fileName, a1));  // creating auto object from file information
    };

    //This function searches and prints the properties of a given Automodel.
    public void printAuto(String Null){
        a1.printAutoData(); // not search yet as only one Automobile object exists
    };

    //This function searches the Model for a given OptionSet and sets the name of OptionSet to
    //newName.
    public void updateOptionSetName(String Null, String optionSetName, String newName){
        a1.setOptionSetName(optionSetName, newName); // no search yet as only one Automobile object exists
    };

    //This function searches the Model for a given OptionSet and Option name, and sets the price to
    //newPrice.
    public void updateOptionPrice(String Null, String optionSetName, String optionName, double newPrice) {
        a1.setOptionCost(optionSetName, optionName, newPrice);
    }

    public void handleError(String errorName){
        handler.handleError(errorName);
    } //access to "fix" method. In my code it is called "handleError"

}
