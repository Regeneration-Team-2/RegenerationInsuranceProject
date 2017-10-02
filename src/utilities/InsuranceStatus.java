package utilities;

import model.Vehicle;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsuranceStatus {


    public static final String LOCATION = "sample.csv";





    public static List<Vehicle> setUpList() {

        List<Vehicle> myList = new ArrayList<>();
        File myFile = new File(LOCATION);
        Scanner scan = null;
        try {
            scan = new Scanner(myFile);
        } catch (FileNotFoundException e) {

            System.out.println("File not found");
        }
        String inputLine = "";

        while (scan.hasNext()) {
            inputLine = scan.nextLine();
            String[] array = inputLine.split(";");
            Vehicle ve = new Vehicle(array[0], array[1], array[2]);
            myList.add(ve);
        }
        return myList;
    }



    public String readDateFromCSV(String plates) {
        List<Vehicle> myList = setUpList();
        String date = null;
        for (Vehicle e : myList) {
            if (e.getPlates().equalsIgnoreCase(plates)) {
                date = e.getExpirationDate();
                return date;
            }
        }
        return date;
    }



    public void finalStatus() {
        boolean isValid = false;
        String plates = null;
        while (!isValid) {
            System.out.println("Insert your plates: ");

            plates = ReadFromConsole.readStringFromConsole().toUpperCase();

            if (Valdation.plateValidation(plates)) {

                String date = readDateFromCSV(plates);
                if (date == null) {

                    System.out.println("plates not found");

                } else {

                    LocalDate currentDate = DatesProcess.readCurrentDay();
                    LocalDate contractDate = DatesProcess.convertStringToDate(date);
                    if (currentDate.isAfter(contractDate)) {
                        System.out.println("Insurance is expired");
                        isValid = true;
                    } else {
                        System.out.println("Insurance still active");
                        isValid = true;
                    }
                }
            } else {
                System.out.println("Something went wrong.Try the right format(ABC-1234)\n");
            }
        }
    }
}




