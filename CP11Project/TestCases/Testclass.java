import com.example.cp11project.Controller;
import com.example.cp11project.Items;
import com.example.cp11project.Orders;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static com.example.cp11project.Orders.Order;
import static com.example.cp11project.Orders.createord;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Testclass {
    /*double totalcost = 10.00;
    Orders order1 = new Orders(totalcost, "tester");
    Orders order10 = new Orders(totalcost, "tester1");
    Items burger = new Items("Cheeseburger",2.00);
    Items cookie = new Items("Cookie", 99.00);
    String order = "coke,sprite,fries,8.78";
    static String[] splicetest;
    static double testtemp;
    private static void Createorders(String order) {
        String[] Splice = order.split(",");
        splicetest = Splice;
        for (int i = 0; i < Splice.length; i++) {
            if (i<Splice.length-1) {
                Items createitem = new Items(Splice[i], 0);
                createord.add(createitem);
            }
            else {
                double temp = Double.parseDouble(Splice[i]);
                testtemp = temp;
                Orders createorder = new Orders(temp, "");
                Order.add(createorder);
            }
        }
    }


    @Test
    public void OrdertoString(){
        assertEquals(order1.toString(), "tester");
        assertEquals(order10.toString(), "tester1");
    }

    @Test
    public void ItemtoString() {
        assertEquals(burger.toString(), "Cheeseburger");
        assertEquals(cookie.toString(), "Cookie");
    }


    @Test
    public void creatingordertest(){
        Createorders(order);
        assertEquals(splicetest.length,4);
        assertEquals(Order.size(),1);
        assertEquals(createord.size(),3);
        assertEquals(testtemp,8.78);

     */
}
