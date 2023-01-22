package com.example.chancegame;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    public Label moneypool; // Fields being manipulated
    public Label displaybet;
    public TextField getbet;
    public Label diceroll;
    public Label txtresult;
    public Button btnhigh;
    public Button btnlow;
    int random = 4; //Starting variables to use before running methods
    int total = 500;

    public void btnhigher(ActionEvent actionEvent) {
        //Requires: Button press
        //Modifies: Money pool, random dice roll, result text
        //Effects: Checks to see if next roll is higher than previous and awards or removes money equal to bet amount. Shares user results.
        double bet = Double.parseDouble(displaybet.getText());
        if (bet<total) { //Only works if there is enough money to bet
            int nextrandom = (int) (Math.random() * 6 + 1);
            if (nextrandom > random) {
                txtresult.setText("You Win $" + displaybet.getText());
                total += bet;
                moneypool.setText("$" + total);
            } else {
                txtresult.setText("You Lose $" + displaybet.getText());
                total -= bet;
                moneypool.setText("$" + total);
            }
            random = nextrandom; //resetting for next round
            diceroll.setText(String.valueOf(random));
        }
        else {
            txtresult.setText("You're too broke for that");
        }
    }

    public void btnlower(ActionEvent actionEvent) {
        //Requires: Button press
        //Modifies: Money pool, random dice roll, result text
        //Effects: Checks to see if next roll is lower than previous and awards or removes money equal to bet amount. Shares user results.
        double bet = Double.parseDouble(displaybet.getText());
        if (bet <= total) { //Only works if there is enough money to bet
            int nextrandom = (int) (Math.random() * 6 + 1);
            if (nextrandom < random) {
                txtresult.setText("You Win $" + displaybet.getText());
                total += bet;
                moneypool.setText("$" + total);
            } else {
                txtresult.setText("You Lose $" + displaybet.getText());
                total -= bet;
                moneypool.setText("$" + total);
            }
            random = nextrandom; //resetting for next round
            diceroll.setText(String.valueOf(random));
        }
        else {
            txtresult.setText("You're too broke for that");
        }
    }
    public void btnplacebet(ActionEvent actionEvent) {
        //Requires: Button Press
        //Modifies: btnhigh, btnlow, bet label
        //Effects: Displays bet and enables higher and lower buttons for gameplay. No risk no play!
        double bet = Double.parseDouble(getbet.getText());
        if (bet <= total) { //Only works if there is enough money to bet
            displaybet.setText(String.valueOf(bet));
            btnhigh.setDisable(false);
            btnlow.setDisable(false);
            getbet.clear();
        }
        else {
            txtresult.setText("You're too broke for that");
            displaybet.setText("0");
            getbet.clear();
        }

    }
}
