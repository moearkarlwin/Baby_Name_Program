package com.babynameprogram;

import java.util.LinkedList;
import java.util.Scanner;

public class Adding_Baby_Name {
    private LinkedList<Baby_Name> namelist;
    private Data_Write_Validation dwv = new Data_Write_Validation();

    public Adding_Baby_Name(LinkedList<Baby_Name> namelist) {
        this.namelist = namelist;
    }

    public void add_Name() {
        String name = dwv.get_Name();
        String gender = dwv.get_Gender();
        String year = dwv.get_Year();
        if(!dwv.valid_Name(name, gender, year, namelist)) {
            add_Name();
        }

    }
}
