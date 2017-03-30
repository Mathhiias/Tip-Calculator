/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w2017.week10.tipcalculator;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mathi
 */
public class TipCalculatorViewController implements Initializable {
    
    @FXML private TextField mealAmountField;
    @FXML private TextField tipPerField;
    @FXML private TextField tipAmountField;
    @FXML private TextField totalCostField;
    @FXML private Label errorMessage;
    @FXML private Button calculateTipButton;
    
    private double mealAmount, tipAmount, totalCost;
    private int tipPercentage;
            
    
    /**
     * This method will receive the meal amount value and get the tip amount based on the tip% provided by the user 
     */
    public void calculateTipAmount(){
        tipAmount = ((mealAmount/100)*tipPercentage); 
    }
    
    
    /**
     * This method will print to the screen the tip amount and the total cost of the meal
     */
    public void calculateTipButtonPushed(){
        
        if(mealAmountField.getText().toUpperCase().matches("[A-Z]\\d") || mealAmountField.getText().contains("-") || mealAmountField.getText().isEmpty()){
            errorMessage.setText("The meal amount is invalid");
        }
        else if(tipPerField.getText().toUpperCase().matches("[A-Z]\\d") || tipPerField.getText().contains("-") || tipPerField.getText().isEmpty()){
            errorMessage.setText("The Tip % is invalid");
        }
        else{
            mealAmount = Double.parseDouble(mealAmountField.getText());
            tipPercentage = Integer.parseInt(tipPerField.getText());
        }
        
        DecimalFormat cu;
        
        calculateTipAmount();
        calculateTotalCost();
        totalCostField.setText("");
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        tipAmountField.setEditable(false);
        totalCostField.setEditable(false);
        errorMessage.setVisible(false);
    }    

    private double calculateTotalCost() {
        totalCost = tipAmount + mealAmount;
        
        return totalCost;
    }
    
}
