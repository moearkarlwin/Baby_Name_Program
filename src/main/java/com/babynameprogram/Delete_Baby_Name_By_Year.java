package com.babynameprogram;

import java.util.LinkedList;

public class Delete_Baby_Name_By_Year {
    private LinkedList<Baby_Name> namelist;
    private Data_Write_Validation dwv = new Data_Write_Validation();

    public Delete_Baby_Name_By_Year(LinkedList<Baby_Name> namelist) {
        this.namelist = namelist;
        System.out.println("Deleting Baby Name By Year");
        System.out.println("--------------------------");
    }

    public void delete_Name() {
        String searchyear = dwv.get_Year();
        while(dwv.valid_Year(searchyear, namelist)) {
            searchyear = dwv.get_Year();
        }

        LinkedList<Baby_Name> deletelist = new LinkedList<>();
        for(Baby_Name b: namelist) {
            if(b.getYear() == Integer.parseInt(searchyear)) {
                deletelist.add(b);
            }
        }
        namelist.removeAll(deletelist);
        dwv.write(namelist);
        System.out.println("Successfully delete baby name by year.");
    }
}
