package com.babynameprogram;

import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

import com.opencsv.CSVReader;

public class Main {
    protected LinkedList<Baby_Name> namelist;

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

    private boolean valid_Menu_No(String input) {
        if(!input.matches("[1-8]")) {
            System.out.println("You must enter menu number between 1 and 8.");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.read_Data("data/Baby_Names.csv");
        System.out.println("Total Name List: " + m.namelist.size());

        Scanner sc = new Scanner(System.in);
        while(true) {
            m.menu();
            String input = sc.nextLine();
            if(m.valid_Menu_No(input)) {
                switch (input) {
                    case "1":
                        Adding_Baby_Name abn = new Adding_Baby_Name(m.namelist);
                        abn.add_Name();
                        break;
                    case "2":
                        Adding_Baby_Name_By_Year adny = new Adding_Baby_Name_By_Year(m.namelist);
                        adny.add_Name();
                        break;
                    case "3":
                        System.out.println("Editing One Baby Name");
                        break;
                    case "4":
                        System.out.println("Deleting One Baby Name");
                        break;
                    case "5":
                        System.out.println("Deleting Baby Name By Year");
                        break;
                    case "6":
                        System.out.println("Reporting Baby Name By Year");
                        break;
                    case "7":
                        System.out.println("Reporting Top 10 Baby Names");
                        break;
                    default:
                        System.out.println("Exiting program....");
                        System.exit(0);
                }
            }
        }
    }
}