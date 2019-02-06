 
package battleship;


import static battleship.Gameboard.gameboardgrid;
import java.util.Scanner;
import java.util.Random;

public class Game {
    
    Gameboard GB= new Gameboard();
    
    Scanner Scan= new Scanner(System.in);
    Random Rd= new Random();
    
    int Players; //this variable takes a number of players entered by the user
    Player player= new Player();
    
    
    
     Player p1,p2,p3,p4; //here i create 4 players as the game only works with 4 players
      
      int column,row;//this determine the size of the grid, the user inputs this values later on in the program
    
    public String askuser(String required, String incaseof){
    /*this method takes two string parameters, which are required and incaseof
       # required: takes what the user is require to enter
       # incase of tell the user to enter again the information in case of a empty string
      this method returns a string value, which is whatever the user enters  
        
       "THIS MAKES THE CODE REUSABLE BY CALLING THE METHOD ALL THE TIME INSTEAD OF ASKING THE USER OVER AND OVER" 
        
        */    
    String answer="";
    
        System.out.println(required);
        
        do{
        answer= Scan.nextLine();
        
        if(answer.equals("")){
            
            System.out.println(incaseof);
        }
        }while(answer.equals(""));
    
    return answer;
    }
    
    
    
   
    public void play(){
        
        // here is where is game starts
        //#rightsize would be true is the size chosen by the user is in a range from 10 to 20
        //#rightinfo tells whether the information is valid or no. this apply to the email, name and age
        boolean rightsize,rightinfo;
       
        do{
            // this do while goes on while the size entered by the user is not right
        String width=askuser("Please enter how many rows you want inyour grid","Sorry,invalid input, please enter a valid number");
        
        String heigth=askuser("Please enter how many columns you want inyour grid","Sorry,invalid input, please enter a valid number");
        //here the program checks whether the user entered numbers or not
     if(width.matches("[0-9]+") && heigth.matches("[0-9]+")){
     column=Integer.parseInt(width);
     
     row=Integer.parseInt(heigth);
     //here the program checks the range between 10 and 20
     
     if(column>9 && column<21 && row>9 && row<21){
         
     rightsize=true;    
     
     GB.createnewgrid(row, column);
     
     }else{
     rightsize=false;
         System.out.println("Sorry, the minimun size is 10 and the maximun is 20");
     }
    
    }else{
     rightsize=false;
         System.out.println("Sorry, only numbers allowed");
     }
       }while(rightsize==false);
       
       do{
           // this do while loop goes on until there is a right number of users
    String players= askuser("how many payers will be in the game? the maximun is 4",
            
            "Sorry,invalid input, the number of players in the game the maximun is 4");
    if(players.matches("[0-9]+")){
        
    Players=Integer.parseInt(players);
    if(Players<5 && Players>0){ // it can only be 4 users
        
    rightinfo=true;    
  
    playersinfo(Players);

    }else{
    rightinfo=false;
        System.out.println("Sorry, the minimun amount of players is 1 and the maximun is 4");
    }
    }else{
    rightinfo=false;
        System.out.println("Sorry, only numbers allowed, please try it again");
    }
    }while(rightinfo==false);
    }
    
   
    
