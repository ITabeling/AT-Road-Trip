/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.atRoadTrip1.control;

import atroadtrip1.AtRoadTrip1;
import byui.cit260.atRoadTrip1.exceptions.GameControlException;
import byui.cit260.atRoadTrip1.model.Car;
import byui.cit260.atRoadTrip1.model.Game;
import byui.cit260.atRoadTrip1.model.InventoryItem;
import byui.cit260.atRoadTrip1.model.Item;
import byui.cit260.atRoadTrip1.model.Location;
import byui.cit260.atRoadTrip1.model.Map;
import byui.cit260.atRoadTrip1.model.Player;
import byui.cit260.atRoadTrip1.model.Scene;
import byui.cit260.atRoadTrip1.model.SceneType;
import byui.cit260.atRoadTrip1.view.ErrorView;
import byui.cit260.atRoadTrip1.view.TripInfoView;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import static java.lang.System.console;
import java.util.ArrayList;


/**
 *
 * @author whitbillman
 */


public class GameControl implements Serializable{
    
    public static void createNewGame(Player player){
        
        Game game = new Game();// create new game
        AtRoadTrip1.setCurrentGame(game);
         
        game.setPlayer(player);  // save player in game 
         
        Car car = new Car();//create new car
        game.setCar(car);// save car in game
        
        // create inventory list and save in game
        InventoryItem[] inventoryList = GameControl.createInventoryList();
        game.setInventory(inventoryList);
         
         // *******commented out 7/8/17********
         /*Day day = new Day();// create new day
         game.setDay(day);// save day in game
         */
        Map map = MapControl.createMap();//create and initialize new map
        game.setMap(map); //save map in game
    
        MapControl.moveActorsToStartingLocation(map);
    }

    
    public static Player createPlayer(String name) throws GameControlException {
        
        if (name.length() < 2){
           throw new GameControlException("Player name must be greater than one character") ;
        }
        if (name == null) {
            throw new GameControlException("Player name cannot be blank");
        }
        
        Player player = new Player();
        player.setName(name);
        
        AtRoadTrip1.setPlayer(player); // save the player
        
        return player;
    }

    public static InventoryItem[] createInventoryList() {
        
        // created array<list> of inventory items
        InventoryItem[] inventory = new InventoryItem[4];
        
        InventoryItem gas = new InventoryItem();
        gas.setInvType("Gas");
        gas.setQtyInStock(10);
        gas.setReqAmt(10);
        inventory[0] = gas;
        
        InventoryItem cash = new InventoryItem();
        cash.setInvType("Cash");
        cash.setQtyInStock(500);
        cash.setReqAmt(500);
        inventory[1] = cash;
        
        InventoryItem time = new InventoryItem();
        time.setInvType("Time");
        time.setQtyInStock(30);
        time.setReqAmt(30);
        inventory[2] = time;
        
        InventoryItem distance = new InventoryItem();
        distance.setInvType("Distance");
        distance.setQtyInStock(2000);
        distance.setReqAmt(2000);
        inventory[3] = distance;        
        
        return inventory;         
    }
    
    public void printTripInfoReport(ArrayList<Item> inventory, String outputLocation){
   
        // create BufferReader object for input file
        try (PrintWriter out = new PrintWriter(outputLocation)) {
            
            // print title and column headings
            out.println("\n\n          Trip Info Report          ");
            out.printf("%n%-20s%10s", "Item", "Quantity");
            out.printf("%n%-20s%10s", "----", "--------");
            
            // print the description and quantity of each item
            for(Item item : inventory){
                out.printf("%n%-20s%10s",item.getInvType()
                                        ,item.getQuantity());
            }                     
       } catch (Exception e){
           ErrorView.display("I/O Error: ");
       }
    }
    
// need to use assignScenesToLocation function
   private static void assignScenesToLocations(Map map, SceneType[] scenes) {
        Location[][] locations = map.getLocations();
        
        //start point
        locations[0][0].setScene(scenes[SceneType.start.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.road.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.road.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.road.ordinal()]);
        locations[0][4].setScene(scenes[SceneType.road.ordinal()]);
        locations[1][0].setScene(scenes[SceneType.road.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.road.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.road.ordinal()]);
        locations[1][3].setScene(scenes[SceneType.road.ordinal()]);
        locations[1][4].setScene(scenes[SceneType.road.ordinal()]);
        locations[2][0].setScene(scenes[SceneType.road.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.road.ordinal()]);
        locations[2][2].setScene(scenes[SceneType.road.ordinal()]);
        locations[2][3].setScene(scenes[SceneType.road.ordinal()]);
        locations[2][4].setScene(scenes[SceneType.road.ordinal()]);
        locations[3][0].setScene(scenes[SceneType.road.ordinal()]);
        locations[3][1].setScene(scenes[SceneType.road.ordinal()]);
        locations[3][2].setScene(scenes[SceneType.road.ordinal()]);
        locations[3][3].setScene(scenes[SceneType.road.ordinal()]);
        locations[4][4].setScene(scenes[SceneType.road.ordinal()]);
        locations[4][0].setScene(scenes[SceneType.road.ordinal()]);
        locations[4][1].setScene(scenes[SceneType.road.ordinal()]);
        locations[4][2].setScene(scenes[SceneType.road.ordinal()]);
        locations[4][3].setScene(scenes[SceneType.road.ordinal()]);
        locations[4][4].setScene(scenes[SceneType.road.ordinal()]);
        locations[5][0].setScene(scenes[SceneType.road.ordinal()]);
        locations[5][1].setScene(scenes[SceneType.road.ordinal()]);
        locations[5][2].setScene(scenes[SceneType.road.ordinal()]);
        locations[5][3].setScene(scenes[SceneType.road.ordinal()]);
        locations[5][4].setScene(scenes[SceneType.finish.ordinal()]);
    }

     // Need to implement this stub funtion
  
    static void assignScenesToLocations(Map map, Scene[] scenes) {
       System.out.println("\nAssignScenesToLocations() called.");
    }

    public static void saveGame(Game game, String filepath)
        throws GameControlException {
        
      try(FileOutputStream fops = new FileOutputStream(filepath)) {
          ObjectOutputStream output = new ObjectOutputStream(fops);
          
          output.writeObject(game); // write the game object out to file
      }
      catch(Exception e){
          throw new GameControlException(e.getMessage());
      }
    }

    public static void getExisitingGame(String filepath) 
            throws GameControlException {
            Game game = null;
            
            try( FileInputStream fips = new FileInputStream(filepath)) {
                ObjectInputStream input = new ObjectInputStream(fips);
            game = (Game) input.readObject(); //read the game object from file
          } catch(Exception e) {
              throw new GameControlException(e.getMessage());
          }
            
          //close the output file
          AtRoadTrip1.setCurrentGame(game);
    }
    
     public static void gameReport(TripInfoView gameReport, String filepath)
        throws GameControlException {
        
      try(FileOutputStream fops = new FileOutputStream(filepath)) {
          ObjectOutputStream output = new ObjectOutputStream(fops);
          
           output.writeObject(gameReport); // write the game object out to file
      }
      catch(Exception e){
          throw new GameControlException(e.getMessage());
      }
    }
}