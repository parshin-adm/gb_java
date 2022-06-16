package lesson8;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ApplicationForm extends JFrame {

    private JTextField inputField;

    private Calc calculator;

    public ApplicationForm(String title) throws HeadlessException {
        super(title);
        setBounds(500, 250, 250, 370);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);


        setLayout(new BorderLayout());

        add(createTopPanel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);


        setVisible(true);
    }


    private JPanel createTopPanel() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setEditable(false);
        top.add(inputField);
        inputField.setFont(new Font("Arial", Font.PLAIN, 25));
        inputField.setMargin(new Insets(8, 0, 8, 0));
        inputField.setBackground(new Color(241, 241, 199));
        inputField.setText("");

        return top;
    }

    private JPanel createCenterPanel() {
        calculator = new Calc(inputField);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        centerPanel.add(createDigitsPanel(), BorderLayout.CENTER);
        centerPanel.add(createEastOperatorsPanel(), BorderLayout.EAST);
        centerPanel.add(createNorthOperatorsPanel(), BorderLayout.NORTH);
        centerPanel.add(createSouthOperatorsPanel(), BorderLayout.SOUTH);

        return centerPanel;
    }

    private JPanel createDigitsPanel() { //создание цифр 1-9
        JPanel digitsPanel = new JPanel();

        digitsPanel.setLayout(new GridLayout(3, 3));

        int numberInt = 7;
        for (int i = 0; i < 9; i++) {
            String number = String.valueOf(numberInt);
            if(numberInt % 3 == 0) {
                numberInt -= 5;
            }
            else {
                numberInt++;
            }
            JButton btn = new JButton(number);
            btn.setFont(new Font("TimesRoman", Font.PLAIN, 25));
            btn.setBackground(new Color(31, 60, 231));
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(calculator.isStartLine()) {
                        inputField.setText(number);
                        calculator.setIsStartLine(false);
                    }
                    else if(Double.parseDouble(inputField.getText()) != 0){
                        inputField.setText(inputField.getText() + number);
                    }
                }
            });
            digitsPanel.add(btn);
        }

        return digitsPanel;
    }

    private JPanel createEastOperatorsPanel() { //создание операторов х-+
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton multiply = new JButton("*");
        multiply.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!calculator.isStartLine()) {
                    calculator.addCalc(inputField.getText());
                    calculator.addCalc("*");
                    calculator.setIsStartLine(true);
                    inputField.setText("*");
                }
            }
        });
        panel.add(multiply);


        JButton minus = new JButton("-");
        minus.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!calculator.isStartLine()) {
                    calculator.addCalc(inputField.getText());
                    calculator.addCalc("-");
                    calculator.setIsStartLine(true);
                    inputField.setText("-");
                }

            }
        });
        panel.add(minus);

        JButton plus = new JButton("+");
        plus.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!calculator.isStartLine()) {
                    calculator.addCalc(inputField.getText());
                    calculator.addCalc("+");
                    calculator.setIsStartLine(true);
                    inputField.setText("+");
                }
            }
        });
        panel.add(plus);


        return panel;
    }

    private JPanel createNorthOperatorsPanel() { //создание операторов .= и 0
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));

        JButton removeLast = new JButton("←");
        removeLast.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        removeLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText();
                if(text.length() == 1) {
                    calculator.setIsStartLine(true);
                    inputField.setText(text.substring(0, 0));
                }
                else if(text.length() > 1) {
                    inputField.setText(text.substring(0, text.length()-1));
                }
            }
        });
        panel.add(removeLast);


        JButton plusMinus = new JButton("±");
        plusMinus.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        plusMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText();
                if(!calculator.isStartLine()) {
                    if (text.charAt(0) != '-' && text.charAt(0) != '0') {
                        inputField.setText("-" + inputField.getText());
                    } else if (text.charAt(0) != '0') {
                        inputField.setText(text.replace(text.charAt(0), ' ').trim());
                    }
                }
            }
        });
        panel.add(plusMinus);



        JButton divide = new JButton("÷");
        divide.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!calculator.isStartLine()) {
                    calculator.addCalc(inputField.getText());
                    calculator.addCalc("/");
                    calculator.setIsStartLine(true);
                    inputField.setText("÷");
                }
            }
        });
        panel.add(divide);


        return panel;
    }

    private JPanel createSouthOperatorsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4));

        JButton clear = new JButton("C"); //работает
        clear.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
                calculator.clear();
            }
        });
        panel.add(clear);

        JButton zero = new JButton("0"); //работает
        zero.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(calculator.isStartLine()) {
                    inputField.setText("0");
                    calculator.setIsStartLine(false);
                }
                else {
                    String text = inputField.getText();
                    if(!(Double.parseDouble(text) == 0)) {
                        inputField.setText(inputField.getText() + "0");
                    }

                }
            }
        });
        panel.add(zero);


        JButton point = new JButton("."); //работает
        point.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        point.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText();
                if(calculator.isStartLine()) {
                    calculator.setIsStartLine(false);
                    inputField.setText("0.");
                }
                else {
                    int indexPoint = text.indexOf(".");
                    if (indexPoint < 0) {
                        inputField.setText(inputField.getText() + ".");
                    }
                }

            }
        });
        panel.add(point);



        JButton calc = new JButton("=");
        calc.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(!calculator.isStartLine()) {
                   calculator.addCalc(inputField.getText());
                   calculator.calc();
                   calculator.setIsStartLine(true);
                   calculator.clear();
               }
            }
        });
        panel.add(calc);

        return panel;
    }

}
