/*4c. Develop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour Glass
is pressed” depending upon the Jbutton with image either Digital Clock or Hour Glass is pressed by
implementing the event handling mechanism with addActionListener( ).*/
package swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClockGlassDemo extends JFrame implements ActionListener
{
    JButton b1,b2;
    JLabel l;

    ClockGlassDemo()
    {
        setTitle("Clock Glass Demo");
        setSize(600,400);
        setLayout(new FlowLayout());

        l = new JLabel("Click any image");
        l.setFont(new Font("Arial",Font.BOLD,30));

        ImageIcon i1 = new ImageIcon(getClass().getResource("/images/digitalclock.jpg"));
        Image img1 = i1.getImage().getScaledInstance(120,120,Image.SCALE_SMOOTH);
        b1 = new JButton(new ImageIcon(img1));

        ImageIcon i2 = new ImageIcon(getClass().getResource("/images/hourglass.jpg"));
        Image img2 = i2.getImage().getScaledInstance(120,120,Image.SCALE_SMOOTH);
        b2 = new JButton(new ImageIcon(img2));

        b1.addActionListener(this);
        b2.addActionListener(this);

        add(l);
        add(b1);
        add(b2);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
            l.setText("You have pressed Digital Clock!");
        else
            l.setText("You have pressed Hour Glass!");
    }

    public static void main(String args[])
    {
        new ClockGlassDemo();
    }
}