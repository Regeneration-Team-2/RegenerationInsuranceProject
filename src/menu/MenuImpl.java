package menu;

import utilities.ReadFromConsole;

import java.util.Scanner;

public class MenuImpl implements Menu {

    @Override
    public void mainMenu() {
        System.out.println("==================================");
        System.out.println(" Select Functionality to perform ");
        System.out.println("==================================\n");
        System.out.println("1-Vehicle insurance status");
        System.out.println("2-Expires by date");
        System.out.println("3-Sorting");
        System.out.println("4-Calculate tha fine");
        System.out.println("0-Exit\n");
    }

    @Override
    public void subMenu() {
        System.out.println("## Enter the export type ##\n");
        System.out.println("1-console");
        System.out.println("2-CSV");
    }



    @Override
    public void costMenou() {
        System.out.println("Please insert the value of fine: ");
    }

    @Override
    public void afmMenu() {
        System.out.println("Please insert the afm: ");
    }
}
