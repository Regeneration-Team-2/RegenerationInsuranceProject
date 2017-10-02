package client;


import database.DAO;
import database.DAOImpl;
import menu.Menu;
import menu.MenuImpl;

import utilities.*;

import java.text.ParseException;
import java.util.List;

public class ClientModule {


    public static void main(String[] args) throws ParseException {

        Menu myMenu=new MenuImpl();
       DatesProcess myDays=new DatesProcess();
        InsuranceStatus ins= new InsuranceStatus();
        ExportData mydata=new ExportData();
        CalculateFine myFine = new CalculateFine();
        DAO myDAO=new DAOImpl();

        int choice = 0;
        boolean isTrue = false;

        myMenu.mainMenu();

        while (!isTrue) {

            choice = ReadFromConsole.readIntFromConsole();

            switch (choice) {

                case 1:
                    ins.finalStatus();
                    break;
                case 2:
                    List<String> exp=myDays.expirationDays();
                    mydata.printOptions(exp);
                    break;
                case 3:
                    myDAO.sortedPlatesFromDatabase();
                    break;
                case 4:
                    myFine.fine();
                    break;
                case 0:
                    isTrue = true;
                    break;
                default:
                    myMenu.mainMenu();
                    break;
            }
        }
    }
}