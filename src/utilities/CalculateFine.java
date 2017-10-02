package utilities;

import database.DAO;
import database.DAOImpl;
import menu.Menu;
import menu.MenuImpl;
import model.Vehicle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CalculateFine {

    Menu myMenu = new MenuImpl();
    DAO myDao = new DAOImpl();
    List<Vehicle> myList = new ArrayList<>();


    public void fine() {
        int counter = 0;
        boolean isValid = false;
        List<Vehicle> myVehicle = new ArrayList<>();

        while (!isValid) {
            myMenu.afmMenu();
            String afm = ReadFromConsole.readStringFromConsole();

            if (Valdation.afmValidation(afm)) {

                        myList = myDao.getFinePerOwner(afm);
                        if(myList.size()==0){
                            System.out.println("Afm not found");
                        }else {
                            double myFine=0.0;
                            do {
                                myMenu.costMenou();
                                myFine = ReadFromConsole.readDoubleFromConsole();
                            }while (myFine==-1);
                            for (Vehicle x : myList) {
                                LocalDate expDate = DatesProcess.convertStringToDate(x.getExpirationDate());
                                LocalDate currentDay = DatesProcess.readCurrentDay();
                                if (expDate.isBefore(currentDay)) {
                                    counter++;
                                }
                            }
                            double totalFine = (double) counter * myFine;
                            System.out.println("Afm: " + afm);
                            System.out.println("Total cars: " + myList.size());
                            System.out.println("Uninsured cars: " + counter);
                            System.out.println("Total fine: " + totalFine + "€");

                            isValid = true;
                            break;
                        }
            } else

            {
                System.out.println("AFM format is incorrect.Try to type 9 numbers sequence");
            }
        }
    }


}



