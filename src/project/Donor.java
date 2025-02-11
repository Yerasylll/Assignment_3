package project;

import java.util.ArrayList;

public class Donor {
    private String name;
    private String lastName;
    private static int id_gen = 1;
    private int id;
    private ArrayList<Donation> donations;

    public Donor() {
        id = id_gen++;
    }

    public Donor(String name, String lastName) {
        this();
        setName(name);
        setLastName(lastName);
        donations = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

//    @Override
//    public String toString() {
//        return id + ": " + name + " " + lastName;
//    }
}

