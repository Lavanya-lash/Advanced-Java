/*Develop a Swing program in Java to create a Tabbed Pan of Cyan, Magenta and
Yellow and display the concerned color whenever the specific tab is selected in the Pan*/
package basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TabbedColorPane {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Tabbed Pane Colors");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Panels
        JPanel cyanPanel = createPanel(Color.CYAN, "Cyan");
        JPanel magentaPanel = createPanel(Color.MAGENTA, "Magenta");
        JPanel yellowPanel = createPanel(Color.YELLOW, "Yellow");

        tabbedPane.addTab("Cyan", cyanPanel);
        tabbedPane.addTab("Magenta", magentaPanel);
        tabbedPane.addTab("Yellow", yellowPanel);

        frame.add(tabbedPane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static JPanel createPanel(Color color, String name) {

        JPanel panel = new JPanel();
        panel.setBackground(color);

      
        panel.setFocusable(true);

        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Selected Color: " + name);
            }
        });

        return panel;
    }
}