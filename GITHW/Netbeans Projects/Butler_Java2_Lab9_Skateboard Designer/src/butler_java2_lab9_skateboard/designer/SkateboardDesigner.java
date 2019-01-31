package butler_java2_lab9_skateboard.designer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class SkateboardDesigner extends JFrame{

    final private int WINDOW_WIDTH = 800;
    final private int WINDOW_HEIGHT = 550;
    private double subTotal = 0.0;
    private double saleTax = 0.0;
    private double totall = 0.0;
    
    private JPanel productsPanel;
    private JPanel pricePanel;
    
    private JComboBox deckBox;
    private JComboBox truckBox;
    private JComboBox wheelBox;
    private JList miscList;
    
    private JLabel subtotal;
    private JLabel salesTax;
    private JLabel total;
    
    private JTextField subtotalText;
    private JTextField salesTaxText;
    private JTextField totalText;
    
    private String[] deck = {"The Master Thrasher: $60:", "The Dictator: $45", "The Street King: $50"};
    private String[] truck = {"7.75 Inch Axel: #35", "8 Inch Axel: $40", "8.5 Inch Axel: $45"};
    private String[] wheels = {"51 mm: $20", "55 mm: $22", "58 mm: $24", "61 mm: $28"};
    private String[] misc = {"Grip Tape: $10", "Bearings: $30", "Riser Pads: $2", "Nuts & Bolts Kit: $3"};
      
    private double[] deckCost = {60.0, 45.0, 50.0};
    private double[] truckCost = {35.0, 40.0, 45.0};
    private double[] wheelCost = {20.0, 22.0, 24.0, 28.0};
    private double[] miscCost = {10.0, 30.0, 2.0, 3.0};
    
    DecimalFormat df = new DecimalFormat("####.##");
    
    public SkateboardDesigner(){
        setTitle("Skateboard Designer");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
        buildProductsPanel();
        buildPricePanel();
        
        add(productsPanel, BorderLayout.CENTER);
        add(pricePanel, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
    }
    
    public void buildProductsPanel(){
        productsPanel = new JPanel();
        
        deckBox = new JComboBox(deck);
        truckBox = new JComboBox(truck);
        wheelBox = new JComboBox(wheels);
        miscList = new JList(misc);
        
        miscList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        deckBox.addActionListener(new ComboBoxListener());
        truckBox.addActionListener(new ComboBoxListener());
        wheelBox.addActionListener(new ComboBoxListener());
        miscList.addListSelectionListener(new ListListener());
        
        productsPanel.setLayout(new GridLayout(1,4));
        
        productsPanel.add(deckBox);
        productsPanel.add(truckBox);
        productsPanel.add(wheelBox);
        productsPanel.add(miscList);
    }
    
    public void buildPricePanel(){
        pricePanel = new JPanel();
        
        subtotal = new JLabel("Subtotal: ");
        salesTax = new JLabel("Sales Tax: ");
        total = new JLabel("Total Cost: ");
        subtotalText = new JTextField(10);
        salesTaxText = new JTextField(10);
        totalText = new JTextField(10);
        subtotalText.setEditable(false);
        salesTaxText.setEditable(false);
        totalText.setEditable(false);

        
        pricePanel.setLayout(new GridLayout(3,3));
        pricePanel.add(subtotal);
        pricePanel.add(subtotalText);
        pricePanel.add(salesTax);
        pricePanel.add(salesTaxText);
        pricePanel.add(total);
        pricePanel.add(totalText);
        
    }
    
    private class ComboBoxListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == deckBox){
                String selection = (String) deckBox.getSelectedItem();
                for(int i = 0; i < deck.length; i++){
                    if(selection == deck[i]){
                        subTotal += deckCost[i];
                        subtotalText.setText("$ " + df.format(subTotal));
                    }
                }
            }
            else if(e.getSource() == truckBox){
                String selection = (String) truckBox.getSelectedItem();
                for(int i = 0; i < truck.length; i++){
                    if(selection == truck[i]){
                        subTotal += truckCost[i];
                        subtotalText.setText("$ " + df.format(subTotal));
                    }
                }
            }
            else if(e.getSource() == wheelBox){
                String selection = (String) wheelBox.getSelectedItem();
                for(int i = 0; i < wheels.length; i++){
                    if(selection == wheels[i]){
                        subTotal += wheelCost[i];
                        subtotalText.setText("$ " + df.format(subTotal));
                    }
                }
            }
            
            saleTax = (subTotal * 0.06);
            salesTaxText.setText("$ " + df.format(saleTax));
            totall = subTotal + saleTax;
            totalText.setText("$ " + df.format(totall));
            
    }
    }
    
    private class ListListener implements ListSelectionListener
    {
        @Override
        public void valueChanged(ListSelectionEvent e){
            int[] selection = miscList.getSelectedIndices();
            
            for(int i = 0; i < selection.length; i++){
                
                    subTotal += miscCost[selection[i]];
                    subtotalText.setText("$ " + df.format(subTotal));
                
            }
            
            saleTax = (subTotal * 0.06);
            salesTaxText.setText("$ " + df.format(saleTax));
            totall = subTotal + saleTax;
            totalText.setText("$ " + df.format(totall));
        }
        
        
    }
    
    public static void main(String[] args) {
        new SkateboardDesigner();
    }
    
}
