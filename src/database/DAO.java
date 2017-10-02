package database;

import model.Vehicle;

import java.util.List;

public interface DAO {


    List<Vehicle> getVehicles();

    List<Vehicle> getFinePerOwner(String afm);

    void sortedPlatesFromDatabase();


}
