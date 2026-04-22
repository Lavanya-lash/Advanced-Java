/* Develop a Swing program in Java to add the countries USA, India, Vietnam, Canada, Denmark,
France, Great Britain, Japan, Africa, Greenland, Singapore into a JList and display the capital of the
countries on console whenever the countries are selected on the list.*/
package basic;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountryCapitalList {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Tabbed Pane Colors");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Method to create panel with click event
        JPanel cyanPanel = createColorPanel(Color.CYAN, "Cyan");
        JPanel magentaPanel = createColorPanel(Color.MAGENTA, "Magenta");
        JPanel yellowPanel = createColorPanel(Color.YELLOW, "Yellow");

        // Add tabs
        tabbedPane.addTab("Cyan", cyanPanel);
        tabbedPane.addTab("Magenta", magentaPanel);
        tabbedPane.addTab("Yellow", yellowPanel);

        frame.add(tabbedPane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Reusable method (clean code)
    static JPanel createColorPanel(Color color, String name) {
        JPanel panel = new JPanel();
        panel.setBackground(color);

        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Selected Color: " + name);
            }
        });

        return panel;
    }
}