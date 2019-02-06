
package battleship;

import java.util.Random;
import java.util.Scanner;

public class Gameboard {
    
    
     static String gameboardgrid[][];// this array holds the game, The H and the M
    
    public void createnewgrid(int heigth, int width){// when the player enters  the sizes he wants in the grid, this method gets executed
       gameboardgrid = new String[heigth][width];
        
        for(int row=0;row<heigth;row++){// it takes the number of rows
        for(int column=0;column<width;column++){ // it takes the number of columns
           gameboardgrid[row][column]=""; // it sets everything to empty
        }
        }
        printgrid(heigth,width,gameboardgrid);// calls the printgrid method
    }
    
    
    public void printgrid(int heigth, int width,String gameboardgrid[][]){
        
        // this method prints the grid which the array, which holds the game
    for(int row=0;row<heigth;row++){
                    System.out.print("|");

        for(int column=0;column<width;column++){
            if(gameboardgrid[row][column].length()>0){
                 System.out.print(gameboardgrid[row][column]);
                 System.out.print("|");
            }else{
            System.out.print("_|");// this only prints the borders of the grid
            }
            
                        

        }
            System.out.println("");// a line space so the grid continues next line
        }
    }
    public  String[][] battlehubication(String grid[][],int size,int height,int width){
        
        // this method locates the battle with a random place
        Random rd= new Random();
        
            int row=rd.nextInt(height)+1;
            if(row+size>height){ // this does not allows the randon number to go over the size
            row=row-size;
            }
            int col=rd.nextInt(width)+1;
            if(col+size>width){// this does not allows the randon number to go over the size
            col=col-size;
            }
         
    
         int voh=rd.nextInt(width)+1;
            if(voh>width/2){// this place the battle vertically or horizontally
            
            for(int i=0;i<size;i++){
            grid[row][col+i]="SHIP"; // increase the number of columns to places the ship
            }
            
            }else{
            for(int i=0;i<size;i++){
            grid[row+i][col]="SHIP";// increase the number of rows to places the ship
            }
            
            
            }
   
    return grid; // returns the grid with the battle already placed
    }
    
  
    
    public Boolean gamedescription(){
        
        // this method only prints the game description to the player, it is the first thing to be executed
        Scanner start= new Scanner(System.in);
        String answer;
        Boolean startgame= false;
        System.out.println("Welcome to the Battleship");
        
        System.out.println("PLease have a look at the game description below and type yes when you finish:\n");
        
        System.out.println("1- The maximun of players allowed are 4");
        
        System.out.println("2- You can only play this game if you are at least 12 year old");
        
        System.out.println("3- You will be asked to create the game, the maximun size \n"
                
                + " of the board is 20 and the minimun is 10. Yo can also make a Board like "
                + "10 by 15 or 13 by 14. This are just Examples"); 
        System.out.println("4- The size of the ship would be 30 % the width of the grid, so if the "
                + " width is 10 the size of the ship would be 3");
        
        System.out.println("5- The game ends when the ship has been completly hit");
        
        System.out.println("6- 1 hits equals to 1 score, i miss equals to 2 misses, the person to make the last hit gets 2 points");
        
        System.out.println("7- The player with more scores wins. A player can also be winner even when having negative score");
        Game game= new Game();
        
       answer= game.askuser("Please enter Y if you undertood the rules of the game", "Sorry, please enter an answer").toUpperCase();
       
        if(answer.startsWith("Y")){
            startgame=true;
        }
        return startgame;
    }
}
