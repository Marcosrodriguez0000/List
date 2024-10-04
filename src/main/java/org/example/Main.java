package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JPanel panel1 = new JPanel();
    private JList list1 = new JList(new DefaultListModel());
    private JButton button1 = new JButton("Comprobar");
    private JTextArea textArea1 = new JTextArea();

    public Main() {
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        DefaultListModel listModel = (DefaultListModel) list1.getModel();
        for (int i = 1; i <= 5; i++) {
            listModel.addElement(i);
        }
        panel1.add(new JScrollPane(list1));
        panel1.add(button1);
        panel1.add(new JScrollPane(textArea1));

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] numbers = list1.getSelectedIndices();
                for (int i = 0; i < numbers.length; i++) {
                    int number = Integer.parseInt(list1.getModel().getElementAt(numbers[i]).toString());
                    if (isPrime(number)) {
                        textArea1.append(number + " Este numero es primo\n");
                    } else {
                        textArea1.append(number + " Este numero no es primo\n");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main");
        frame.setContentPane(new Main().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

