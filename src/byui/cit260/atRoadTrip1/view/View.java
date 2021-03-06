/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.atRoadTrip1.view;

import atroadtrip1.AtRoadTrip1;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author whitbillman
 */
public abstract class View implements ViewInterface {
    
   // public void display();
   // public String getInput();
    
    protected String displayMessage;
    
    protected final BufferedReader keyboard = AtRoadTrip1.getInFile();
    protected final PrintWriter console = AtRoadTrip1.getOutFile();
    
    
    public View(){
        
    }
    
    public View(String message) {
        this.displayMessage = message;
    }
    
    @Override
    public void display() {
        
        boolean done = false;
        do{
            //prompt for and get players name
            String value = this.getInput();
            if (value.toUpperCase().equals("Q")) // user wants to quit
                return; //exit the view
            
            //do the requested action and display the next view
            done = this.doAction(value);
            
        } while (!done); //exit the view when done == true
    }
    
    @Override
    public String getInput() {
        
        //Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        boolean valid = false; // initialize to not valid
        String value = null; // value to be returned
        try {
        //loop while an invalid value is enter
        while (!valid) { 
            
            this.console.println("\n" + this.displayMessage);
            
            // get the next line typed on the keyboard
            value = this.keyboard.readLine(); 
            value = value.trim(); // trim off the leading and trailing blanks
            
            if (value.length() < 1){//if the value is blank
                ErrorView.display("\n*** You must enter a value *** ");
                continue;
                
            }
            
             break; // end the loop
          }
        } catch (Exception e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
            return value; // return the value entered
    }
    
    
}
