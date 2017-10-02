package utilities;

public class Valdation {

    public static boolean afmValidation(String afm) {

        return afm.matches("^[0-9]{9}");

    }

    public static boolean plateValidation(String plates) {

        return plates.matches("^[A-Z]{3}[-][0-9]{4}");

    }
}
