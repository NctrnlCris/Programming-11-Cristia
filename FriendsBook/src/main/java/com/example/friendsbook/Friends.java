package com.example.friendsbook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Friends {

    String name;
    int age;
    String school;
    String hobbies;
    String known_for;

    Friends(String Name, int Age, String School, String Hobbies, String Known_For){
        //Default Constructor for Friends object
        this.name = Name;
        this.age = Age;
        this.school = School;
        this.hobbies = Hobbies;
        this.known_for = Known_For;
    }
    public void writeToFile(String file) throws IOException{
        // Requires: file
        // Modifies: file
        // Effects: Writes the attributes of a friend to a text file
        // Must I keep doing comments like this :/
        FileWriter fw = new FileWriter( file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name +",\r");
        bw.write(age + ",\r");
        bw.write(school + ",\r");
        bw.write(hobbies + ",\r");
        bw.write(known_for + "\r");
        bw.write(";\r");
        bw.close();
    }
    public String toString() {
        // Effects: Overiding method to display String on the list
        return name;
    }
    // Some getters for displaying attributes
    public String getname() {
        return this.name;
    }

    public String getage() {
        return String.valueOf(this.age);
    }

    public String getschool() {
        return this.school;
    }

    public String gethobbies(){
        return this.hobbies;
    }

    public String getsince() {
        return this.known_for;
    }

}
