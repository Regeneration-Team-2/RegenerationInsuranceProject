package utilities;

import model.Vehicle;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

public class DaysOfExpiration {

  /*  LocalDate[] expired = null;


    public void exparationDays() {
        String[] inArray = null;
        String[] dates = null;
        System.out.println("Insert the number of days:");

        int days = ReadFromConsole.readIntFromConsole();
        LocalDate date = DatesProcess.readCurrentDay().plusDays(days);

        List<String[]> myList = InsuranceStatus.setUpList();
        for (int i = 0; i < myList.size() - 1; i++) {

            inArray = myList.get(i);

            dates[i] = inArray[2];

        }

        for (int x = 0; x < dates.length; x++) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate contactDate = LocalDate.parse(dates[x], formatter);

            if (contactDate.isBefore(date)) {

                expired[x] = contactDate;

            }

        }
    }


    public void printArray(LocalDate[] dateArray) {

        for (int i = 0; i < dateArray.length; i++) {

            System.out.println(dateArray[i]);

        }
    }*/

    public List<String> exparationDays(){
        String[] inArray = null;
        List<String> expPlates=new ArrayList<>();
        System.out.println("Insert the number of days:");

        int days=ReadFromConsole.readIntFromConsole();
        List<Vehicle> myList=InsuranceStatus.setUpList();
        for (int i = 0; i < myList.size() - 1; i++) {
           // inArray = myList.get(i);
            if(LocalDate.now().plusDays(days).isAfter(LocalDate.parse(inArray[2], DateTimeFormatter.ofPattern("d/M/yyyy")))){

                expPlates.add(inArray[0]);


                System.out.println(expPlates.get(i));
            }
        }
        return expPlates;
    }
}






