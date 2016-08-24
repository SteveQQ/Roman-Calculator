import com.steveqq.gui.ButtonClicker;
import com.steveqq.gui.GUI;

/**
 * Created by SteveQ on 2016-08-15.
 */
public class RomanCalculatorMain {
    public static void main(String[] args){
        GUI gui = new GUI();
        new ButtonClicker(gui);
        gui.createGUI();
    }
}
