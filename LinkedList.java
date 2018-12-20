/* CSCI 1110 - Assignment 6
 * This program will print teller and listener by LinkedList,
 * use static method to find tellers, listeners, person who is heard only,
 * and traces who spread/heard the rumour
 * <Jerry Guo> <B00779028> <2018.11.29>
 */

//Class LinkedList
import java.util.*;
public class LinkedList{ 
   private Node front; 
   private int count; 
  
   //Constructor 
   public LinkedList(){ 
      front = null; 
      count = 0; 
   } 
  
   //Add a node to the front of the LinkedList 
   public void addToFront(String t, String l){ 
      Node n = new Node(t, l, front);        
      front = n;
      count++; 
   } 

   //Get the current size of the LinkedList 
   public int size(){ 
      return count;
   } 
  
   //Check if the LinkedList is empty 
   public boolean isEmpty(){ 
      return count==0; 
   } 
  
   //Clear the LinkedList 
   public void clear(){ 
      front = null; 
      count=0;
   } 
  
   //Get teller of the first node 
   public String getFrontTeller() { 
      if (front==null)
         return "Empty list"; 
      else
         return front.getTeller(); 
   }  
  
   //Get listener of the first node 
   public String getFrontListenter() { 
      if (front==null)
         return "Empty list"; 
      else
         return front.getListener(); 
   }
  
   //New method added, get the first node 
   public Node getFront() { 
      return front; 
   }   
    
   //Add a node to the end of the LinkedList 
   public void addToEnd(String t, String l){ 
      Node n = new Node(t, l, null);
      //Return false when empty
      if (isEmpty()) {
        front = n;
      }
      else {
        Node curr = front; //State the curr node
        while (curr.getNext()!=null) {  
         curr = curr.getNext();//Scan the next curr node 
        }
        curr.setNext(n); //Add the node by set method
      }
      count++; 
   }
  
   //Scan the LinkedList and print contents 
   public void enumerate() { 
      Node curr = front; //State the curr node
      while (curr!=null) { 
         System.out.print(curr); //Print the next curr node
         curr = curr.getNext(); //Scan the next curr node
      }       
   }
  
   //containsTeller
   public boolean containsTeller (String name){
      //Return false when empty
      if(isEmpty()){
        return false;
      } 
      else {
        Node curr  = front; //State the curr node
        while(curr!=null){
          //When this teller is the same as this name
          if(curr.getTeller().equals(name)){
            return true;
          }
          curr = curr.getNext(); //Scan the next curr node
        }
        return false;
      }
    }
  
    //containsListener
    public boolean containsListener (String name){ 
      //Return false when empty
      if(isEmpty()){
        return false;
      } 
      else {
        Node curr  = front; //State the curr node
        while(curr!=null){
          //When this listener is the same as this name
          if(curr.getListener().equals(name)){
            return true;
          }
          curr = curr.getNext(); //Scan the next curr node
        }
        return false;
      }
    }
    
  
}