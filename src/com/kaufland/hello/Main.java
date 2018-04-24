package com.kaufland.hello;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Main {

    public static void main(String[] args) {
        CalculatorFrame frame = new CalculatorFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class CalculatorFrame extends JFrame
{
    public CalculatorFrame()
    {
        setTitle("Calculator");
        CalculatorPanel panel = new CalculatorPanel();
        add(panel);
        pack();
    }
}


class CalculatorPanel extends JPanel {
    public CalculatorPanel() {

        setLayout(new BorderLayout());

        result = 0;
        lastCommand = "=";
        start = true;

        display = new JButton("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        // Generierung der numerischen Taschenrechner-Tasten
        addButton("7",insert);
        addButton("8",insert);
        addButton("9",insert);
        addButton("/", command);

        addButton("4",insert);
        addButton("5",insert);
        addButton("6",insert);
        addButton("*", command);

        addButton("1",insert);
        addButton("2",insert);
        addButton("3",insert);
        addButton("-", command);

        addButton("0",insert);
        addButton(".",insert);
        addButton("=", command);
        addButton("+", command);

        add(panel, BorderLayout.CENTER);
    }

    private void addButton(String label, ActionListener listener)
    {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }
    private class CommandAction implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String command = event.getActionCommand();

            // Füge den Präfix "-" an den String an wenn
            // es sich um den ersten Befehl handelt (negative Zahl)
            if (start)
            {
                if (command.equals("-"))
                {
                    display.setText(command);
                    start = false;
                }
                else
                    lastCommand = command;
            }
            else
            {
                // Berechnung ausführen
                //calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                start = true;
            }
        }
    }
    private class InsertAction implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String input = event.getActionCommand();
            // Beim Start keinen Text anzeigen
            // Das Start Flag anschließend auf false setzen
            if (start)
            {
                display.setText("");
                start = false;
            }
            // Text anzeigen
            display.setText(display.getText() + input);
        }
    }
    private JButton display;
    private JPanel panel;
    private boolean start;
    private double result;
    private String lastCommand;
}