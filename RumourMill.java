/* CSCI 1110 - Assignment 6
 * This program will print teller and listener by LinkedList,
 * use static method to find tellers, listeners, person who is heard only,
 * and traces who spread/heard the rumour
 * <Jerry Guo> <B00779028> <2018.11.29>
 */
import java.util.*;
public class RumourMill {
  public static void main (String [] args) {
    Scanner scan = new Scanner (System.in);
    
    /* Using LinkedList to print all the tellers and listeners
     */
    LinkedList rumours = new LinkedList(); //Create LinkedList rumours
    //Using while loop to read all the tellers and listeners till *
    while (true) {  
      String t =  scan.next(); //State teller      
      //Stop at *
      if(t.equals("*")) {
         break;
       }
      String l =  scan.next(); //State listener
      Node node = new Node (t, l, null); //State the node
      rumours.addToEnd(t, l); //Add the content to the end
    }    
    String name = scan.next(); //State the name for trace method
    
    rumours.enumerate(); //Print all the tellers and listeners
    System.out.println(); //Start a new line 
    
    //For static methods
    ArrayList <String> told = tellers(rumours);
    ArrayList <String> heard = listeners(rumours);
    ArrayList <String> heardOnly = heardNoSpread(rumours);
    ArrayList <String> traceRumour = trace(rumours,name);
    //Print all the ArrayLists by static methods
    System.out.println(told);
    System.out.println(heard);
    System.out.println(heardOnly);
    System.out.println(traceRumour);
  }
  
  //tellers method
  public static ArrayList <String> tellers (LinkedList rumours) {
    ArrayList <String> told = new ArrayList <String>(); //State the ArrayList tellers
    Node curr = rumours.getFront(); //State the curr node   
    while (curr!=null) {             
       String currTeller = curr.getTeller(); //State the data for teller
       //When the String is repeated, do not add
       if(!told.contains(currTeller)){
         told.add(currTeller); //Add currTeller to tellers ArrayList
       }
       curr=curr.getNext(); //Scan the next curr node
    }    
    return told; 
  }
  
  //listeners method
  public static ArrayList <String> listeners (LinkedList rumours) {
    ArrayList <String> heard = new ArrayList <String>(); //State an ArrayList listeners
    Node curr = rumours.getFront(); //State the curr node   
    while (curr!=null) {             
       String currListener = curr.getListener(); //State the data for listener
       //When the String is repeated, do not add
       if(!heard.contains(currListener)){
         heard.add(currListener); //Add currListener to listener ArrayList
       }
       curr=curr.getNext(); //Scan the next curr node
    }    
    return heard;               
  }
  
  //heardNoSpread method
  public static ArrayList <String> heardNoSpread (LinkedList rumours) {
    ArrayList <String> heardOnly = new ArrayList <String>(); //State an ArrayList heardNoSpread
    Node curr = rumours.getFront(); //State the curr node    
    while (curr!=null) {             
       String listenerName = curr.getListener(); //State the data for listener
       //Add the person who is listener but not teller
       if(!rumours.containsTeller(listenerName)){
         //When the String is repeated, do not add
         if(!heardOnly.contains(listenerName)){
           heardOnly.add(listenerName); //Add listenerName to heardOnly ArrayList
         }
       }
       curr=curr.getNext(); //Scan the next curr node
     }   
     return heardOnly; 
   }
  
  //trace method
  public static ArrayList <String> trace (LinkedList rumours, String name) {
    ArrayList <String> traceRumour = new ArrayList <String>(); //State an ArrayList trace
    Node curr = rumours.getFront(); //State the curr node     
    while(curr!=null){
      //When the traced name is matched with teller 
      if(curr.getTeller().equals(name)){
        traceRumour.add(curr.getTeller()); //Add this traced teller
        name = curr.getListener(); //Find the listener who heard from this teller
      }
      curr = curr.getNext(); //Scan the next curr node
    }
    
    /* Find the final listener by the final teller
     */
    curr = rumours.getFront(); //State the curr node
    String name2 = traceRumour.get(traceRumour.size()-1); //Start from the final name of ArrayList trace 
    while(curr!=null){
      //Find the final teller
      if(curr.getTeller().equals(name2)){
        traceRumour.add(curr.getListener()); //Add the listener who heard from the final teller
        break;
      }
      curr = curr.getNext(); //Scan the next curr node
    }
    return traceRumour; 
   }
  
 }