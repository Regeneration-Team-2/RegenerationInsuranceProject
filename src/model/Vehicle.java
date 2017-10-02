package model;

public class Vehicle {



    private String plates;
    private String afmOwner;
    private String expirationDate;




    public Vehicle(String plates, String afmOwner, String expirationDate) {
        this.plates = plates;
        this.afmOwner = afmOwner;
        this.expirationDate = expirationDate;
    }

    public String getPlates() {
        return plates;
    }

    public Vehicle() {
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }

    public String getAfmOwner() {
        return afmOwner;
    }

    public void setAfmOwner(String afmOwner) {
        this.afmOwner = afmOwner;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "plates='" + plates + '\'' +
                ", afmOwner='" + afmOwner + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}
