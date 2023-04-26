package br.com.poo.solid.interfaces;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora extends JFrame implements ActionListener {
    private JTextField display;
    private JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private JButton buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonEquals, buttonClear;

    private double firstNum, secondNum, result;
    private String operator;

    public Calculadora() {
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(682, 442);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        display = new JTextField();
        display.setEditable(false);
        panel.add(display);

        button7 = new JButton("7");
        button7.addActionListener(this);
        panel.add(button7);

        button8 = new JButton("8");
        button8.addActionListener(this);
        panel.add(button8);

        button9 = new JButton("9");
        button9.addActionListener(this);
        panel.add(button9);

        buttonDivide = new JButton("/");
        buttonDivide.addActionListener(this);
        panel.add(buttonDivide);

        button4 = new JButton("4");
        button4.addActionListener(this);
        panel.add(button4);

        button5 = new JButton("5");
        button5.addActionListener(this);
        panel.add(button5);

        button6 = new JButton("6");
        button6.addActionListener(this);
        panel.add(button6);

        buttonMultiply = new JButton("*");
        buttonMultiply.addActionListener(this);
        panel.add(buttonMultiply);

        button1 = new JButton("1");
        button1.addActionListener(this);
        panel.add(button1);

        button2 = new JButton("2");
        button2.addActionListener(this);
        panel.add(button2);

        button3 = new JButton("3");
        button3.addActionListener(this);
        panel.add(button3);

        buttonSubtract = new JButton("-");
        buttonSubtract.addActionListener(this);
        panel.add(buttonSubtract);

        button0 = new JButton("0");
        button0.addActionListener(this);
        panel.add(button0);

        buttonClear = new JButton("C");
        buttonClear.addActionListener(this);
        panel.add(buttonClear);

        buttonEquals = new JButton("=");
        buttonEquals.addActionListener(this);
        panel.add(buttonEquals);

        buttonAdd = new JButton("+");
        buttonAdd.addActionListener(this);
        panel.add(buttonAdd);

        getContentPane().add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button0) {
            display.setText(display.getText() + "0");
        } else if (e.getSource() == button1) {
            display.setText(display.getText() + "1");
        } else if (e.getSource() == button2) {
            display.setText(display.getText() + "2");
        } else if (e.getSource() == button3) {
            display.setText(display.getText() + "3");
        } else if (e.getSource() == button4) {
            display.setText(display.getText() + "4");
        } else if (e.getSource() == button5) {
            display.setText(display.getText() + "5");
        } else if (e.getSource() == button6) {
            display.setText(display.getText() + "6");
        } else if (e.getSource() == button7) {
            display.setText(display.getText() + "7");
        } else if (e.getSource() == button8) {
            display.setText(display.getText() + "8");
        } else if (e.getSource() == button9) {
            display.setText(display.getText() + "9");
        }
    }
    
}

