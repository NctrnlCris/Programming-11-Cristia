package com.example.friendsbook;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;

public class Controller {
    public ListView<Friends> list = new ListView<>();
    public Label lblname;
    public Label lblage;
    public Label lblhobbies;
    public Label lblsince;
    public Label lblschool;
    public Button btndelfriend;
    public TextField txtfldname;
    public TextField txtfldage;
    public TextField txtfldschool;
    public TextField txtfldhobbies;
    public TextField txtfldsince;
    public Tab tabFriendslist;


    public void addfriend(ActionEvent actionEvent) {
        // Requires Button Press
        // Modifies: list, delfriend, txtfldname, txtfldage, txtfldhobbies, txtfldschool, txtfldsince
        // Effects: Adds a friend to the list with details given in text fields. Clears text fields. Enables remove friend button. Sets list visible.
        Friends friend = new Friends(txtfldname.getText(), txtfldage.getText(), txtfldschool.getText(), txtfldhobbies.getText(), txtfldsince.getText());
        list.getItems().add(friend);
        btndelfriend.setDisable(false);
        list.setVisible(false);
        txtfldage.clear();
        txtfldhobbies.clear();
        txtfldname.clear();
        txtfldschool.clear();
        txtfldsince.clear();




    }

    public void delfriend(ActionEvent actionEvent) {
        // Requires: Button Press
        // Modifies: list
        // Effects: Deletes the selected friend from the list
        int friendID = list.getSelectionModel().getSelectedIndex();
        list.getItems().remove(friendID);
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
        lblsince.setText((buddy.getsince()));
    }




}