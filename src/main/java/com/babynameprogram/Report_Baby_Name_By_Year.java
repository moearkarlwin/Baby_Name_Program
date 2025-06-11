package com.babynameprogram;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.LinkedList;

public class Report_Baby_Name_By_Year {
    private LinkedList<Baby_Name> namelist;
    private Data_Write_Validation dwv = new Data_Write_Validation();

    public Report_Baby_Name_By_Year(LinkedList<Baby_Name> namelist) {
        this.namelist = namelist;
        System.out.println("Report Baby Name By Year");
        System.out.println("------------------------");
    }

    public void report_Name() {
        String searchyear = dwv.get_Year();
        while(dwv.valid_Year(searchyear, namelist)) {
            searchyear = dwv.get_Year();
        }

        LinkedList<Baby_Name> malelist = new LinkedList<>();
        LinkedList<Baby_Name> femalelist = new LinkedList<>();
        for(Baby_Name b: namelist) {
            if(b.getYear() == Integer.parseInt(searchyear)) {
                if(b.getGender().equals("M")) {
                    malelist.add(b);
                }
                else {
                    femalelist.add(b);
                }
            }
        }

        System.out.println("Male Baby Name in " + searchyear);
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow(new Object[]{"No.", "Name", "Gender", "Year", "Rank", "Count"}).setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        int no = 1;
        for(Baby_Name b: malelist) {
            at.addRow(new Object[]{no, b.getName(), b.getGender(), b.getYear(), b.getRank(), b.getCount()});
            if(no == 10) {
                break;
            }
            no++;
        }
        at.addRule();
        System.out.println(at.render());

        System.out.println("Female Baby Name in " + searchyear);
        at = new AsciiTable();
        at.addRule();
        at.addRow(new Object[]{"No.", "Name", "Gender", "Year", "Rank", "Count"}).setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        no = 1;
        for(Baby_Name b: femalelist) {
            at.addRow(new Object[]{no, b.getName(), b.getGender(), b.getYear(), b.getRank(), b.getCount()});
            if(no == 10) {
                break;
            }
            no++;
        }
        at.addRule();
        System.out.println(at.render());
    }
}
