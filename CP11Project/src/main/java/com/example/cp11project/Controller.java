package com.example.cp11project;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Controller {


    public Tab Takingtab;
    public Tab Listtab;
    public javafx.scene.control.TabPane TabPane;
    public Tab Beginningtab;

    public ListView<Items> getListtaking() {
        return listtaking;
    }

    @FXML
    public ListView <Items>listtaking = new ListView<>();
    public ListView <Orders> listcurrent;
    public ListView <Items> listorder;
    public Label txtTotal;
    public double total = 0.00;
    public  Label txtTotalOL;
    public TextField txtsearchorder;
    public Button btnsearchordID;
    public TextField ordername;
    public ObservableList<Items> temp;


    public void StartSwitch(MouseEvent mouseEvent) {
        TabPane.getSelectionModel().select(Takingtab);
        Takingtab.setDisable(false);
        Beginningtab.setDisable(true);
    }
    public void OrderIn(ActionEvent actionEvent) throws IOException {
        if (!listtaking.getItems().isEmpty() && !ordername.getText().equals("")){
            Orders orderin = new Orders(total, ordername.getText());
            temp = listtaking.getItems();
            System.out.print(temp);
            System.out.println(orderin.totalcost);
            System.out.println(orderin);
            System.out.println(listtaking.getItems());
            listcurrent.getItems().add(orderin);
            String FileName = orderin.ordername;
            new File(FileName + ".txt");
            Items.writeToFile(FileName, listtaking, total);
            listtaking.getItems().clear();
            ordername.clear();
    }


    }

    public double calculatetotal(double cost){
        total += cost*1.12;
        return total;
    }

    public double removecalculate(double cost){
        total -= cost*1.12;
        return total;
    }





    public void Removeitem(ActionEvent actionEvent) {
        Items remove = new Items("",0);
        remove.name = listtaking.getSelectionModel().getSelectedItem().getName();
        remove.cost = listtaking.getSelectionModel().getSelectedItem().getCost();
        txtTotal.setText(String.valueOf(removecalculate(remove.cost)));
        listtaking.getItems().remove(listtaking.getSelectionModel().getSelectedItem());
        if (listtaking.getItems().size() == 0){
            total = 0;
        }
        txtTotal.setText(String.valueOf(total));

    }

    public void RemoveAll(ActionEvent actionEvent) {
        listtaking.getItems().clear();
        total = 0;
        txtTotal.setText(String.valueOf(total));
    }

    public void completeorder(ActionEvent actionEvent) {
        if (!listcurrent.getSelectionModel().isEmpty()) {
            listcurrent.getItems().remove(listcurrent.getSelectionModel().getSelectedItem());
            listorder.getItems().clear();
            txtTotalOL.setText("0");
        }



    }



    public void btnsearchorder(ActionEvent actionEvent) throws IOException{
        String Filename = txtsearchorder.getText();
        ArrayList<Items> items = Orders.ReadFile(Filename);
        System.out.println(items);
        ArrayList <Orders> orders = Orders.getOrder();
        System.out.println(orders);
        if (!items.isEmpty()) {
            for (Items i : items) {
                System.out.print("test");
                listorder.getItems().add(i);
            }
        }
        txtTotalOL.setText(String.valueOf(orders.get(0).totalcost));
        btnsearchordID.setDisable(true);
        items.clear();
        int count = 0;
        for( int i=0; i<listcurrent.getItems().size(); i++) {
            if (!listcurrent.getItems().get(i).toString().equals(Filename)) {
            }
            else {
                count++;
            }
        }
        if (count == 0){
            listcurrent.getItems().add(new Orders(0, Filename));
        }
    }
    public void ClearOrder(ActionEvent actionEvent) {
        btnsearchordID.setDisable(false);
        listorder.getItems().clear();
        txtsearchorder.clear();
        txtTotalOL.setText("0");

    }


    public void btncheeseburger(ActionEvent actionEvent) {
        Items cheeseburger = new Items("Cheese Burger",7.00);
        listtaking.getItems().add(cheeseburger);
        calculatetotal(cheeseburger.cost);
        txtTotal.setText(String.valueOf(total));
    }


    public void btnchickenwrap(ActionEvent actionEvent) {
        Items chickenwrap = new Items("Chicken Wrap", 6.00);
        listtaking.getItems().add(chickenwrap);
        calculatetotal(chickenwrap.cost);
        txtTotal.setText(String.valueOf(total));
    }

    public void btnchickennuggets(ActionEvent actionEvent) {
        Items chickennuggets = new Items("Chicken Nuggets", 7.00);
        listtaking.getItems().add(chickennuggets);
        calculatetotal(chickennuggets.cost);
        txtTotal.setText(String.valueOf(total));
    }

    public void btnveganburger(ActionEvent actionEvent) {
        Items veganburger = new Items("Vegan Burger", 8.00);
        listtaking.getItems().add(veganburger);
        calculatetotal(veganburger.cost);
        txtTotal.setText(String.valueOf(total));
    }

    public void btngreeksalad(ActionEvent actionEvent) {
        Items greeksalad = new Items("Greek Salad", 6.00);
        listtaking.getItems().add(greeksalad);
        calculatetotal(greeksalad.cost);
        txtTotal.setText(String.valueOf(total));
    }

    public void btnbacondoubleburger(ActionEvent actionEvent) {
        Items bacondoubleburger = new Items("Bacon Double Burger", 11.00);
        listtaking.getItems().add(bacondoubleburger);
        total += bacondoubleburger.getCost()*1.12;
        txtTotal.setText(String.valueOf(total));
    }

    public void btnfries(ActionEvent actionEvent) {
        Items fries = new Items("Fries", 4.00);
        listtaking.getItems().add(fries);
        calculatetotal(fries.cost);
        txtTotal.setText(String.valueOf(total));
    }

    public void btnonionrings(ActionEvent actionEvent) {
        Items onionrings = new Items("Onion Rings", 4.00);
        listtaking.getItems().add(onionrings);
        calculatetotal(onionrings.cost);
        txtTotal.setText(String.valueOf(total));
    }

    public void btncaesarsalad(ActionEvent actionEvent) {
        Items caesarsalad = new Items("Caesar Salad", 4.00);
        listtaking.getItems().add(caesarsalad);
        calculatetotal(caesarsalad.cost);
        txtTotal.setText(String.valueOf(total));
    }

    public void btnsoup(ActionEvent actionEvent) {
        Items soup = new Items("Soup", 4.00);
        listtaking.getItems().add(soup);
        calculatetotal(soup.cost);
        txtTotal.setText(String.valueOf(total));
    }

    public void btncake(ActionEvent actionEvent) {
        Items cake = new Items("Cake", 5.50);
        listtaking.getItems().add(cake);
        calculatetotal(cake.cost);
        txtTotal.setText(String.valueOf(total));
    }

    public void btnsundae(ActionEvent actionEvent) {
        Items sundae = new Items("Sundae", 3.50);
        listtaking.getItems().add(sundae);
        calculatetotal(sundae.cost);
        txtTotal.setText(String.valueOf(total));
    }

    public void btncocacola(ActionEvent actionEvent) {
        Items cocacola = new Items("Coca Cola", 3.00);
        listtaking.getItems().add(cocacola);
        calculatetotal(cocacola.cost);
        txtTotal.setText(String.valueOf(total));
    }

    public void btnsprite(ActionEvent actionEvent) {
        Items sprite = new Items("Sprite", 3.00);
        listtaking.getItems().add(sprite);
        calculatetotal(sprite.cost);
        txtTotal.setText(String.valueOf(total));

    }

    public void btnnestea(ActionEvent actionEvent) {
        Items nestea = new Items("Nestea", 3.00);
        listtaking.getItems().add(nestea);
        calculatetotal(nestea.cost);
        txtTotal.setText(String.valueOf(total));
    }

    public void btnfanta(ActionEvent actionEvent) {
        Items fanta = new Items("Fanta", 3.00);
        listtaking.getItems().add(fanta);
        calculatetotal(fanta.cost);
        txtTotal.setText(String.valueOf(total));
    }

    public void btnwater(ActionEvent actionEvent) {
        Items water = new Items("Water", 0.00);
        listtaking.getItems().add(water);
    }

    public void btncoffee(ActionEvent actionEvent) {
        Items coffee = new Items("Coffee", 2.50);
        listtaking.getItems().add(coffee);
        calculatetotal(coffee.cost);
        txtTotal.setText(String.valueOf(total));
    }

    public void btnmilkshake(ActionEvent actionEvent) {
        Items milkshake = new Items("Milkshake", 5.00);
        listtaking.getItems().add(milkshake);
        calculatetotal(milkshake.cost);
        txtTotal.setText(String.valueOf(total));
    }

    public void btnlemonnade(ActionEvent actionEvent) {
        Items lemonnade = new Items("Lemonnade",2.50);
        listtaking.getItems().add(lemonnade);
        calculatetotal(lemonnade.cost);
        txtTotal.setText(String.valueOf(total));
    }




}