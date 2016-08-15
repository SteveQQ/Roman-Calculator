import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by SteveQ on 2016-08-15.
 */
public class GUI {
    private JFrame frame;
    private JPanel textAreaWrapPanel, gridWrapPanel;
    public static JTextArea numberArea;
    private JMenuBar menuBar;
    private JMenu viewMenu;

    public void createGUI(){
        frame = new JFrame("Roman Calculator");

        menuBar = new JMenuBar();
        viewMenu = new JMenu("View");

        textAreaWrapPanel = new JPanel();
        textAreaWrapPanel.setLayout(new BorderLayout());
        textAreaWrapPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        numberArea = new JTextArea();
        numberArea.setBorder(BorderFactory.createLoweredBevelBorder());
        numberArea.setFont(new Font("monospace", 0, 16));

        gridWrapPanel = new JPanel();
        gridWrapPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        gridWrapPanel.setLayout(new GridLayout(3, 4, 5, 5));
        gridWrapPanel.add(new JButton("I"));
        gridWrapPanel.add(new JButton("V"));
        gridWrapPanel.add(new JButton("X"));
        gridWrapPanel.add(new JButton("L"));
        gridWrapPanel.add(new JButton("C"));
        gridWrapPanel.add(new JButton("D"));
        gridWrapPanel.add(new JButton("M"));
        gridWrapPanel.add(new JButton("="));
        gridWrapPanel.add(new JButton("/"));
        gridWrapPanel.add(new JButton("*"));
        gridWrapPanel.add(new JButton("+"));
        gridWrapPanel.add(new JButton("-"));

        menuBar.add(viewMenu);
        frame.setJMenuBar(menuBar);
        textAreaWrapPanel.add(numberArea);
        frame.add(BorderLayout.CENTER, gridWrapPanel);

        frame.getContentPane().add(BorderLayout.NORTH, textAreaWrapPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 250);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
