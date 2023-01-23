package com.example.friendsbook;

import java.util.jar.Attributes;

public class Friends {

    String name;
    String age;
    String school;
    String hobbies;
    String since;

    Friends(String Name, String Age, String School, String Hobbies, String Since){
        //Default Constructor for Friends object
        this.name = Name;
        this.age = Age;
        this.school = School;
        this.hobbies = Hobbies;
        this.since = Since;
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
        return this.age;
    }

    public String getschool() {
        return this.school;
    }

    public String gethobbies(){
        return this.hobbies;
    }

    public String getsince() {
        return this.since;
    }

}
