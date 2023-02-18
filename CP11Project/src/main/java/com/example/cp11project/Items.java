package com.example.cp11project;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class Items {
    String name;
    Double cost;

    public Items(String Name, double Cost) {
        this.name = Name;
        this.cost = Cost;
    }
    public String toString(){
        return this.name;
    }

    public static void writeToFile(String file, ListView lv, double totalorder) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i=0; i< lv.getItems().size();i++) {
        bw.write(lv.getItems().get(i) + ",\r");
        }
        bw.write(totalorder + "\r");
        bw.write(";\r");
        bw.close();
    }



    public String getName() {
        return name;
    }

    public Double getCost() {
        return cost;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

}

