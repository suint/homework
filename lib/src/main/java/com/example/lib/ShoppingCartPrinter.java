/*
 * Lab 3
 * Kelly Mi
 * Online shopping cart - prompts user to create two instances of ItemToPurchase,
 * set their names/prices/quantities, and gives total cost
 * 3.5.19
 */
package com.example.lib;
import java.util.Scanner;

public class ShoppingCartPrinter {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Item 1"); //create item #1
    ItemToPurchase item1 = new ItemToPurchase();
    System.out.println("Enter the item name:");
    item1.setName(sc.nextLine());
    System.out.println("Enter the item price:");
    item1.setPrice(Integer.parseInt(sc.nextLine()));
    System.out.println("Enter the item quantity:");
    item1.setQuantity(Integer.parseInt(sc.nextLine()));
    System.out.println();
    
    System.out.println("Item 2"); //create item #2
    ItemToPurchase item2 = new ItemToPurchase();
    System.out.println("Enter the item name:");
    item2.setName(sc.nextLine());
    System.out.println("Enter the item price:");
    item2.setPrice(Integer.parseInt(sc.nextLine()));
    System.out.println("Enter the item quantity:");
    item2.setQuantity(Integer.parseInt(sc.nextLine()));
    System.out.println();
    
    System.out.println("TOTAL COST"); //total cost of indiv. items and then total
    System.out.println(item1.getName() + " " + item1.getQuantity() + " @ $" + item1.getPrice() + " = $" + (item1.getQuantity() * item1.getPrice()));
    System.out.println(item2.getName() + " " + item2.getQuantity() + " @ $" + item2.getPrice() + " = $" + (item2.getQuantity() * item2.getPrice()));
    System.out.println();
    System.out.println("Total: $" + ((item1.getPrice() * item1.getQuantity()) + (item2.getQuantity() * item2.getPrice())));
  }
}
