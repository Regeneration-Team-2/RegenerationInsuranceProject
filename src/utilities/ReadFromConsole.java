package utilities;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ReadFromConsole {

    private String userInput;
    private int userInt;

    public static double readDoubleFromConsole() {
        Scanner scanner = new Scanner(System.in);
        try {
            return Double.parseDouble(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("###################################################");
            System.out.println("Bad input format.Please insert an acceptable input");
            System.out.println("###################################################\n");
            return -1;
        }
    }

    public static int readIntFromConsole() {
        Scanner scanner = new Scanner(System.in);
        try {
            return Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("###################################################");
            System.out.println("Bad input format.Please insert an acceptable input");
            System.out.println("###################################################\n");
            return -1;
        }
    }


    public static String readStringFromConsole() {

        Scanner scanner = new Scanner(System.in);

        try {
            return scanner.nextLine();

        } catch (NullPointerException e) {
            return "Something went wrong.Incorrect type of input\n";
        }
    }

//another way
   /* public static LocalDate currentDate() {


        LocalDate currentDate = LocalDate.now();


        return currentDate;
    }


    public static LocalDate plusDate() {

        String day = readStringFromConsole();

        int days = Integer.parseInt(day);

        LocalDate requestedDate = LocalDate.now().plusDays(days);

        return requestedDate;

    }*/

}