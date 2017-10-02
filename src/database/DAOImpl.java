package database;

import model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DAOImpl implements DAO {


    private Connection myCon = null;
    private Statement stmListWithPlates = null;
    private PreparedStatement stmListWithVehicles = null;
    private ResultSet rs = null;
    private String url = "";
    private String userName = "";
    private String pass = "";


    public DAOImpl() {

        this.url = "jdbc:mysql://localhost:3306/team2?useSSL=false";
        this.userName = "team2";
        this.pass = "qwerty123456";

        try {
            myCon = DriverManager.getConnection(url, userName, pass);
        } catch (SQLException e) {

            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }


    @Override
    public List<Vehicle> getVehicles() {

        List<Vehicle> myPlates = new ArrayList<>();

        try {
            stmListWithPlates = myCon.createStatement();
            rs = stmListWithPlates.executeQuery("select plates,afm_owner,date_contract from vehicles  ");

            while (rs.next()) {

                String plates = rs.getString("plates");
                String afm = rs.getString("afm_owner");
                String dates = rs.getString("date_contract");

                myPlates.add(new Vehicle(plates, afm, dates));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (stmListWithPlates != null) {

                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

        return myPlates;
    }


    @Override
    public List<Vehicle> getFinePerOwner(String afm) {
        List<Vehicle> myVehicles = new ArrayList<>();
        //stmListWithVehicles = myCon.prepareStatement("select plates,date_contract from vehicles where afm_owner=?");
        try {
            String query = "select plates,date_contract from vehicles where afm_owner = ?";

            stmListWithVehicles = myCon.prepareStatement(query);
            stmListWithVehicles.setString(1, afm);

            rs = stmListWithVehicles.executeQuery();
            while (rs.next()) {

                Vehicle vehicle = new Vehicle(rs.getString("plates"), afm, rs.getString("date_contract"));

                myVehicles.add(vehicle);
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmListWithVehicles != null) {

                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }


            return myVehicles;
        }
    }

    //easy way!!!
    @Override
    public void sortedPlatesFromDatabase() {
        List<Vehicle> myPlates = getVehicles();

        Collections.sort(myPlates,new Comparator<Vehicle>(){

            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o1.getPlates().compareToIgnoreCase(o2.getPlates());
            }
        });

        for(Vehicle x:myPlates) {
            System.out.println(x.getPlates());
        }
    }

    /*public void sortedPlatesFromDatabase1(){



    }*/


}