     public void playersinfo(int numofplayers){
         /*
         #This method takes a number of players as parameter and acording to it give a for loop a number of time to repeat
         # it asks the name of the player, the age and the email
         # it calls a validation method located in the player class 
         # finally it saves the user information givig a default score of 0 to start the game
         # it also uses the method askuser to get the information from the user
         */
        String name,email,age;//this variables will store the user's information to be sent to the player class 
        
       int ageofplayer=0;// default age value, this will change after the player gives a real age
       
     for(int p=1;p<=numofplayers;p++){// this for loop start at player 1 and finishes when it reaches the number of players
         // it goes on unti it has save the information of the total of players
         boolean rightinfo;
         System.out.println("please enter information for player number "+p);
         
         do{
         name=askuser("Please enter full name of the player"," Sorry, wrong input, please enter full name");
         
         rightinfo=player.validatename(name);
         
         }while(rightinfo==false);
         do{
         email=askuser("Please enter email of the player"," Sorry, wrong input, please enter email of the payer");
         
         rightinfo=player.validateemail(email);
         
         
         }while(rightinfo==false);
         do{
         age=askuser("Please enter age of the player"," Sorry, wrong input, please enter age of the payer");
         rightinfo=player.validateage(age);
         
         if(rightinfo){
         ageofplayer=Integer.parseInt(age);
         }
         
         }while(rightinfo==false);
         saveuserinfo(p,  name, email,ageofplayer,0);
         // p represent the player number, so p would be
         //the reference number when saving the information of the user in saveuserinfo method
         
     }
     //once the foor loop finishes the game starts
     startplaying();

     
     }
     
     
     public void saveuserinfo(int num, String name, String email, int age,int score){
    /*
        #this method takes a number which woud be the number of the player, 
         and the information, such as name, email, age and initial score
   
         */
     switch(num){//this switch statement takes a numbers and works according to it
             case 1:
                 p1 = new Player(name,email,age,score);
             break;
             case 2:
                  p2 = new Player(name,email,age,score);
             break;
             case 3:
                  p3 = new Player(name,email,age,score);
             break;
             case 4:
                  p4 = new Player(name,email,age,score);
             break;
             default:
                 
                 break;
     }    
     
     }
     
     public void startplaying(){
         // here is when the game starts itself
         int rowchoosenbyplayer,columnchoosenbyplayer; // this makes the coordinate chosen
         
         boolean rightchoice=false;// it tells whether the coordinate choosen is vaid and in the range or no
         
         int size=column/3;// this set the size of the ship as it is the 30% of the width of the grid
         
         String arraywithbattlehubication[][]=new String[row][column];// this array contains the battle hubication with a random number generation
         
         
         System.out.println("Lets start the game");
         
    arraywithbattlehubication=GB.battlehubication(arraywithbattlehubication, size, row, column);
//battleubication is the method that creates te ship and it takes an array, a size previously mentioned, the number of rows and columns
    
        while(size!=0){// this whie loop wil finish when the ship has been completly hit
             
    for(int player=1;player<=Players;player++){
    do{    
    String row=askuser("What row do u want to select?","Sorry nothing was entered");
    // the player chose a row 
    String Column=askuser("What column do u want to select?","Sorry nothing was entered");
    //the payer choose a column
    rowchoosenbyplayer=Integer.parseInt(row);
    
    columnchoosenbyplayer= Integer.parseInt(Column);
    
    if(rowchoosenbyplayer>this.row || columnchoosenbyplayer>column || rowchoosenbyplayer<1 || columnchoosenbyplayer<1){
    rightchoice=false;
    System.out.println("Sorry, the size of the grid is "+ this.row+ " by "+ column +"Please choose a coordinate in that range, do not unclude 0");
    // just in case the user types 0 or a numbers higher than the size
    }else if(gameboardgrid[rowchoosenbyplayer-1][columnchoosenbyplayer-1].length()>0){
    rightchoice=false;
    System.out.println("Sorry that Row and column has already been selected");
    // just in case the player selects an coodinate that has already been selected
    }else {
    rightchoice=true;
    }
    
    
    }while(rightchoice==false);
    // in the array where the ship is saved, in each of the coordiates is the word SHIP keep, so if the 
    // coordinate chossen by the user get to one of those places where the SHIP word is, it means the hit the ship and a H is places in the 
    //game array which is called gameboradgrid
            if( arraywithbattlehubication[rowchoosenbyplayer-1][columnchoosenbyplayer-1]=="SHIP"){
                
                gameboardgrid[rowchoosenbyplayer-1][columnchoosenbyplayer-1]="H";
                boolean lasthit=false;
                
                size=size-1;
                // while the ship is being hit, the size of it decrease
                if(size==0){
                lasthit=true; // if it is the last square of the ship, it is 2 points 
                }
                setscores(player,true,lasthit);


                
            }else{
                
                gameboardgrid[rowchoosenbyplayer-1][columnchoosenbyplayer-1]="M";
                setscores(player,false,false);
                
            }
    GB.printgrid(row, column, gameboardgrid);// this methods prints the grid which all the value in the array
                
    
             }
         
        }
         
       printscores(Players);  
     }
     
