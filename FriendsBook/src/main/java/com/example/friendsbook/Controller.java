package com.example.friendsbook;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    public ListView<Friends> list = new ListView<>();
    public Label lblname;
    public Label lblage;
    public Label lblhobbies;
    public Label lblknownfor;
    public Label lblschool;
    public Button btndelfriend;
    public TextField txtfldname;
    public TextField txtfldage;
    public TextField txtfldschool;
    public TextField txtfldhobbies;
    public TextField txtfldknownfor;
    public Tab tabFriendslist;
    public Button loadfriends;
    public Button savefriends;
    public TextField filename;


    public void addfriend(ActionEvent actionEvent) {
        // Requires Button Press
        // Modifies: list, delfriend, txtfldname, txtfldage, txtfldhobbies, txtfldschool, txtfldsince
        // Effects: Adds a friend to the list with details given in text fields. Clears text fields. Enables remove friend button. Sets list visible.
        if (!txtfldname.getText().equals("") && (!txtfldschool.getText().equals("")) && (!txtfldhobbies.getText().equals("")) && (!txtfldage.getText().equals("")) && (!txtfldknownfor.getText().equals(""))) {
            Friends friend = new Friends(txtfldname.getText(), Integer.parseInt(txtfldage.getText()), txtfldschool.getText(), txtfldhobbies.getText(), txtfldknownfor.getText());
            list.getItems().add(friend);
            btndelfriend.setDisable(false);
            list.setVisible(false);
            txtfldage.clear();
            txtfldhobbies.clear();
            txtfldname.clear();
            txtfldschool.clear();
            txtfldknownfor.clear();
        }
    }

    public void delfriend(ActionEvent actionEvent) {
        // Requires: Button Press
        // Modifies: list
        // Effects: Deletes the selected friend from the list
        int friendID = list.getSelectionModel().getSelectedIndex();
        list.getItems().remove(friendID);
        System.out.println(list.getItems());
    }

    public void showfriends(ActionEvent actionEvent) {
        // Requires: Button Press
        // Modifies: list
        // Effects: Makes list visible
        list.setVisible(true);
    }


    public void Showdetails(MouseEvent mouseEvent) {
        // Requires: Mouse click on list
        // Modifies: lblname, lblage, lblschool, lblhobbies, lblsince
        // Effects: Displays the attributes of the chosen friend
        Friends buddy;
        buddy = list.getSelectionModel().getSelectedItem();
        lblname.setText(buddy.getname());
        lblage.setText(buddy.getage());
        lblschool.setText(buddy.getschool());
        lblhobbies.setText((buddy.gethobbies()));
        lblknownfor.setText((buddy.getsince()));
    }


    public void saveFriends(ActionEvent actionEvent) throws IOException {
        // Requires: button click, filename
        // Modifies: FileName, myList, loadfriends, list
        // Effects: Saves friends to file
        String FileName = filename.getText();
        new File(FileName + ".txt");
        ObservableList<Friends> myList = list.getItems();
        for (Friends f : myList) {
            f.writeToFile(FileName);
        }
        list.getItems().clear();
        loadfriends.setDisable(false);
    }

    public void loadFriends(ActionEvent actionEvent) throws IOException {
        // Requires: Button Press, filename
        // Modifies: friends, list
        // Effects: Loads friends from file to listview
        list.getItems().clear();
        ArrayList<Friends> friends = CreateFriends.createAllFriends(filename.getText());


        if (!friends.isEmpty()) {
            for (Friends f : friends) {
                list.getItems().add(f);
            }
        }

    }
}