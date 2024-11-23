import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JTextField;
import  java.awt.*;
import  java.awt.event.*;
import  java.awt.BorderLayout;
import  java.awt.FlowLayout;
import  java.awt.Color;

public class Calculator extends JFrame implements ActionListener{

			String text="";
			double result=0.0;


JButton button[]= new JButton[16];
JButton button1= new JButton("EXIT");

JPanel panel=new JPanel(new GridLayout(4,4));
  JTextField display = new JTextField(20); // Text field to display input/result

public Calculator() {

setTitle("Calculator");
setSize(400,500);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//part1 button
String label[]={"1","2","3","-","4","5","6","+","7","8","9","*","c","0","=","/"};
for(int i=0;i<button.length;i++)
{button[i]=new JButton(label[i]);
if(label[i].equals("c")){

	button[i].setBackground(new Color(255,100,77));}

else if (label[i].equals("=")){
	button[i].setBackground(new Color(77,100,255));}
else{
button[i].setBackground(Color.LIGHT_GRAY);}
panel.add(button[i]);
button[i].addActionListener(this);
add(panel);

}
//part2
add(button1, BorderLayout.SOUTH);
button1.addActionListener(this);
add(display, BorderLayout.NORTH); // Add display to the frame
display.addActionListener(this);
setVisible(true);
}
public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Clear the display if "c" is pressed
        if (command.equals("c")) {
            text = "";
            display.setText("");
        }
        // Evaluate the expression when "=" is pressed
        else if (command.equals("=")) {
            try {
                double result = evaluateExpression(text);
                display.setText(String.valueOf(result));
                text = ""; // Clear the text after evaluation
            } catch (Exception ex) {
                display.setText("Error");
                text = "";
            }
        }
        // Concatenate input for numbers and operators
        else {
            text = text+command;
            display.setText(text);
        }
        if (e.getSource() == button1) {
		    System.exit(0);
}
    }

    // Simple method to evaluate basic arithmetic expressions
    private double evaluateExpression(String expression) {
        String[] tokens = expression.split("(?<=[-+*/])|(?=[-+*/])"); // Split by operators
        double result = Double.parseDouble(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            double operand = Double.parseDouble(tokens[i + 1]);

            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                case "*":
                    result *= operand;
                    break;
                case "/":
                    if (operand != 0) {
                        result /= operand;
                    } else {
                        throw new ArithmeticException("Cannot divide by zero");
                    }
                    break;
            }
        }
        return result;
    }

public static void main(String args[])
{new Calculator();

}

}