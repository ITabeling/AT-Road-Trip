/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.atRoadTrip1.view;

/**
 *
 * @author Ian Tabeling
 */
public class DayView extends View{
    

    public DayView(){
        
         // implements View superclass to display messsage
                 super("\nDisplay current day Y or N?");
}
    // implements View superclass to call doAction function
     @Override
     public boolean doAction(String value){        
            
        value = value.toUpperCase(); // convert choice to upper case
        
        boolean rtnValue = true;
         switch (value){
                
            case "Y": // "sorry my error"
                this.displayDayView();
                break;
                
            case "N": // quit and return to game menu
                this.displayQuitDayView();
                break;
            
            default:
                ErrorView.display("\n*** Invalid Selection *** Try Again");
               rtnValue = false;
                break;
        }
            return rtnValue;
     }

    private void displayDayView() {
       this.console.println("\n***The Current Day Is...");
    }
        private void displayQuitDayView() {
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();
    }
    }
