/*
 * Lab 1
 * Kelly Mi
 * Finds range of a projectile given angle and velocity,
 * draws an inverted triangle of two alternating characters,
 * or finds the most common character in a string.
 * 2.19.18
 */

package com.example.lib;
import java.util.*;

public class Lab1 {
  final static double GRAVITATIONAL_ACC = 9.8;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
  
    String txtMsg = sc.nextLine();
    String newMsg = txtMsg;
  
    System.out.println("You entered: " + txtMsg);
  
    boolean bff = false;
    boolean idk = false;
    boolean jk = false;
    boolean tmi = false;
    boolean ttyl = false;
    
    //finds if abbreviations (TTYL, BFF, IDK, TMI, JK) are used
    for (int i = 0; i < newMsg.length(); i++) {
      if (i < (newMsg.length() - 3)) {
        if ((newMsg.charAt(i) == 'T') && (newMsg.charAt(i + 1) == 'T') && (newMsg.charAt(i + 2) == 'Y') && (newMsg.charAt(i + 3) == 'L')) {
          ttyl = true;
          newMsg = newMsg.substring(0, i) + "talk to you later" + newMsg.substring(i + 4, newMsg.length()); //expands abbreviation
        }
      }
      if (i < (newMsg.length() - 2)) {
        if ((newMsg.charAt(i) == 'B') && (newMsg.charAt(i + 1) == 'F') && (newMsg.charAt(i + 2) == 'F')) {
          bff = true;
          newMsg = newMsg.substring(0, i) + "best friend forever" + newMsg.substring(i + 3, newMsg.length());
        }
        if ((newMsg.charAt(i) == 'I') && (newMsg.charAt(i + 1) == 'D') && (newMsg.charAt(i + 2) == 'K')) {
          idk = true;
          newMsg = newMsg.substring(0, i + (newMsg.length() - newMsg.length())) + "I don't know" + newMsg.substring(i + (newMsg.length() - newMsg.length()) + 3, newMsg.length());
        }
        if ((newMsg.charAt(i) == 'T') && (newMsg.charAt(i + 1) == 'M') && (newMsg.charAt(i + 2) == 'I')) {
          tmi = true;
          newMsg = newMsg.substring(0, i) + "too much information" + newMsg.substring(i + 3, newMsg.length());
        }
      }
      if (i < (newMsg.length() - 1)) {
        if ((newMsg.charAt(i) == 'J') && (newMsg.charAt(i + 1) == 'K')) {
          jk = true;
          newMsg = newMsg.substring(0, i) + "just kidding" + newMsg.substring(i + 2, newMsg.length());
        }
      }
    }
    
    //prints replacements in alphabetical order
    if (bff) {
      System.out.println("Replaced \"BFF\" with \"best friends forever\"");
    }
    if (idk) {
      System.out.println("Replaced \"IDK\" with \"I don't know\"");
    }
    if (jk) {
      System.out.println("Replaced \"JK\" with \"just kidding\"");
    }
    if (tmi) {
      System.out.println("Replaced \"TMI\" with \"too much information\"");
    }
    if (ttyl) {
      System.out.println("Replaced \"TTYL\" with \"talk to you later\"");
    }
    
    System.out.println("Expanded: " + newMsg);
    /*if ((txtMsg.indexOf('B') == (txtMsg.indexOf('F') - 1)) && (txtMsg.charAt(txtMsg.indexOf('F') + 1) == 'F')){
      System.out.println("BFF: best friend forever");
    }
    if ((txtMsg.indexOf('I') == (txtMsg.indexOf('D') - 1)) && (txtMsg.indexOf('D') == txtMsg.indexOf('K') - 1)){
      System.out.println("IDK: I don't know");
    }
    if ((txtMsg.indexOf('T') == (txtMsg.indexOf('M') - 1)) && (txtMsg.indexOf('M') == txtMsg.indexOf('I') - 1)){
      System.out.println("TMI: too much information");
    }
    if ((txtMsg.charAt(txtMsg.indexOf('T') + 1) == 'T') && (txtMsg.indexOf('T') == txtMsg.indexOf('Y') - 2) && (txtMsg.indexOf('Y') == txtMsg.indexOf('L') - 1)){
      System.out.println("TTYL: talk to you later");
    }
    if (txtMsg.indexOf('J') == (txtMsg.indexOf('K') - 1)){
      System.out.println("JK: just kidding");
    }*/
    
    /*
    System.out.println("Type 1 to solve a basic physics problem.");
    System.out.println("Type 2 to draw a particular pattern.");
    System.out.println("Type 3 to find the most common character in a string.");

    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    
    try {
      if (a == 1) {
        System.out.println("Enter values theta (angle) and v (m/s), separated by a space.");
        System.out.println(computerDistanceToLanding(sc.nextFloat(), sc.nextFloat()) + " meters to landing");
      } else if (a == 2) {
        System.out.println("Enter a positive number and two characters, separated by spaces.");
        drawLayeredPyramid(sc.nextInt(), sc.next().charAt(0), sc.next().charAt(0));
      } else if (a == 3) {
        System.out.println("Enter a string on its own line.");
        String queryString = sc.next() + sc.nextLine(); //forces nextLine to wait for input
        System.out.println(mostCommonChar(queryString) + " is the most common character in that string.");
      } else {
        throw new Exception();
      }
    } catch (Exception e) {
      System.err.println("Error - not a valid response.");
    }
  }
  //finds range of a projectile given angle and velocity
  static float computerDistanceToLanding(float thetaDegrees, float initialVelocityMPS){
    float a = (float)(((Math.pow(initialVelocityMPS, 2)) / GRAVITATIONAL_ACC) * Math.sin(2 * Math.toRadians(thetaDegrees)));
    //this formula: (v^2/g)(sin 2theta) (height assumed to be zero)
    
    return a;
  }
  //draws an inverted triangle of two alternating characters
  static void drawLayeredPyramid(int numLayers, char firstChar, char secondChar){
    for (int i = 0; i < numLayers; i++){
      for (int k = 0; k < i; k++){ //for left-aligned text
        System.out.print(" ");
      }
      for (int j = 0; j < (numLayers - i); j++){
        if ((i % 2) == 1){
          System.out.print(firstChar);
        } else {
          System.out.print(secondChar);
        }
      }
      System.out.println();
    }
  }
  //finds the most common character in a string
  static char mostCommonChar(String queryString){
    int commonestCharLoc = 0;
    int highestRate = 0; //highest number of occurrences for any letter
    
    for (int i = 0; i < queryString.length(); i++){
      char thisChar = queryString.charAt(i);
      int thisCharRate = 0;
      
      for (int j = 0; j < queryString.length(); j++){
        if (thisChar == queryString.charAt(j)){
          thisCharRate++;
        }
      }
      
      //find character most common & highest in alphabet
      if (thisCharRate > highestRate || (thisCharRate == highestRate && (Character.compare(thisChar, queryString.charAt(commonestCharLoc)) < 0))) {
        commonestCharLoc = i;
        highestRate = thisCharRate;
      }
    }
    return queryString.charAt(commonestCharLoc);*/
  }
}
