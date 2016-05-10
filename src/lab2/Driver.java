package lab2;

import adapter.BuildAuto;
import adapter.CreateAuto;

/**
 *  Anthony Bilic
 *  Java 35B
 *  4/26/16
 */

public class Driver {

    public static void main(String[] args) {

        BuildAuto car = new BuildAuto();
        CreateAuto car2 = new BuildAuto();

        try {
            car2.printAuto("null");
        } catch (NullPointerException e){
            car.handleError("printAuto");
        }

        car.buildAuto("carList.txt");

        try {
            car.updateOptionPrice("null", "ir   Bags", "pr  sent", -86789);
        } catch (ArrayIndexOutOfBoundsException e){
            car.handleError("updateOptionPrice");
        }

        try {
            car.updateOptionSetName("null", "Moon moof", "Moon lloor");
        }catch (ArrayIndexOutOfBoundsException e){                            // exception example
            car.handleError("updateOptionSetName");
        }

        car.printAuto("null");
    }

}

/*  EXPECTED OUTPUT WITHOUT INTENTIONAL EXCEPTIONS

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

//        try {
//            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("auto.txt"));
//            out.writeObject(car);
//            out.close();
//
//            Automobile newAutomobile = null;
//
//            ObjectInputStream in = new ObjectInputStream(new FileInputStream("auto.txt"));            //seralization
//            newAutomobile = (Automobile) in.readObject();
//            in.close();
//
//            newAutomobile.printAutoData();
//
//        } catch (Exception e) {
//            System.out.print("Error: " + e);
//            System.exit(1);
//        }