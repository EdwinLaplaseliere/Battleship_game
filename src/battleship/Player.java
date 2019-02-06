
package battleship;

public class Player {
    String name,email;
    int  score,age;  
      
    public Player(){// just a constructor to create instances when needed
    
    }
    public Player(String name,String email,int age,int score){
    this.name=name;
    this.email=email;
    this.age=age;
    this.score=score;
    }
    public Player(int score){//just a constructor to set the score
    this.score=score;
    }
    
    //setters and getters methods
    public void setname(String name){
    this.name=name;
    }
    public void setemail(String email){
    this.email=email;
    }
    public void setage(int age){
    this.age=age;
    }
    public void setscore(int score){ 
        
    this.score=score;
    }
    public String getname(){
    return this.name;
    }
    public String getemail(){
    return this.email;
    }
    public int getage(){
    return this.age;
    }
    public int getscore(){
    return this.score;
    }
    
    public boolean validatename(String name){
        
        // this method validates the name with spaces, only full name, only leters
     boolean rightinfo=false;
      name=name.replaceAll("\\s", "-"); // replaces spaces with - to then being cheked in the lines below
       
         if(name.matches("[a-zA-Z-]+") && name.contains("-")){ // validates the leters and the the spaces
         if(name.startsWith("-")){// validates if the name starts with spaces, it gets rid of it
         name=name.replaceFirst("-", "");// get rid of the spaces
         }
         if(name.endsWith("-")){
                 name = name.substring(0,name.length() - 1);// get rid of the last space in case it has any
         }
         if (name.contains("-")){// checks the spaces in the full name
          String pairs[]=name.split("-");
         if(pairs[0].equals("") || pairs[1].equals("")){// checks that there is something entered
         rightinfo=false;
             System.out.println("Please enter a full name such as: Edwin Garces");
         }   else{
          name=name.replaceAll("-", " ");
         rightinfo=true;
         }
         }else{
         rightinfo=false;
         System.out.println("Please enter a full name such as: Edwin Garces");
         }
         
         
         }else{
         rightinfo=false;
             System.out.println("please enter full name eg:\n Edwin Garces");
         }    
        
    return rightinfo;
    }
    
    public boolean validateemail(String email){
        
        // validate the email with @ and . 
        // it checks it the @ is before the .
    boolean rightinfo=false;
     if (email.contains("@") && email.contains(".")){
              email=email.replaceAll("\\s", "");
         String pairs[]=email.split("@");
             if(pairs[0].contains("@") || pairs[0].contains(".") || pairs[1].contains("@")){
             rightinfo=false;
             System.out.println("Sorry, wrong email, please enter a valid one, eg:\n example@gmail.com");
             }else{
             rightinfo=true;
             }
         }else{
             rightinfo=false;
             System.out.println("Sorry, wrong email, please enter a valid one, eg:\n example@gmail.com");
         }    
        return rightinfo;
    }
    
    public boolean validateage(String age){
        // validate the age between 12 and 100
        boolean rightinfo=false;
        int ageofplayer=0;
     if(age.matches("[0-9]+")){
          ageofplayer=ageofplayer+Integer.parseInt(age);
          if(ageofplayer>11 && ageofplayer<101){
          rightinfo=true;
          }else{
          rightinfo=false;
              System.out.println("Sorry only ages between 12 and 100 allowed");
          }
         }else{
         rightinfo=false;    
         System.out.println("Please enter a real age, eg:  20");
         }
    return rightinfo;
    }
}
