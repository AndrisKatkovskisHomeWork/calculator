package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UiGenerator {
    private Calculations c;

    public UiGenerator(Calculations c) {
        this.c = c;
    }

    public void generateUI() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setBounds(100, 100, 500, 500);
        panel.setBounds(0, 0, 350, 350);

        JLabel timer = new JLabel("use time: 0");
        timer.setBounds(250, 250, 200, 200);
        panel.add(timer);

        long startTime = System.currentTimeMillis();
        Thread timerThread = new Thread(new Runnable() {

            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000);
                        System.out.println("still running");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    timer.setText("use time: " +
                            String.valueOf(
                                    (System.currentTimeMillis() - startTime) / 1000));
                }
            }

        });
        timerThread.start();

        panel.setBackground(Color.lightGray);
        panel.setLayout(null);

        generateButtons(panel);
        frame.setVisible(true);

        frame.add(panel);
    }

    String[] buttonNames = {"7", "8", "9",
            "4", "5", "6",
            "1", "2", "3",
            ".", "0"};

    String[] symbolNames = {"+", "-",
            "*", "/"};

    String resset = "C";
    String equals = "=";

    private void generateButtons(JPanel panel) {
        java.util.List<JButton> buttons = new ArrayList<>();
        int x = 0;
        int y = 0;
        int width = 50;
        int height = 50;
        int gap = 5;

        JLabel label = new JLabel("<html><font color='red'> No digit entered yet! </font></html>");
        label.setBounds(130, 250, 90, 100);
        panel.add(label);
        List<JLabel> labels = new ArrayList<>();
        labels.add(label);

        JLabel textLabelI = new JLabel("<html><font color='green'>Entered: </font></html>");
        textLabelI.setBounds(60, 250, 90, 100);
        panel.add(textLabelI);
        labels.add(textLabelI);

        JLabel resultOneTextLabel = new JLabel("<html><font color='blue'> No result yet! </font></html>");
        resultOneTextLabel.setBounds(130, 300, 90, 100);
        panel.add((resultOneTextLabel));
        labels.add(resultOneTextLabel);

        JLabel resultTwoTextLabel = new JLabel("<html><font color='green'> Result: </font></html>");
        resultTwoTextLabel.setBounds(60, 300, 90, 100);
        panel.add(resultTwoTextLabel);
        labels.add(resultTwoTextLabel);

        for (int i = 0; i < buttonNames.length; i++) {
            if (i % 3 == 0) {
                y = 0;
                x += height + gap;
            }
            JButton number = new JButton(String.valueOf(buttonNames[i]));
            number.setBounds(y, x, width, height);
            number.setBackground(Color.yellow);
            y += width + gap;
            String finalI = buttonNames[i];

            number.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    c.addDigit(finalI);

                    resultOneTextLabel.setText(String.valueOf(c.getResult()));
                    label.setText(c.getLabel());
                }
            });
            panel.add(number);
            buttons.add(number);
        }

        x = 0;
        for (int i = 0; i < symbolNames.length; i++) {
            if (i % 2 == 0) {
                y = 180;
                x += height + gap;
            }

            JButton number = new JButton(String.valueOf(symbolNames[i]));
            number.setBounds(y, x, width, height);
            y += width + gap;
            String finalI = symbolNames[i];

            number.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    c.addDigit(finalI);

                    resultOneTextLabel.setText(String.valueOf(c.getResult()));
                    label.setText(c.getLabel());
                }
            });
            panel.add(number);
            buttons.add(number);
        }

        JButton number = new JButton(String.valueOf(resset));
        number.setBounds(x, 220, width, height);
        panel.add(number);
        buttons.add(number);

        number.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.resset();

                resultOneTextLabel.setText(String.valueOf(c.getResult()));
                label.setText(c.getLabel());
            }
        });

        number = new JButton(String.valueOf(equals));
        number.setBounds(x + 70, 220, width + 50, height);
        panel.add(number);
        buttons.add(number);

        number.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.equalsOperation();

                resultOneTextLabel.setText(String.valueOf(c.getResult()));
                label.setText(c.getLabel());
            }
        });
    }
}
