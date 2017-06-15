/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.atRoadTrip1.view;

import java.util.Scanner;

/**
 *
 * @author Ian Tabeling
 */
public class GameMenuView {
    
    private String menu;
    private String promptMessage;
    
    public GameMenuView(){
        this.menu = "\n"
                  + "\n--------------------------------------"
                  + "\n            Game Menu                 "
                  + "\n--------------------------------------"
                  + "\nV - View Trip Info"
                  + "\nD - Drive"
                  + "\nC - Count Cash"
                  + "\nG - Stop for gas"
                  + "\nF - Stop for food"
                  + "\nP - Stop for food & gas"
                  + "\nM - Stop for motel"
                  + "\nS - Save Game"
                  + "\nH - Help Menu"
                  + "\nQ - Quit"
                  + "\n--------------------------------------";
    
    }

    public void displayGameMenuView() {
        
        boolean done = false; // set flag to not done
       do {
           // prompt player for Game Menu option
           String gameMenuOption = this.getGameMenuOption();
           /*if (gameMenuOption.toUpperCase().equals("Q")) 
           // user wants to return to previous view
           
               return; // return to previous view*/
           
           // do the requested action and disply the next view
           done = this.doAction(gameMenuOption);
       
       } while (!done);  
    }
    private String getGameMenuOption() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { //loop while an invalid value is enter
            System.out.println("\n" + this.menu);
            
            value = keyboard.nextLine(); // get the next line typed on the keyboard
            value = value.trim(); // trim off the leading and trailing blanks  
              if (value.length() < 1){//if the value is blank
                System.out.println("\nInvalid value: value cannot be blank");
                continue;
            }
             break; // end the loop
          }
            return value; // return the value entered
}
        public boolean doAction(String choice){
        
        choice = choice.toUpperCase(); // convert choice to upper case
        
        boolean rtnValue = true;
         switch (choice){
            case "V": // Trip Info
                this.displayTripInfo();
                break;
            case "D": // Drive
                this.displayDrive();
                break;
            case "C": // count cash
                this.displayCountCash();
                break;
            case "G": // stop for gas
                this.displayStopGas();
                break;    
            case "F": // stop for food
                this.displayStopFood();
                break;
            case "P": // stop for food and gas
                this.displayStopFoodGas();
                break;
            case "M": // stop for motel
                this.displayStopMotel();
                break;
            case "S": // save game
                this.displaySaveGame();
                break;
            case "H": // help menu
                 this.displayHelpMenu();
                 break;
            case "Q": // quit help menu
                this.displayQuitHelp();
                break;
            default:
                System.out.println("\n*** Invalid Selection *** Try Again");
               rtnValue = false;
                break;
        }
            return rtnValue;
}
      void displayMenu(){
          System.out.println(this.menu);
    }
    private void displayTripInfo() {
        System.out.println("*** displayTripInfo function called ***");
    }

    private void displayDrive() {
        DriveView driveView = new DriveView();
        driveView.displayDriveView();
    }

    private void displayCountCash() {
        System.out.println("*** displayCountCash function called ***");
    }
 
    private void displayStopGas() {
        StopGasView stopGasView = new StopGasView();
        stopGasView.displayStopGasView();
    }    

    private void displayStopFood() {
        StopFoodView stopFoodView = new StopFoodView();
        stopFoodView.displayStopFoodView();
    }

    private void displayStopFoodGas() {
        System.out.println("*** displayStopFoodGas function called ***"); 
    }

    private void displayStopMotel() {
       StopMotelView stopMotelView = new StopMotelView();
        stopMotelView.displayStopMotelView(); 
    }

    private void displaySaveGame() {
        System.out.println("*** displaySaveGame function called ***");
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.displayHelpMenuView();
    }

    private void displayQuitHelp() {
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();
    }

}

