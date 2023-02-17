import com.example.cp11project.Controller;
import com.example.cp11project.Items;
import com.example.cp11project.Orders;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Testclass {
    double totalcost = 10.00;
    Orders order1 = new Orders(totalcost);
    Orders order10 = new Orders(totalcost);
    Items burger = new Items("Cheeseburger",2.00);
    Items cookie = new Items("Cookie", 99.00);
    String filename = "1";
    String line;
    private  FileReader fr = new FileReader(filename);
    private  BufferedReader br = new BufferedReader(fr);
    Button test = new Button();
    Controller controller;

    public Testclass() throws FileNotFoundException {
    }

    @Test
    public void OrdertoString(){
        assertEquals(order1.toString(), (String.valueOf(1)));
        assertEquals(order10.toString(), (String.valueOf(2)));
        assertEquals(order1.getTotalcost(), 10.00);
    }

    @Test
    public void ItemtoString(){
        assertEquals(burger.toString(),"Cheeseburger");
        assertEquals(cookie.toString(), "Cookie");
    }

    @Test
    public void Totaladding(){
        controller = new Controller();
        totalcost = controller.calculatetotal(10);
        assertEquals(totalcost,10);
        totalcost = controller.calculatetotal(10);
        assertEquals(totalcost, 20);
    }






}
