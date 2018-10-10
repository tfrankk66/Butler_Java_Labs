package butler_java2_lab8_theaterrevenuegui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class TheaterRevenue extends JFrame{
    
    private final int WINDOW_WIDTH = 600;
    private final int WINDOW_HEIGHT = 500;
    private JPanel revenueInfoPanel;
    private JPanel buttonPanel;
    
    private JLabel adultTicketPrice;
    private JLabel childTicketPrice;
    private JLabel adultTicketSold;
    private JLabel childTicketSold;
    
    private JTextField adultTicketPriceText;
    private JTextField childTicketPriceText;
    private JTextField adultTicketSoldText;
    private JTextField childTicketSoldText;
    
    private JButton calcButton;
    
    private final double THEATER_REVENUE = 0.2;
    
    DecimalFormat df = new DecimalFormat("####.##");
    
    public TheaterRevenue(){
        setTitle("Theater Revenue Calculator");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
        buildRevenueInfoPanel();
        buildButtonPanel();
        
        add(revenueInfoPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
    }
    

    public static void main(String[] args) {
       new TheaterRevenue();
    }
    
    private void buildRevenueInfoPanel(){
        adultTicketPrice = new JLabel("Please enter the price for a adult ticket:");
        childTicketPrice = new JLabel("Please enter the price for a child ticket:");
        adultTicketSold = new JLabel("Please enter the amount of adult tickets sold:");
        childTicketSold = new JLabel("Please enter the amount of child tickets sold:");
        adultTicketPriceText = new JTextField(10);
        childTicketPriceText = new JTextField(10);
        adultTicketSoldText = new JTextField(10);
        childTicketSoldText = new JTextField(10);
        
        revenueInfoPanel = new JPanel();
        
        revenueInfoPanel.setLayout(new GridLayout(4,2));
        
        revenueInfoPanel.add(adultTicketPrice);
        revenueInfoPanel.add(adultTicketPriceText);
        revenueInfoPanel.add(childTicketPrice);
        revenueInfoPanel.add(childTicketPriceText);
        revenueInfoPanel.add(adultTicketSold);
        revenueInfoPanel.add(adultTicketSoldText);
        revenueInfoPanel.add(childTicketSold);
        revenueInfoPanel.add(childTicketSoldText);
        
        revenueInfoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 1, 10));
    }
    
    private void buildButtonPanel(){
        calcButton = new JButton("Calculate");
        calcButton.addActionListener(new CalcButtonListener());
        
        buttonPanel = new JPanel();
        
        buttonPanel.setLayout(new GridLayout(1,1));
        
        buttonPanel.add(calcButton);
    }
    
    private class CalcButtonListener implements ActionListener{
        String input1;
        String input2;
        String input3;
        String input4;
        double adultTicketPrice;
        double adultTicketSold;
        double childTicketPrice;
        double childTicketSold;
        double adultGrossRev;
        double adultNetRev;
        double childGrossRev;
        double childNetRev;
        double totalGrossRev;
        double totalNetRev;
        
        
        @Override
        public void actionPerformed(ActionEvent e){        
            input1 = adultTicketPriceText.getText();
            input2 = adultTicketSoldText.getText();
            input3 = childTicketPriceText.getText();
            input4 = childTicketSoldText.getText();
            
            adultTicketPrice = Double.parseDouble(input1);
            adultTicketSold = Double.parseDouble(input2);
            childTicketPrice = Double.parseDouble(input3);
            childTicketSold = Double.parseDouble(input4);
            
            adultGrossRev = (adultTicketPrice * adultTicketSold);
            childGrossRev = (childTicketPrice * childTicketSold);
            adultNetRev = adultGrossRev * THEATER_REVENUE;
            childNetRev = childGrossRev * THEATER_REVENUE;
            totalGrossRev = adultGrossRev + childGrossRev;
            totalNetRev = adultNetRev + childNetRev;
            
            JOptionPane.showMessageDialog(null, "Gross revenue for adult tickets sold:   $" + df.format(adultGrossRev) +
                                                "\nNet revenue for adult tickets sold:   $" + df.format(adultNetRev) + 
                                                "\nGross revenue for child tickets sold:   $" + df.format(childGrossRev) + 
                                                "\nNet revenue for child tickets sold:   $" + df.format(childNetRev) + 
                                                "\nTotal gross revenue for the evening:   $" + df.format(totalGrossRev) + 
                                                "\nTotal net revenue for the evening:   $" + df.format(totalNetRev));
        }
    }
    
    
}
