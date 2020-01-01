//IMPORT PACKAGES
import java.util.*;

//CLASS
public class LarryAndHisLocker
{
  //MAIN METHOD
  public static void main(String [] args)
  {
    //DECLARATION AND INITIALIATION
    ArrayList<String> permutations2 = new ArrayList<String>(); //Used to store final permutations
    ArrayList<String> permutations1 = new ArrayList<String>(); //Used to store pre-final permutations
    ArrayList<String> permutes = new ArrayList<String>(); //Used to create permutations via rotation
    ArrayList<String> letters = new ArrayList<String>(); //Used to store letters of password
    letters.add("P");
    letters.add("O");
    letters.add("T");
    letters.add("A");
    letters.add("T");
    letters.add("O");
    
    String temp = ""; //Used as temperatory storage when conversion from ArrayList to String is necessary
    
    //COMPUTING
    
    /*Effectively, the plan is to find all permutations of "PO" using rotation:
     *PO rotates to form OP
     *We add the next letter "T" to all previous permutations and get:
     *POT and OPT
     *We then use rotation to find new permutations:
     *POT rotates to form OTP, and TPO
     *OPT rotates to from PTO, and TOP
     *This process continues until all letters are accounted for.*/
    
    permutations2.add(letters.get(0)); //Add "P" to permutations2
    
    //FOR LOOP
    for(int count = 1; count < letters.size(); count++) //For the length of the password (excluding the first letter "P")...
    {
      for(int count2 = 0; count2 < permutations2.size(); count2++) //For the length of permutations2...
      {
       permutations2.set(count2, permutations2.get(count2) + letters.get(count)); //Add the next letter of the password to all of its elements  
       
       permutes.clear(); //Reset permutes
       
       //FOR LOOP
       for(int count3 = 0; count3 < (permutations2.get(count2)).length(); count3++) //For the length of the string from permutations2... 
       {
         permutes.add((permutations2.get(count2)).substring(count3, count3 + 1)); //Add each letter of the string to permutes
       }
       
       //FOR LOOP
       for(int count4 = 0; count4 < permutes.size(); count4++) //For the length of permutes...
       {
         Collections.rotate(permutes, 1); //Rotate it one position
         
         temp = ""; //Reset temp
         
         //FOR LOOP
         for(int count5 = 0; count5 < permutes.size(); count5++) //For the length of permutes...
         {
           temp = temp + "" + permutes.get(count5); //Add its element to form a String, store it in temp
         }
         permutations1.add(temp); //Add the String temp to permutations1  
       }
      }
     permutations2.clear(); //Clear permutations2 
     
     //FOR LOOP
     for(int count6 = 0; count6 < permutations1.size(); count6++) //For the length of permutations1...
     {
       permutations2.add(permutations1.get(count6)); //Add its element to permutations2
     }
     permutations1.clear(); //Reset permutations1
    }
    
    //REMOVING DUPLICATES 
    //Sets do not allow duplicates, therefore, converting to a set and converting back
    
    //DECLARATION AND INITIALIZATION
    Set<String> set = new HashSet<String>(permutations2); //Creating a set with the values of permutations2
    permutations2.clear(); //Clearing permutations2
    permutations2.addAll(set); //Adding all values of the set to permutations2

    //FOR LOOP
    for(int count7 = 0; count7 < permutations2.size(); count7++) //For the length of permutations2...
    {
      System.out.println(permutations2.get(count7)); //Print the element 
    }
    System.out.println("\nThere are " + permutations2.size() + " permutations. Best of luck Larry, 'ol chap!"); //Print number of permutations
  }
}