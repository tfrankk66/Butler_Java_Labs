package butler_java2_lab8_travelexpensesgui;

import javax.swing.*;
import java.awt.*;

public class TravelExpense extends JFrame{
    
    private JPanel travelPanel;
    private JPanel buttonPanel;
    
    private JLabel daysOnTrip;
    private JLabel airfare;
    private JLabel carRental;
    private JLabel milesDriven;
    private JLabel parkingFees;
    private JLabel taxiCharges;
    private JLabel registrationFees;
    private JLabel lodgingCharges;
    
    private JTextField daysOnTripText;
    private JTextField airfareText;
    private JTextField carRentalText;
    private JTextField milesDrivenText;
    private JTextField parkingFeesText;
    private JTextField taxiChargesText;
    private JTextField registrationFeesText;
    private JTextField lodgingChargesText;
    
    private JButton reset;
    private JButton calc;
    
    private double mealReimburse = 37;
    private double parkingReimburse = 10;
    private double taxiReimburse = 20;
    private double lodgingReimburse = 95;
    private double privateReimburse = 0.27;
    
    final private int WINDOW_WIDTH = 800;
    final private int WINDOW_HEIGHT = 550;
    
    public TravelExpense(){
        setTitle("Travel Expense Calculator");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
       
        buildTravelPanel();
        
        add(travelPanel, BorderLayout.CENTER);
        
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
       new TravelExpense();
        
    }
    
    public void buildTravelPanel(){
        //Assign Label Components
        daysOnTrip = new JLabel("Please enter the amount of days you were on a trip.");
        airfare = new JLabel("Please enter the amount of airfare fees you paid on the trip.");
        carRental = new JLabel("Please enter the amount of car rental fees you paid on the trip.");
        milesDriven = new JLabel("Please enter the amount of miles you drove while you were on a trip.");
        parkingFees = new JLabel("Please enter the amount of parking fees you paid on the trip.");
        taxiCharges = new JLabel("Please enter the amount of taxi fees you paid on the trip.");
        registrationFees = new JLabel("Please enter the amount of registration fees you paid on the trip.");
        lodgingCharges = new JLabel("Please enter the amount of lodging charges you paid on the trip.");
        
        //Assign Text Components
        daysOnTripText = new JTextField(3);
        airfareText = new JTextField(10);
        carRentalText = new JTextField(10);
        milesDrivenText = new JTextField(10);
        parkingFeesText = new JTextField(10);
        taxiChargesText = new JTextField(10);
        registrationFeesText = new JTextField(10);
        lodgingChargesText = new JTextField(10);
        
        travelPanel = new JPanel();
        
        travelPanel.setLayout(new GridLayout(8,2));
        
        travelPanel.add(daysOnTrip);
        travelPanel.add(daysOnTripText);
        travelPanel.add(airfare);
        travelPanel.add(airfareText);
        travelPanel.add(carRental);
        travelPanel.add(carRentalText);
        travelPanel.add(milesDriven);
        travelPanel.add(milesDrivenText);
        travelPanel.add(parkingFees);
        travelPanel.add(parkingFeesText);
        travelPanel.add(taxiCharges);
        travelPanel.add(taxiChargesText);
        travelPanel.add(registrationFees);
        travelPanel.add(registrationFeesText);
        travelPanel.add(lodgingCharges);
        travelPanel.add(lodgingChargesText);
    }
    
}
