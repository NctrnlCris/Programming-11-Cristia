package com.example.friendsbook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateFriends {
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friends> friends = new ArrayList<>();

    public static ArrayList createAllFriends(String filename) throws IOException {
        // Requires: filename
        // Modifies: line, friendString
        // Effects: Reads file line by line and adds friends attributes to String. Calls parse method
        friends.clear();
        fr = new FileReader(filename);
        br = new BufferedReader(fr);
        String line;
        String friendsString = "";
        while ((line = br.readLine()) != null) {
            if (!line.equals(";")) {
                friendsString += line;
            } else {
                parseFriends(friendsString);
                friendsString = "";
            }
        }
        return friends;
    }
    private static void parseFriends(String string) {
        // Requires: string
        // Modifies name, age, school, hobbies, since, checker, friends
        // Effects: Splits String by characteristic and collect into individual Strings to give to Friend object. Adds to array if does not exist already.
        String[] Splice = string.split(",");
        String name = Splice[0];
        int age = Integer.parseInt(Splice[1]);
        String school = Splice[2];
        String hobbies = Splice[3];
        String known_for = Splice[4];
        Friends friend = new Friends(name, age, school, hobbies, known_for);
        int checker = 0;
        for (Friends f : friends) {
            if (friend.name.equals(f.name)) {
                checker++;
            }
        }
        if (checker == 0) {
            friends.add(friend);
        }

    }
}
