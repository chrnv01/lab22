package Task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gui extends JFrame {
    Calculator calculator;
    public Gui(Calculator calculator) {
        this.calculator = calculator;
        //The frame
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Panel for Text-output
        JPanel textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(400,70));
        JTextField textfield = new JTextField("");
        textfield.setPreferredSize(new Dimension(380,70));
        textfield.setHorizontalAlignment(JTextField.RIGHT);
        textPanel.add(textfield);
        add(textPanel, BorderLayout.NORTH);

        //Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new java.awt.GridLayout(4, 5));
        buttonPanel.setPreferredSize(new Dimension(380, 280));

        //Buttons
        String[] buttonText = {
                "7", "8", "9", "+", "<-", "4", "5", "6", "-", "(", "1", "2", "3",
                "*", ")", "0", ",", "C", "/", "="
        };
        JButton button[] = new JButton[20];
        for(int i = 0; i < 20; i++) {
            button[i] = new JButton(buttonText[i]);
            button[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    for(int i = 0; i < 20; i++) {

                        if(event.getSource() == button[i]) {

                            //Delete last character button
                            if(i == 4) {
                                String text = textfield.getText().toString();
                                text = text.substring(0, text.length()-1);
                                textfield.setText(text);
                            }

                            //Delete all button
                            else if(i == 17) {
                                textfield.setText("");
                            }

                            //"="-button
                            else if(i == 19) {
                                String text = textfield.getText().toString();
                                String output = "";
                                try {
                                    output = calculator.calculate(text);
                                }
                                catch (Exception ex) {

                                }
                                textfield.setText(output);
                            }

                            //other buttons
                            else {
                                String text = button[i].getText().toString();
                                String fieldText = textfield.getText().toString();
                                textfield.setText(fieldText + text);
                            }

                        }
                    }
                }
            });
            buttonPanel.add(button[i]);
        }

        add(buttonPanel, BorderLayout.SOUTH);
    }
}
