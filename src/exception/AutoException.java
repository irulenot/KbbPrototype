package exception;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

/**
 * Created by anthonybilic on 4/27/16.
 */
public class AutoException extends Exception {

    public void handleError(String errorName){

        Fix fix = new Fix(); // helper class

        switch (errorName){
            case "updateOptionSetName":
                this.logError(errorName);
                break;

            case "updateOptionPrice":
                this.logError(errorName);
                break;

            case "printAuto":
                this.logError(errorName);
                break;

            case ".parseDouble":
                fix.fixAutoCost();
                this.logError(errorName);       // self healing code, calling helper class merely to show I understand concept and for future use.
                break;

            case "processText":
                this.logError(errorName);
                break;

            case "buildAuto":
                this.logError(errorName);
                break;

            case "IOException":
                this.logError(errorName);
                break;

            default:
                this.logError(errorName);
                break;
        }

    }

    protected void logError(String errorLabel){

        try {
            GregorianCalendar calendar = new GregorianCalendar();
            String currentTime = calendar.getTime().toString();

            File log = new File("errorLog.txt");
            PrintWriter printer = new PrintWriter(new FileWriter(log, true));

            printer.append(currentTime + " " + errorLabel + "\n");
            printer.close();

        }catch(IOException e){
            System.out.println("COULD NOT LOG!!");
        }

    }

}
