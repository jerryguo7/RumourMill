/* CSCI 1110 - Assignment 6
 * This program will print teller and listener by LinkedList,
 * use static method to find tellers, listeners, person who is heard only,
 * and traces who spread/heard the rumour
 * <Jerry Guo> <B00779028> <2018.11.29>
 */

//Class Node 
public class Node{ 
   private String teller;
   private String listener;
   private Node next;
  
   //Constructor 
   public Node(String t, String l, Node n){ 
      teller = t; 
      listener = l;
      next = n; 
   } 
   
   //getTeller
   public String getTeller(){ 
      return teller;
   } 
  
   //getListener
   public String getListener(){ 
      return listener;
   }
  
   //getNext
   public Node getNext(){ 
      return next;
   }
   
   //setTeller
   public void setTeller(String t){ 
      teller = t;
   }
  
   //setListener
   public void setListener(String l){ 
      listener = l;
   }
  
   //setNext
   public void setNext(Node n){ 
      next = n; 
   } 
  
   //toString
   public String toString(){ 
      return teller + " " + listener + "-->"; 
   } 
  
}
