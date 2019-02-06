
package battleship;


public class Battleship {
public Battleship(){
Gameboard gameboard= new Gameboard();// makes an instance of the class gameboard

boolean start = gameboard.gamedescription();// if the user understand the rules of the game, the game stars
if(start){// if starts is true the game starts
    System.out.println("\nLet\'s get started... ");
Game G= new Game();// an instance of the class Game
G.play(); // play is a method that allows the game to start
}else{
    System.out.println("Thanks, have a nice day");// it executes if the payers does not understand the game
}
}
    
    public static void main(String[] args) {
        //calls the constructor
        new Battleship();
    }
    
}
