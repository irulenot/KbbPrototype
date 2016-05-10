package util;

import exception.AutoException;
import model.Automobile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *  Anthony Bilic
 */
public class FileIO {

    private AutoException handler = new AutoException();

    // Method processText method divides the text file then returns a built Automobile
        // Some lines of code were inspired by Sukhjit Singh
    public Automobile processText(String fileName, Automobile automobile) {

        String autoName = new String();
        String autoCost = new String(); // Automobile's constructor variables

        int dataSize = 9; // Must be >= how many lines from text file are read
        int dataCounter = 0; // Keeps track when filling StringBuilder[]

        StringBuilder[] dataBase = new StringBuilder[dataSize]; // Stores Strings for OptionSet and Option

        try {
            FileReader file = new FileReader(fileName);
            BufferedReader buff = new BufferedReader(file);
            boolean eof = false;

            while (!eof) { // Loops until all lines of file are read
                String line = buff.readLine();

                if (line == null) // terminates loop when all lines read
                    eof = true;
                else {

                    if (line.contains("Model")) { // reads Automobile data to variables
                        String seperate = "[,]";
                        String[] option = line.split(seperate);

                        autoName = option[1];
                        autoCost = option[2];
                    } else if (line.contains(".")) { // reads OptionSet data to StringBuilder[]
                        String optionSet = line;

                        try {
                            dataBase[dataCounter] = new StringBuilder();
                            dataBase[dataCounter].append(optionSet);
                        } catch (ArrayIndexOutOfBoundsException e){
                            handler.handleError("processText");
                        }

                        dataCounter++;
                    } else if (line.contains(",")) { // reads Option data to StringBuilder[]
                        String option = line;

                        try {
                            dataBase[dataCounter] = new StringBuilder();
                            dataBase[dataCounter].append(option);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            handler.handleError("processText");
                        }

                        dataCounter++;
                    }

                }

            }   // end of while loop
            buff.close();

        } catch (IOException e) {
            handler.handleError("IOException");
        } // end of gather strings

        return buildAuto(automobile, autoName, autoCost, dataBase, dataCounter);
    }

    //
    protected Automobile buildAuto(Automobile automobile, String autoName, String autoCost, StringBuilder[] dataBase, int dataCounter) {
        String optionId = "[,]"; // used for identifying Option data
        double doubleAutoCost = 0;

        try {
            doubleAutoCost = Double.parseDouble(autoCost);
        }catch(NumberFormatException e){                    //self healing software, its fix is simply negating the parse.
            handler.handleError(".parseDouble");
        }

        automobile = new Automobile(autoName, doubleAutoCost, dataCounter);

        try {
            for (int indexOfData = 0; indexOfData < dataCounter; indexOfData = (indexOfData + 2)) { //parsing all data 2 lines at a time

                String optionSet = dataBase[indexOfData].toString(); // 0 and even lines will be OptionSet Strings
                optionSet = optionSet.substring(1); // first char is deleted as used for identification of OptionSet data

                String[] option = dataBase[indexOfData + 1].toString().split(optionId); // odd lines are Option Strings
                // here we split the line up based on commas ,

                automobile.addOptionSet(optionSet, 0, (option.length / 2)); // we add sets with array size based on Option data length

                for (int indexOfDataOp = 0; indexOfDataOp < option.length; indexOfDataOp++) { // parsing Option data

                    if (indexOfDataOp % 2 != 0) { // for "every other"
                        String optionName = option[indexOfDataOp - 1];

                        double doubleCost = Double.parseDouble(option[indexOfDataOp]); // converts cost to double

                        automobile.addOption(optionSet, doubleCost, optionName);
                    }

                } // end of parsing Option Data

            } // end of parsing
        } catch (ArrayIndexOutOfBoundsException e){
            handler.handleError("buildAuto");
        }

        return automobile;
    }

}