package com.example;

import javax.swing.*;
import java.awt.*;
import org.atsign.client.api.AtClient;
import org.atsign.common.AtSign;
import org.atsign.common.KeyBuilders;
import org.atsign.common.Keys.SharedKey;
import org.atsign.common.KeyBuilders.SharedKeyBuilder;

public class App extends JFrame {
    private JTextArea outputTextArea;
    private JPanel consolePanel;
    private JLabel consoleLabel;
    private int consoleX = 150; 
    private int consoleY = 150; 
    private boolean consoleColor = false; 
    private int previousX = 0;
    private int previousY = 0;
    public App() {

        // Sets up the basic window properties

        setTitle("ATSIGN Joystick");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creates main panel to hold all the components of the window

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Creates title label

        JLabel titleLabel = new JLabel("ATSIGN Joystick");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);


         // Creates text area to display output

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setLineWrap(true);
        outputTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Creating the panel to hold the console label

        consolePanel = new JPanel();
        consolePanel.setPreferredSize(new Dimension(300, 300));
        consolePanel.setLayout(null);
        mainPanel.add(consolePanel, BorderLayout.SOUTH);

        // Creates the label to represent the console

        consoleLabel = new JLabel();
        consoleLabel.setBounds(consoleX, consoleY, 20, 20);
        consoleLabel.setOpaque(true);
        consoleLabel.setBackground(Color.BLACK);
        consolePanel.add(consoleLabel);

        getContentPane().add(mainPanel);
        setVisible(true);
    }

    // Displays output in the text area
    public void displayOutput(String output) {

        // Splitting the input data into x, y, and z 

        String[] parts = output.split(",");
        int xIndex = parts[0].indexOf("=") + 1;
        int yIndex = parts[1].indexOf("=") + 1;
        int zIndex = parts[2].indexOf("=") + 1;
        int x = Integer.parseInt(parts[0].substring(xIndex));
        int y = Integer.parseInt(parts[1].substring(yIndex));
        int z = Integer.parseInt(parts[2].substring(zIndex));
    
        // Check if the difference between the current and previous x and y values is at least 50

        if (Math.abs(x - previousX) >= 50 || Math.abs(y - previousY) >= 50) {
            outputTextArea.append(output + "\n");
            moveConsole(x, y);  // Updates the console position
            changeConsoleColor(z); // Changes the console color
            previousX = x;
            previousY = y;
        }
    }
       
    

    // Updates the position of the console label

    private void moveConsole(int x, int y) {

        // Define console properties

        int consoleRadius = 120;
        int consoleDiameter = consoleRadius * 2;
        int consoleCenterX = consolePanel.getWidth() / 2;
        int consoleCenterY = consolePanel.getHeight() / 2;
        double xScale = (double) consoleRadius / 2048;
        double yScale = (double) consoleRadius / 2048;

        // Calculate the new console position based on the scales

        int consoleNewX = consoleCenterX + (int) Math.round(x * xScale) - 10;
        int consoleNewY = consoleCenterY + (int) Math.round((2048 - y) * yScale) - 10;
        consoleLabel.setBounds(consoleNewX, consoleNewY, 20, 20);
        consoleX = consoleNewX;
        consoleY = consoleNewY;
    }

    // Changes the console color based on the z value

    private void changeConsoleColor(int z) {
        if (z == 1 && !consoleColor) {
            consoleLabel.setBackground(Color.RED);
            consoleColor = true;
        } else if (z == 0 && consoleColor) {
            consoleLabel.setBackground(Color.BLACK);
            consoleColor = false;
        }
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        AtSign java = new AtSign("@leopeaceful21");
        AtSign at_sign = new AtSign("@technological25");
        AtClient atClient = AtClient.withRemoteSecondary("root.atsign.org:64", java);

        // Create a shared key object

        SharedKey sharedKey = new KeyBuilders.SharedKeyBuilder(at_sign, java).key("JTD").build();



        while (true) {

            // Get the data from the shared key and split it into parts

            String data = atClient.get(sharedKey).get();
            String[] parts = data.split(",");

            // Format the data and display it in the app
            
            String formattedData = String.format("Data: x=%s, y=%s, z=%s", parts[0], parts[1], parts[2]);
            app.displayOutput(formattedData);
            Thread.sleep(50);
        }
        
    }
}