package utilities;

import menu.Menu;
import menu.MenuImpl;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportData {

    Menu myMenu = new MenuImpl();

    public void printOptions(List<String> array) {
        int choice=0;
      boolean isTrue=false;
      while(!isTrue){
        do{
        myMenu.subMenu();

         choice = ReadFromConsole.readIntFromConsole();}while(choice==-1);
       if(choice==1 || choice==2) {


           switch (choice) {

               case 1:
                   exportToConsole(array);
                   isTrue=true;
                   break;

               case 2:
                   exportToCSV(array);
                   isTrue=true;
                   break;

               default:
                   myMenu.subMenu();
           }
       }else{
           System.out.println("Insert a correct number");

       }
    }}


    public void exportToConsole(List<String> array) {

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
    }


    public void exportToCSV(List<String> array) {

        String lineSeparetor = "\n";

        String header = "The plates are going to expire are:";
        FileWriter myFile = null;
        try {

            myFile = new FileWriter("Export.csv");
            myFile.append(header);
            myFile.append(lineSeparetor);

            for (String i : array) {

                myFile.append(i);
                myFile.append(lineSeparetor);

            }
            System.out.println("Done!");
        } catch (IOException e) {
            System.out.println("Error to write the file");

        } finally {

            try {
                myFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
