package com.babynameprogram;

import java.util.LinkedList;

public class Edit_Baby_Name {
    private LinkedList<Baby_Name> namelist;
    private Data_Write_Validation dwv = new Data_Write_Validation();

    public Edit_Baby_Name(LinkedList<Baby_Name> namelist) {
        this.namelist = namelist;
        System.out.println("Editing Baby Name");
        System.out.println("--------------------");
    }

    public void edit_Name() {
        String searchname = dwv.get_Name();
        String searchgender = dwv.get_Gender();
        String searchyear = dwv.get_Year();
        int index;
        while( (index = dwv.search_Name(searchname, searchgender, searchyear, namelist)) < 0) {
            searchname = dwv.get_Name();
            searchgender = dwv.get_Gender();
            searchyear = dwv.get_Year();
        }

        String name = dwv.get_Name();
        String gender = dwv.get_Gender();
        String year = dwv.get_Year();
        while(!dwv.valid_Name(name, gender, year, namelist, index)) {
            name = dwv.get_Name();
            gender = dwv.get_Gender();
            year = dwv.get_Year();
        }
        String count = dwv.get_Count();

        namelist.set(index, new Baby_Name(name, gender, Integer.parseInt(year), 0, Integer.parseInt(count)));
        dwv.ranking(namelist, searchgender, searchyear);
        dwv.ranking(namelist, gender, year);
        dwv.write(namelist);
        System.out.println("Successfully edit baby name.");
    }
}
