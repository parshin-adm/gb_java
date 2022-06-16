package lesson8;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Calc {

        private JTextField inputField;
        private ArrayList<String> elements = new ArrayList<>();
        private boolean isStart;

        public Calc(JTextField inputField) {
            this.inputField = inputField;
            isStart = true;
        }

        public void addCalc(String s){
            elements.add(s);
            System.out.println(s);
        }

        public void clear(){
            isStart = true;
            elements.clear();
        }

        public void setIsStartLine(Boolean isStart){
            this.isStart = isStart;
        }

        public boolean isStartLine(){
            return isStart;
        }
        public boolean isOperator() {
            return elements.size() %2 != 0;
        }

        public void calc() {
            multiply(elements);
            divide(elements);
            subtract(elements);
            fold(elements);
            for(String s : elements) {
                System.out.println(s);
            }

            inputField.setText(editOutput(elements.get(0)));

        }
        private String editOutput(String result) {
            Double output = Double.parseDouble(result);
            DecimalFormat format = new DecimalFormat("0.###");
            return format.format(output);
        }


        public void multiply(ArrayList<String> elements) {

            int indexMultiply = elements.indexOf("*");
            if(indexMultiply > 0) { // >0
                double a = Double.parseDouble(elements.get(indexMultiply-1));
                double b = Double.parseDouble(elements.get(indexMultiply+1));
                double res = a*b;
                elements.add(indexMultiply-1, String.valueOf(res));
                elements.removeAll(elements.subList(indexMultiply, indexMultiply+3));
                multiply(elements);

            }

        }
        public void divide(ArrayList<String> elements) {

            int indexMultiply = elements.indexOf("/");
            if(indexMultiply > 0) { // >0
                double a = Double.parseDouble(elements.get(indexMultiply-1));
                double b = Double.parseDouble(elements.get(indexMultiply+1));
                double res = a/b;
                elements.add(indexMultiply-1, String.valueOf(res));
                elements.removeAll(elements.subList(indexMultiply, indexMultiply+3));
                divide(elements);

            }

        }

        public void subtract(ArrayList<String> elements) {

            int indexMultiply = elements.indexOf("-");
            if(indexMultiply > 0) { // >0
                double a = Double.parseDouble(elements.get(indexMultiply-1));
                double b = Double.parseDouble(elements.get(indexMultiply+1));
                double res = a-b;
                elements.add(indexMultiply-1, String.valueOf(res));
                elements.removeAll(elements.subList(indexMultiply, indexMultiply+3));
                subtract(elements);

            }

        }
        public void fold(ArrayList<String> elements) {

            int indexMultiply = elements.indexOf("+");
            if(indexMultiply > 0) { // >0
                double a = Double.parseDouble(elements.get(indexMultiply-1));
                double b = Double.parseDouble(elements.get(indexMultiply+1));
                double res = a+b;
                elements.add(indexMultiply-1, String.valueOf(res));
                elements.removeAll(elements.subList(indexMultiply, indexMultiply+3));
                fold(elements);

            }

        }
    }
