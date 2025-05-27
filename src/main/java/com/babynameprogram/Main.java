package com.babynameprogram;

import java.io.FileReader;
import java.util.LinkedList;
import com.opencsv.CSVReader;

public class Main {
    private LinkedList<Baby_Name> namelist;

    public void read_Data(String filepath) {
        namelist = new LinkedList<>();
        try {
            CSVReader cr = new CSVReader(new FileReader(filepath));
            String[] data = cr.readNext();
            while( (data = cr.readNext()) != null ) {
                namelist.add(new Baby_Name(data[0], data[1], Integer.parseInt(data[2]),
                        Integer.parseInt(data[3]), Integer.parseInt(data[4])));
            }
            cr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void menu() {
        System.out.println("BABY NAME PROGRAM");
        System.out.println("------------------------------------");
        System.out.println("[1] Adding One Baby Name");
        System.out.println("[2] Adding Baby Name By Year");
        System.out.println("[3] Editing One Baby Name");
        System.out.println("[4] Deleting One Baby Name");
        System.out.println("[5] Deleting Baby Name By Year");
        System.out.println("[6] Reporting Baby Name By Year");
        System.out.println("[7] Reporting Top 10 Baby Names");
        System.out.println("[8] Exiting Program");
        System.out.println("------------------------------------");
        System.out.print("Choose menu between 1 and 8: ");
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.read_Data("data/Baby_Names.csv");
        System.out.println("Total Name List: " + m.namelist.size());
        m.menu();
    }
}