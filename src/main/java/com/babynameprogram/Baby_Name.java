package com.babynameprogram;

public class Baby_Name {
    private String name, gender;
    private int year, rank, count;

    public Baby_Name(String name, String gender, int year, int rank, int count) {
        this.name = name;
        this.gender = gender;
        this.year = year;
        this.rank = rank;
        this.count = count;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getYear() {
        return year;
    }

    public int getRank() {
        return rank;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Baby_Name{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", year=" + year +
                ", rank=" + rank +
                ", count=" + count +
                '}';
    }
}
