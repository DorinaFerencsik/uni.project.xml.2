package objects;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//- feltöltés
//- lekérdezés
//- módosítás
//- mentés

public class Main {
    public static void main(String[] args) {
        String menuOption = "start";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Register register = readFromXmlFile();

        while (!menuOption.equals("exit")) {
            try {
                System.out.println("Select option:");
                System.out.println("1 - show the Register");
                System.out.println("2 - add Bicycles");
                System.out.println("3 - add Cyclists");
                System.out.println("4 - add Routes");
                System.out.println("5 - write to file");
                System.out.println("exit - close the program");
                menuOption = br.readLine();
            } catch (IOException ioError) {
                ioError.printStackTrace();
            }
            System.out.println("You selected: "+menuOption);
            switch (menuOption) {
                case "1" : {
                    writeToConsole(register);
                    System.out.println("---------DONE---------\n");
                    break;
                }
                case "2" : {
                    register = addNewBicycle(register);
                    System.out.println("---------DONE---------\n");
                    break;
                }
                case "3" : {
                    register = addNewCyclist(register);
                    System.out.println("---------DONE---------\n");
                    break;
                }
                case "4" : {
                    register = addNewRoute(register);
                    System.out.println("---------DONE---------\n");
                    break;
                }
                case "5" : {
                    writeToXmlFile(register);
                    System.out.println("---------DONE---------\n");
                    break;
                }
            }
        }


//        Register register = readFromXmlFile();
//        writeToConsole(register);
//
//        System.out.println("Add route");
//        register = addNewRoute(register);
//        printRoutes(register.getRoutes());

    }
    /* READ */
    public static Register readFromXmlFile() {
        Register register = new Register();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Register.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            File XMLFile = new File("xml/cyclingRecord.xml");

            register = (Register) jaxbUnmarshaller.unmarshal(XMLFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return register;
    }
    /* WRITE */
    public static void writeToXmlFile(Register register) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Register.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File XMLFile = new File("xml/cyclingRecord.xml");

            jaxbMarshaller.marshal(register, XMLFile);
            jaxbMarshaller.marshal(register, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    /* PRINT */
    public static void writeToConsole(Register register) {
        ArrayList<Bicycle> bicycles = register.getBicycles();
        ArrayList<Cyclist> cyclists = register.getCyclists();
        ArrayList<Route> routes = register.getRoutes();

        printBicycles(bicycles);
        printCyclists(cyclists);
        printRoutes(routes);
    }
    public static void printBicycles(ArrayList<Bicycle> bicycles) {
        int i = 1;
        for (Bicycle bike:bicycles) {
            System.out.println(i+". bicycle");
            System.out.println("Bicycle type: "+bike.getType());
            System.out.println("Bicycle wheelSize: "+bike.getWheelSize());
            System.out.println("Bicycle brake: "+bike.getBrake());
            i++;
        }
    }
    public static void printCyclists(ArrayList<Cyclist> cyclists) {
        int i = 1;
        for (Cyclist cyc:cyclists) {
            System.out.println(i+". cyclist");
            System.out.println("Name: "+cyc.getFirstName() + " " + cyc.getLastName());
            System.out.println("Age: "+cyc.getAge());
            System.out.println("City: "+cyc.getCity());
            i++;
        }
    }
    public static void printRoutes(ArrayList<Route> routes) {
        int i = 1;
        for (Route route:routes) {
            System.out.println(i+". route");
            System.out.println("Distance (km): "+route.getDistance());
            System.out.println("Hours: "+route.getHours());
            for (String inf:route.getInfo()) {
                System.out.println("Info: "+inf);
            }
            i++;
        }
    }

    /* ADD */
    public static Register addNewBicycle(Register register) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String type = "Basic type";
        String wheelSize = "0";
        String brake = "Basic brake";
        int wheelSizeGood;

        try {
            System.out.print("Enter bicycle type: ");
            type = br.readLine();
            System.out.print("Enter bicycle wheelSize: ");
            wheelSize = br.readLine();
            System.out.print("Enter bicycle brake type:");
            brake = br.readLine();
        } catch (IOException ioError) {
            ioError.printStackTrace();
        }

        try{
            wheelSizeGood = Integer.parseInt(wheelSize);
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
            wheelSizeGood = 0;
        }
        Bicycle bicycle = new Bicycle(type, wheelSizeGood, brake);
        register.addBicycle(bicycle);
        return register;
    }
    public static Register addNewCyclist(Register register) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstName = "First";
        String lastName = "Last";
        String age = "0.0";
        String city = "Basic city";
        int ageGood;

        try {
            System.out.print("Enter cyclist first name: ");
            firstName = br.readLine();
            System.out.print("Enter cyclist last name: ");
            lastName = br.readLine();
            System.out.print("Enter cyclist age:");
            age = br.readLine();
            System.out.print("Enter cyclist city:");
            city = br.readLine();
        } catch (IOException ioError) {
            ioError.printStackTrace();
        }

        try{
            ageGood = Integer.parseInt(age);
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
            ageGood = 0;
        }
        Cyclist cyclist = new Cyclist(firstName, lastName, ageGood, city);
        register.addCyclist(cyclist);
        return register;
    }
    public static Register addNewRoute(Register register) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String distance = "0";
        String hours = "0";
        String info = "Basic info";
        double distanceGood;
        double hoursGood;

        try {
            System.out.print("Enter roote distance (km):");
            distance = br.readLine();
            System.out.print("Enter roote hours:");
            hours = br.readLine();
            System.out.print("Enter roote info:");
            info = br.readLine();
        } catch (IOException ioError) {
            ioError.printStackTrace();
        }

        try{
            distanceGood = Double.parseDouble(distance);
            hoursGood = Double.parseDouble(hours);
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
            distanceGood = 0.0;
            hoursGood = 0.0;
        }
        ArrayList<String> infoList = new ArrayList<>();
        infoList.add(info);
        Route route = new Route(distanceGood, hoursGood, infoList);
        register.addRoutes(route);
        return register;
    }

    /* CHANGE*/




}
