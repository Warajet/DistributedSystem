import java.io.Serializable;
import java.util.*;

public class Car implements Display, Serializable {
    String colour;
    int horse_power;
    double weight;
    Car(String colour, int horse_power, double weight)
    {
        this.colour = colour;
        this.horse_power = horse_power;
        this.weight = weight;
    }
    public String print()
    {
        String tmp = "Car color : " + this.colour + " horse power: " + String.format("%d ", this.horse_power) + " Weight: " + String.format("%.2f kg", this.weight);
        System.out.println(tmp);
        return tmp;
    }
}
