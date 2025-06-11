package com.babynameprogram;

import java.util.LinkedList;

public class Delete_Baby_Name {
    private LinkedList<Baby_Name> namelist;
    private Data_Write_Validation dwv = new Data_Write_Validation();

    public Delete_Baby_Name(LinkedList<Baby_Name> namelist) {
        this.namelist = namelist;
        System.out.println("Deleting Baby Name");
        System.out.println("------------------");
    }

    public void delete_Name() {
        String searchname = dwv.get_Name();
        String searchgender = dwv.get_Gender();
        String searchyear = dwv.get_Year();
        int index;
        while( (index = dwv.search_Name(searchname, searchgender, searchyear, namelist)) < 0) {
            searchname = dwv.get_Name();
            searchgender = dwv.get_Gender();
            searchyear = dwv.get_Year();
        }

        namelist.remove(index);
        dwv.ranking(namelist, searchgender, searchyear);
        dwv.write(namelist);
        System.out.println("Successfully delete baby name.");
    }
}