     public void setscores(int player,boolean Hit,boolean last){
         // tis methos sets the scores, takes a boolean variable to see if the player missed of hit and takes a boolean
         // variable to see if it is the last pasrt of the ship or not
         int points=1;
          if(last){
              points=2; // if it is the last part of the ship, the players is given 2 points
          }
     switch(player){
         // switch statement takes the player a assign the score
        
         case 1:
             if(Hit){
             p1.setscore(p1.getscore()+points);
             }else{
             p1.setscore(p1.getscore()-2);
             }
         break; 
         case 2:
              if(Hit){
             p2.setscore(p1.getscore()+points);
             }else{
             p2.setscore(p1.getscore()-2);
             }
         break; 
         case 3:
              if(Hit){
             p3.setscore(p1.getscore()+points);
             }else{
             p3.setscore(p1.getscore()-2);
             }
         break; 
         case 4:
              if(Hit){
             p4.setscore(p1.getscore()+points);
             }else{
             p4.setscore(p1.getscore()-2);
             }
         break; 
         
     }
         
         
     }
     
     public void printscores(int Players){
         // this method takes the scores a print them out
         System.out.println("Name"+ "         "+"Score");
         for(int i=1;i<=Players;i++){
         if(i==1){
         System.out.println( p1.getname()+"     "+p1.getscore());
         }else if(i==2){
         System.out.println(p2.getname()+"     "+p2.getscore());
         }else if(i==3){
         System.out.println(p3.getname()+"     "+p3.getscore());
         }else if(i==4){
         System.out.println(p4.getname()+"     "+p4.getscore());
         }
         
         }
         
         printwiner(Players);
     }
     
     
    public void printwiner(int players){
        // this method prints the winner according to their scores
        // it works accordin to a number of players which has as parameter
    int s1=0,s2=0,s3=0,s4=0;     
        if(players==1){
        s1=s1+p1.getscore();
        }
        else if(players==2){
        s1=s1+p1.getscore();
        s2=s2+p2.getscore();
        }
        else if(players==3){
        s1=s1+p1.getscore();
        s2=s2+p2.getscore();
        s3=s3+p3.getscore();
        }
        else if(players==4){
        s1=s1+p1.getscore();
        s2=s2+p2.getscore();
        s3=s3+p3.getscore();
        s4=s4+p4.getscore(); 
        }
    
    
    
    
   if(players==1){
   
   System.out.println(p1.getname()+" " +"you won with  "+ s1 +" "+"points" ); // takes the number of the winner player and display it saying it won
   
   }else if(players==2){
   if(s1>s2 ){// a comparison to see which score is higher
         System.out.println("The winner is"+" " +p1.getname()+" " +"with "+ s1 +" "+"points" );
     }else if(s2>s1){
     System.out.println("The winner is"+" " +p2.getname()+" " +"with "+ s2 +" "+"points" );
     }
    else{
         System.out.println("There was a draw");
     }
   }
   else if(players==3){
   if(s1>s2 && s1>s3 ){
       // it is a comparison of the scores
         System.out.println("The winner is"+" " +p1.getname()+" " +"with "+ s1 +" "+"points" );
     }else if(s2>s1 && s2>s3){
     System.out.println("The winner is"+" " +p2.getname()+" " +"with "+ s2 +" "+"points" );
     }else if(s3>s1 && s3>s2){
     System.out.println("The winner is"+" " +p3.getname()+" " +"with "+ s3 +" "+"points" );
     }
    else{
         System.out.println("There was a draw");
     }
   }
   else if(players==4){
   if(s1>s2 && s1>s3  && s1>s4){
       //this determines the winner of the game
     System.out.println("The winner is"+" " +p1.getname()+" " +"with "+ s1 +" "+"points" );
     }else if(s2>s1 && s2>s3 && s2>s4){
     System.out.println("The winner is"+" " +p2.getname()+" " +"with "+ s2 +" "+"points" );
     }else if(s3>s1 && s3>s2 && s3>s4){
     System.out.println("The winner is"+" " +p3.getname()+" " +"with "+ s3 +" "+"points" );
     }else if(s4>s1 && s4>s2 && s4>s3){
     System.out.println("The winner is"+" " +p4.getname()+" " +"with "+ s4 +" "+"points" );
     }
    else{
         System.out.println("There was a draw");
     }
   }
     }
    
    
}
