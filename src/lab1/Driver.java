package lab1;

import model.Auto;
import util.FileIO;

import java.io.*;

/**
 *  Anthony Bilic
 *  Java 35B
 *  4/18/16
 */

public class Driver {

    public static void main(String[] args) {

        FileIO builder = new FileIO();
        String fileName = "carList.txt";

        Auto car = new Auto();
        car = (builder.processText(fileName, car));  // creating auto object from file information

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("auto.txt"));
            out.writeObject(car);
            out.close();

            Auto newAuto = null;

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("auto.txt"));
            newAuto = (Auto) in.readObject();
            in.close();

            newAuto.printAutoData();

        } catch (Exception e) {
            System.out.print("Error: " + e);
            System.exit(1);
        }

    }

}

/*  EXPECTED OUTPUT

Focus Wagon ZTW, 18445.0, 5

Color, 10
[Fort Knox Gold Clearcoat Metallic 0.0] [Liquid Grey Clearcoat Metallic 0.0] [Infra-Red Clearcoat 0.0] [Grabber Green Clearcoat Metallic 0.0] [Sangria Red Clearcoat Metallic 0.0] [French Blue Clearcoat Metallic 0.0] [Twilight Blue Clearcoat Metallic 0.0] [CD Silver Clearcoat Metallic 0.0] [Pitch Black Clearcoat 0.0] [Cloud 9 White Clearcoat 0.0]
Transmission, 2
[automatic 0.0] [manual -815.0]
Brakes, 2
[Standard 0.0] [ABS 400.0]
Air Bags, 2
[present 350.0] [not present 0.0]
Moon roof, 2
[present 595.0] [not present 0.0]

Process finished with exit code 0
 */