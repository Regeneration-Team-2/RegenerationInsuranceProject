package utilities;

import model.Vehicle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DatesProcess {


    public static LocalDate readCurrentDay(){

        LocalDate currentDay=LocalDate.now();

        return currentDay;

    }


    public static LocalDate convertStringToDate(String date){


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate contactDate = LocalDate.parse(date, formatter);

        return contactDate;


    }



    public List<String> expirationDays(){
        String[] inArray = null;
        List<String> expPlates=new ArrayList<>();
        int days=0;
        do{
        System.out.println("Insert the number of days:");

         days=ReadFromConsole.readIntFromConsole();}while(days==-1);
        List<Vehicle> myList=InsuranceStatus.setUpList();
        for (Vehicle e : myList) {
            //expPlates = myList.get(i);
            if(LocalDate.now().plusDays(days).isAfter(LocalDate.parse(e.getExpirationDate(), DateTimeFormatter.ofPattern("d/M/yyyy")))){

                expPlates.add(e.getPlates());
            }
        }
        return expPlates;
    }

}
