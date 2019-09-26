///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package javaapplication3;
//
//import java.awt.*;
//import javax.swing.*;
//import java.awt.event.*;
//import java.text.NumberFormat;
//
///**
// *
// * @author Dustin
// */
//
///*This class takes a loan amount, length of the loan in years and the yearly
//interest rate as inputs and calculates the total amount of the loan with interest
//*/
//public class monthlyPayment extends JFrame {
//
//    /*variables for the labels: LA is the label for the total amount while
//    while TLA is the total loan amount that is computed
//    */
//    
//    JLabel Title, Loan, LA, TLA, Years, InterestRate;
//    
//    //variables for the input fields loan amount(L), years(Y), interest rate(IR)
//    JTextField L, Y, IR;
//    
//    //variables for the compute and clear buttons on the UI
//    JButton compute, clear;
//
//    public monthlyPayment(String title) {
//        //this creates the window, sets size and location of window
//        super(title);
//        setSize(350,400);
//        setLocation(200, 100);
//        JOptionPane warning;
//
//        setLayout(null);
//        
//        Title = new JLabel("Loan Total Calculator"); //the title at the top
//        
//        /*these initialize the input fields for the loan amount(L), total years(Y) and
//        intrest rate(IR)
//        */
//        L = new JTextField();
//        Y = new JTextField();
//        IR = new JTextField();
//        
//        //this initialises the output of the total loan amount that will be computed
//        TLA = new JLabel("$0.00");
//        
//        //these are titles for the input
//        LA = new JLabel("Total Amount:");
//        Loan = new JLabel("Loan Amount:");
//        Years = new JLabel("Years:");
//        InterestRate = new JLabel("Interest Rate:");
//        
//        //these are the buttons with functions
//        compute = new JButton("Compute Total Amount");
//        clear = new JButton("Clear Entries");
//
//        //Gives the location for the titles and the input fields
//        Title.setBounds(40, 0, 250, 30);
//        Title.setFont(new Font("Sherif", Font.BOLD, 24));
//        Loan.setBounds(20, 50, 180, 30);
//        Loan.setFont(new Font("Sherif", Font.BOLD, 24));
//        L.setBounds(190, 50, 100, 30);
//        Years.setBounds(20, 100, 80, 30);
//        Years.setFont(new Font("Sherif", Font.BOLD, 24));
//        Y.setBounds(100, 100, 100, 30);
//        InterestRate.setBounds(20, 150, 160, 30);
//        InterestRate.setFont(new Font("Sherif", Font.BOLD, 24));
//        IR.setBounds(180, 150, 100, 30);
//        LA.setBounds(20, 200, 165, 30);
//        LA.setFont(new Font("Sherif", Font.BOLD, 24));
//        TLA.setBounds(190, 200, 200, 30);
//        TLA.setFont(new Font("Sherif", Font.BOLD, 20));
//        compute.setBounds(20, 300, 165, 25);
//        clear.setBounds(200, 300, 110, 25);
//
//        //uses myCompute class for the function of the buttons
//        compute.addActionListener(new myCompute());
//        clear.addActionListener(new myCompute());
//
//        //adds the created titles and text boxes to the UI
//        add(Title);
//        add(Loan);;
//        add(L);
//        add(Years);
//        add(Y);
//        add(InterestRate);
//        add(IR);
//        add(LA);
//        add(TLA);
//        add(compute);
//        add(clear);
//    }
//
//    /*this class takes the input and computes the total loan amount when the
//    "compute" button is clicked and clears the data when the "clear" button is clicked
//    */
//    public class myCompute implements ActionListener {
//        
//        /*double variables for the loan amount(loan), interest rate(ir),
//        monthly intrest rate(mir), discount factor(df), monthly payment(monthlyPayment) and the total amount(total),
//        number of years(years), and number of payments(numpayments)
//        */
//        double loan, ir, mir, df, monthlyPayment, total, years, numpayments;
//        
//        NumberFormat nf = NumberFormat.getCurrencyInstance();
//        
//        String money;
//
//        //this is the method used for the "compute" and "clear buttons 
//        public void actionPerformed(ActionEvent e) {
//            try {
//                if (e.getSource() == compute) {
//                    
//                    //creating double values from the input string values
//                    loan = Double.parseDouble(L.getText());
//                    years = Double.parseDouble(Y.getText());
//                    ir = Double.parseDouble(IR.getText())/100;
//                    
//                    //calculation of the total amount after interest
//                    numpayments = years * 12;
//                    mir = ir / 12;
//                    df = (Math.pow(1 + mir, numpayments) - 1) / (mir * Math.pow(1 + mir, numpayments));
//                    monthlyPayment = loan / df;
//                    total = monthlyPayment * numpayments;
//                    
//                    //formatting the total and creating an output
//                    money = nf.format(total);
//                    TLA.setText(money);
//                    
//                } else if (e.getSource() == clear) {
//                    //clearing the input and output
//                    L.setText("");
//                    Y.setText("");
//                    IR.setText("");
//                    TLA.setText("$0.00");
//                }
//            } catch (NumberFormatException a) {
//                JOptionPane.showMessageDialog(rootPane, "Input Error");
//            }
//        }
//    }
//}
