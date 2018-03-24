/*
 * Lab 4
 * Kelly Mi
 * Online shopping cart printer - allows user to create ShoppingCart and
 * has menu method to allow user to print various ShoppingCart data
 * 3.12.19
 */

//package com.example.lib;
import java.util.Scanner;

public class ShoppingCartManager {
  static final Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
  
    System.out.println("Enter Customer's Name:");
    String name = sc.nextLine();
  
    System.out.println("Enter Today's Date:");
    String date = sc.nextLine();
    System.out.println();
  
    ShoppingCart cart = new ShoppingCart(name, date);
  
    System.out.println("Customer Name: " + cart.getCustomerName());
    System.out.println("Today's Date: " + cart.getDate());
    
    String option = "";
    
    while (!option.equals("q")) {
      if (option.equals("i")) {
        System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
        
        cart.printDescriptions();
      } else if (option.equals("a")) {
        System.out.println("ADD ITEM TO CART");
        ItemToPurchase newItem = new ItemToPurchase();
  
        System.out.println("Enter the item name:");
        newItem.setName(sc.next() + sc.nextLine());
    
        System.out.println("Enter the item description:");
        newItem.setDescription(sc.nextLine());
    
        System.out.println("Enter the item price:");
        newItem.setPrice(sc.nextInt());
    
        System.out.println("Enter the item quantity:");
        newItem.setQuantity(sc.nextInt());
    
        cart.addItem(newItem);
      } else if (option.equals("d")) {
        System.out.println("REMOVE ITEM FROM CART");
        
        System.out.println("Enter name of item to remove:");
        cart.removeItem(sc.next() + sc.nextLine());
      } else if (option.equals("c")) {
        System.out.println("CHANGE ITEM QUANTITY");
        
        System.out.println("Enter the item name:");
        String itemName = (sc.next() + sc.nextLine());
        System.out.println("Enter the new quantity:");
        int itemQty = sc.nextInt();
    
        ItemToPurchase modifier = new ItemToPurchase(itemName, itemQty); //creates new item with default fields except qty and name (to find item to replace)
        cart.modifyItem(modifier); //changes qty field for selected item
      } else if (option.equals("o")) {
        System.out.println("OUTPUT SHOPPING CART");
        cart.printTotal();
      }
      
      if (option.equals("") || option.equals("a") || option.equals("d") || option.equals("c") || option.equals("i") || option.equals("o")) {
        System.out.println();
        System.out.println("MENU");
        System.out.println("a - Add item to cart");
        System.out.println("d - Remove item from cart");
        System.out.println("c - Change item quantity");
        System.out.println("i - Output items' descriptions");
        System.out.println("o - Output shopping cart");
        System.out.println("q - Quit");
        System.out.println();
      }
      System.out.println("Choose an option:");
  
      option = sc.next();
    }
  }
}