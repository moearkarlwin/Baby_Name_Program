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

    public static void main(String[] args) {
        Main m = new Main();
        m.read_Data("data/Baby_Names.csv");
        System.out.println(m.namelist.getLast());
    }
}