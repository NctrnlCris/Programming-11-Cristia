package com.example.cp11project;

import javafx.scene.control.ListView;

import java.io.*;
import java.util.ArrayList;

import static com.example.cp11project.Controller.listorder;

public class Orders {
    private static FileReader fr;
    private static BufferedReader br;
    static int ordernumber = 1;
    int idnum;

    public double getTotalcost() {
        return totalcost;
    }

    double totalcost = 0;

    public Orders(double TotalCost) {
        idnum = ordernumber;
        ordernumber++;
        this.totalcost = TotalCost;
    }

    public static ArrayList<Orders> Order = new ArrayList<>();
    public static ArrayList<Items> createord = new ArrayList<>();


    public static ArrayList ReadFile(String filename) throws IOException {
        Order.clear();
        fr = new FileReader(filename);
        br = new BufferedReader(fr);
        String line;
        String OrderString = "";
        while ((line = br.readLine()) != null) {
            if (!line.equals(";")) {
                OrderString += line;
            } else {
                Createorder(OrderString);
                OrderString = "";
            }
        }
        return Order;
    }

    private static void Createorder(String order) {
        // Requires: string
        // Modifies name, age, school, hobbies, since, checker, friends
        // Effects: Splits String by characteristic and collect into individual Strings to give to Friend object. Adds to array if does not exist already.
        String[] Splice = order.split(",");
        for (int i = 0; i < Splice.length; i++) {
            if (i<Splice.length-1) {
                Items createitem = new Items(Splice[i], 0);
                createord.add(createitem);
            }
            else {
                double totalorder = Double.parseDouble(Splice[i]);
            }
        }
    }

    public String toString() {
        return "" + idnum;
    }
}




