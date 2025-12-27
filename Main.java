
// Java program using label (swing)
// to display the message “GFG WEB Site Click”
import java.io.*;
import javax.swing.*;

import java.awt.TrayIcon.MessageType;
import java.awt.event.*;

// Main class
public class Main {

    static int buttonCount = 0;
    final static int buttonX = 50;
    final static int buttonY = 100;
    final static int buttonWidth = 50;
    final static int buttonHeight = 50;

    // Main driver method
    public static void main(String[] args) {
        // Creating instance of JFrame
        JFrame frame = new JFrame("Hey");

        JButton button = new JButton("You can add button by clicking this button");
        button.setBounds(buttonX, 20, 300, buttonHeight);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currButtonIndex = buttonCount++;
                int currButtonCount = currButtonIndex + 1;
                int row = (currButtonIndex % 10) + 1;
                int colm = (currButtonIndex / 10) + 1;

                JButton newButton = new JButton("%d".formatted(currButtonCount));
                newButton.setBounds(row * buttonX, buttonY * colm, buttonWidth, buttonHeight);
                newButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (currButtonCount % 10 == 0) {
                            JOptionPane.showMessageDialog(button, "BOOMMM", "You die", 0);
                            frame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(button, "You clicked %dth button".formatted(currButtonCount));
                        }
                    }
                });
                frame.add(newButton);

                JOptionPane.showMessageDialog(frame, "You have successfully created a button");
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(button);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}